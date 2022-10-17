package testspringboot.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import testspringboot.models.api.coindesk.Bpi;
import testspringboot.models.api.coindesk.BpiDesc;
import testspringboot.models.api.coindesk.BpiInfo;
import testspringboot.models.api.coindesk.BpiInfoDesc;
import testspringboot.models.api.coindesk.CoinDeskApiResponse;
import testspringboot.models.api.coindesk.Time;
import testspringboot.models.api.currency.SelectCurrencyInfo;
import testspringboot.models.api.currency.SelectCurrencyResponse;

@Service
public class CoinDeskService {

	@Autowired
	private CurrencyService currencyService;

	@Autowired
	private ObjectMapper objectMapper;

	public final DateFormat fullDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/**
	 * 呼叫API
	 * 
	 * @return API values
	 */
	private String callCoinDesk() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
	}

	/**
	 * 提供回傳值
	 * 
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	public String sendCoinDesk() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		CoinDeskApiResponse coinDeskResponse = null;
		try {
			coinDeskResponse = objectMapper.readValue(callCoinDesk(), CoinDeskApiResponse.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

//		Time convertTime = convertTime(coinDeskResponse);
		BpiInfo convertBpi = convertBpi(coinDeskResponse);
		System.out.println("");
		return "";
	}

	/**
	 * 轉換時間
	 * 
	 * @param coinDeskApiResponse
	 * @return
	 */
	private Time convertTime(CoinDeskApiResponse coinDeskApiResponse) {
		Time time = coinDeskApiResponse.getTime();
		// convert Time
		Date convertUpdated = null;
		Date convertUpdatedISO = null;
		Date convertUpdateduk = null;

		try {
			convertUpdated = fullDateFormat.parse(time.getUpdated());
			convertUpdatedISO = fullDateFormat.parse(time.getUpdatedISO());
			convertUpdateduk = fullDateFormat.parse(time.getUpdateduk());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Time convertDataTime = new Time();
		convertDataTime.setUpdated(convertUpdated.toString());
		convertDataTime.setUpdatedISO(convertUpdatedISO.toString());
		convertDataTime.setUpdateduk(convertUpdateduk.toString());
		return convertDataTime;
	}

	/**
	 * 取得中文幣別
	 * 
	 * @param coinDeskApiResponse
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private BpiInfo convertBpi(CoinDeskApiResponse coinDeskApiResponse) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Bpi bpi = coinDeskApiResponse.getBpi();

		// 取得原始幣別資訊
		BpiInfo bpiInfo = new BpiInfo();

//		Map<String, Object> map = objectMapper.convertValue(bpi, Map.class);
		Map<String, BpiDesc> map = objectMapper.convertValue(bpi, new TypeReference<Map<String, BpiDesc>>() {
		});
		for (String currency : map.keySet()) {
			String first = currency.substring(0,1);
			String last = currency.substring(1).toLowerCase();

			BpiDesc bpiDesc = map.get(currency);
			BpiInfoDesc bpiInfoDesc = new BpiInfoDesc();
			bpiInfoDesc.setCode(bpiDesc.getCode());
			bpiInfoDesc.setRate(bpiDesc.getRate());
			Method setBpiInfoFieldMethod = bpiInfo.getClass().getMethod("set" + first + last, BpiInfoDesc.class);
			setBpiInfoFieldMethod.invoke(bpiInfo, bpiInfoDesc);
		}

		// 取得中文幣別資訊
		SelectCurrencyResponse selectCurrencyResponse = currencyService.selectCurrencyName();
		List<SelectCurrencyInfo> selectCurrencyInfoList = selectCurrencyResponse.getSelectCurrencyInfoList();

		// field[] field
		for (SelectCurrencyInfo selectCurrencyInfo : selectCurrencyInfoList) {
			String first = selectCurrencyInfo.getCurrencyId().substring(0,1);
			String last = selectCurrencyInfo.getCurrencyId().substring(1).toLowerCase();
			try {
				Method bpiInfoFieldMethod = bpiInfo.getClass().getMethod("get" + first + last);
				BpiInfoDesc bpiInfoDesc = (BpiInfoDesc) bpiInfoFieldMethod.invoke(bpiInfo);
				bpiInfoDesc.setDescription(selectCurrencyInfo.getCurrencyName());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return bpiInfo;
	}
}

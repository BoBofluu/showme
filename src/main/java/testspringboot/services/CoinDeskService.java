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


	/**
	 * 呼叫外部API
	 * 
	 * @return API values
	 */
	private String callCoinDesk() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
	}

	/**
	 * 取得幣別資訊(中文, 英文, 匯率, 時間)
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
	public String sendCoinDesk() {
		CoinDeskApiResponse coinDeskResponse = null;
		try {
			coinDeskResponse = objectMapper.readValue(callCoinDesk(), CoinDeskApiResponse.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Time convertTime = convertTime(coinDeskResponse);
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
		
		DateFormat fullDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z");

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
	 * 將中文幣別組成
	 * 
	 * @param coinDeskApiResponse
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private BpiInfo convertBpi(CoinDeskApiResponse coinDeskApiResponse) {
		// 取得原始幣別資訊
		Bpi bpi = coinDeskApiResponse.getBpi();
		// 欲回傳的幣別資訊
		BpiInfo bpiInfo = new BpiInfo();

		Map<String, BpiDesc> map = objectMapper.convertValue(bpi, new TypeReference<Map<String, BpiDesc>>() {});
		// 將原始幣別資訊映射至回傳資訊
		for (String currency : map.keySet()) {
			String first = currency.substring(0,1);
			String last = currency.substring(1).toLowerCase();
			try {
				// 原始幣別內部資料
				BpiDesc bpiDesc = map.get(currency);
				// 回傳幣別內部資料
				BpiInfoDesc bpiInfoDesc = new BpiInfoDesc();
				
				bpiInfoDesc.setCode(bpiDesc.getCode());
				bpiInfoDesc.setRate(bpiDesc.getRate());
				// 反射, set需傳入資料型態
				Method setBpiInfoFieldMethod = bpiInfo.getClass().getMethod("set" + first + last, BpiInfoDesc.class);
				// 將 幣別內部資料 反射至 欲回傳的幣別資訊
				setBpiInfoFieldMethod.invoke(bpiInfo, bpiInfoDesc);
			} catch (Exception e) {
				
			}
		} // end for

		// 從DB取得中文幣別資訊
		SelectCurrencyResponse selectCurrencyResponse = currencyService.selectCurrencyName();
		List<SelectCurrencyInfo> selectCurrencyInfoList = selectCurrencyResponse.getSelectCurrencyInfoList();

		// Field[] field
		for (SelectCurrencyInfo selectCurrencyInfo : selectCurrencyInfoList) {
			String first = selectCurrencyInfo.getCurrencyId().substring(0,1);
			String last = selectCurrencyInfo.getCurrencyId().substring(1).toLowerCase();
			try {
				// 反射, get不需傳入資料型態
				Method getBpiInfoFieldMethod = bpiInfo.getClass().getMethod("get" + first + last);
				// 將 幣別內部資料 從 欲回傳的幣別資訊 反射出來
				BpiInfoDesc bpiInfoDesc = (BpiInfoDesc) getBpiInfoFieldMethod.invoke(bpiInfo);
				// 將反射出的幣別內部資料 設定 中文幣別
				bpiInfoDesc.setDescription(selectCurrencyInfo.getCurrencyName());
			} catch (Exception e) {
				
			}
		} // end for
		
		return bpiInfo;
	}
}

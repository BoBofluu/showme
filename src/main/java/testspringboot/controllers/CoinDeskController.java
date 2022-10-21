package testspringboot.controllers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testspringboot.services.CoinDeskService;

@RestController
@RequestMapping("/coinDesk")
public class CoinDeskController {

	private CoinDeskService callCoinDeskApiService;
	
	/**
	 * 建構子
	 * @param callCoinDeskApiService
	 */
	// 右鍵 Source Generate Constructor using Fields
	public CoinDeskController(CoinDeskService callCoinDeskApiService) {
		this.callCoinDeskApiService = callCoinDeskApiService;
	}

	/**
	 * 取得幣別資訊(中文, 英文, 匯率, 時間)
	 * 
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@GetMapping("/send")
	public String sendCoinDesk() {
		return callCoinDeskApiService.sendCoinDesk();
	}

}

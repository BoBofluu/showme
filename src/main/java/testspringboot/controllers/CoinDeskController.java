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
	
	// 右鍵 Source Generate Constructor using Fields
	public CoinDeskController(CoinDeskService callCoinDeskApiService) {
		this.callCoinDeskApiService = callCoinDeskApiService;
	}

	@GetMapping("/send")
	public String sendCoinDesk() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return callCoinDeskApiService.sendCoinDesk();
	}

}

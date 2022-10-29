package testspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testspringboot.models.api.currency.InsertCurrencyRequst;
import testspringboot.models.api.currency.InsertCurrencyResponse;
import testspringboot.services.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService; 
	
	@PostMapping("/insert")
	public InsertCurrencyResponse insertCurrency(@RequestBody InsertCurrencyRequst insertCurrencyRequst) {
		return currencyService.insertCurrencyName(insertCurrencyRequst);
	}
	
	public void updateCurrency() {
		// test commit
	}
	public void deleteCurrency() {
		
	}
	public void selectCurrency() {
		
	}
}

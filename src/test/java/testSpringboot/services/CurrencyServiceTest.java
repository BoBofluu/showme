package testSpringboot.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import testspringboot.controllers.CurrencyController;
import testspringboot.models.api.currency.InsertCurrencyRequst;
import testspringboot.models.api.currency.InsertCurrencyResponse;

@SpringBootTest
public class CurrencyServiceTest {

	@Autowired
	CurrencyController currencyController;

	@Test
	public void testCallCurrencyInsert() {
		InsertCurrencyRequst insertCurrencyRequst = new InsertCurrencyRequst();
		insertCurrencyRequst.setCurrencyId("EUR");
		insertCurrencyRequst.setCurrencyName("歐元");
		InsertCurrencyResponse insertCurrencyResponse = currencyController.insertCurrency(insertCurrencyRequst);

		System.out.println(insertCurrencyResponse);
	}
}
 
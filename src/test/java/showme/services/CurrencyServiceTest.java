package showme.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import showme.controllers.CurrencyController;
import showme.models.api.currency.InsertCurrencyRequst;
import showme.models.api.currency.InsertCurrencyResponse;

@SpringBootTest
public class CurrencyServiceTest {

    @Autowired
    private CurrencyController currencyController;

    @Test
    public void testCallCurrencyInsert() {
        InsertCurrencyRequst insertCurrencyRequst = new InsertCurrencyRequst();
        insertCurrencyRequst.setCurrencyId("EUR");
        insertCurrencyRequst.setCurrencyName("歐元");
        InsertCurrencyResponse insertCurrencyResponse = currencyController.insertCurrency(insertCurrencyRequst);

        System.out.println(insertCurrencyResponse);
    }
}
 
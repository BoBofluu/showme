package testspringboot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "國泰API")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping("/insert")
    @Operation(summary = "新增幣別中文說明進資料庫")
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

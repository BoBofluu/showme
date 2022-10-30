package testspringboot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testspringboot.models.api.currency.InsertCurrencyRequst;
import testspringboot.models.api.currency.InsertCurrencyResponse;
import testspringboot.models.api.currency.SelectCurrencyInfo;
import testspringboot.models.api.currency.SelectCurrencyResponse;
import testspringboot.models.entites.Currency;
import testspringboot.repositories.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Transactional(rollbackFor = Exception.class)
    public InsertCurrencyResponse insertCurrencyName(InsertCurrencyRequst insertCurrencyRequst) {

        Currency currency = new Currency();
        currency.setCurrencyId(insertCurrencyRequst.getCurrencyId());
        currency.setCurrencyName(insertCurrencyRequst.getCurrencyName());

        currencyRepository.save(currency);
//		currencyRepository.findById(insertCurrencyRequst.getCurrencyId());
        return InsertCurrencyResponse.builder().insertResult("新增幣別對應中文說明完成").build();
    }

    @Transactional(rollbackFor = Exception.class)
    public SelectCurrencyResponse selectCurrencyName() {

        List<Currency> currencyList = currencyRepository.findAll();

        List<SelectCurrencyInfo> currencyInfoList = new ArrayList<>();

        for (Currency currencyInfo : currencyList) {
            SelectCurrencyInfo selectCurrencyInfo = new SelectCurrencyInfo();
            selectCurrencyInfo.setCurrencyId(currencyInfo.getCurrencyId());
            selectCurrencyInfo.setCurrencyName(currencyInfo.getCurrencyName());

            currencyInfoList.add(selectCurrencyInfo);
        }

        return SelectCurrencyResponse.builder().selectCurrencyInfoList(currencyInfoList).build();
    }
}

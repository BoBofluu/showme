package showme.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import showme.models.api.Request;
import showme.models.api.Responses;
import showme.models.api.billingCategory.GetInitType;
import showme.models.api.currency.InsertCurrencyRequst;
import showme.models.entites.TbTypePay;
import showme.services.BillingCategoryService;

import java.util.List;

@RestController
@RequestMapping("/billingCategory")
public class BillingCategoryController {

    @Autowired
    BillingCategoryService billingCategoryService;


    @GetMapping("/initType")
    @Operation(summary = "初始化頁面下拉選單")
    public Responses<GetInitType> initType() {
        GetInitType results = new GetInitType();

        results.setData(billingCategoryService.getInitType());
        return results;
    }

    @PostMapping("/typeSave")
    @Operation(summary = "類型保存類型保存")
    public String typeSave(@RequestBody Request<InsertCurrencyRequst> dat) {
        return "";
    }

}

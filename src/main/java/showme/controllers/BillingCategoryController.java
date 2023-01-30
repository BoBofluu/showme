package showme.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import showme.models.api.Request;
import showme.services.BillingCategoryService;

@RestController
@RequestMapping("/billingCategory")
public class BillingCategoryController {

    @Autowired
    private BillingCategoryService billingCategoryService;

//    @GetMapping("/initType")
//    @Operation(summary = "初始化頁面下拉選單")
//    public Responses<GetInitType> initType() {
//        return ResponseUtil.success(GetInitType.builder().tbList(billingCategoryService.getInitType()).build());
//    }

    @PostMapping("/typeSave")
    @Operation(summary = "類型保存類型保存")
    public String typeSave(@RequestBody Request<Void> dat) {
        return "";
    }




}

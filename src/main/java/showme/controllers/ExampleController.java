package showme.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import showme.models.entites.AccountTypeCus;
import showme.services.EntityManagerService;
import showme.services.serviceImpl.BaseAppDAOImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/showme")
public class ExampleController {


    @Autowired
    private EntityManagerService entityManagerService;

    @Autowired
    private BaseAppDAOImpl baseAppDAOImpl;

    /**
     * 範例程式新增
     */
    @PostMapping("/testInsert")
    public void testInsert() {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO account_type_cus (userid, orderseq, typecolor, typename) VALUES (?,?,?,?)");
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        entityManagerService.insert(builder, hashMap);

    }

    /**
     * 範例程式查詢
     */
    @GetMapping("/testQuery")
    public void testQuery() {

        List<AccountTypeCus> data = entityManagerService.getAccountTypeCusAllData();
        System.out.println(data.get(0).getUserId());
    }

    /**
     * 範例程式查詢
     */
    @GetMapping("/testQuery2")
    public void testQueryAndParamter() throws Exception {

        List<AccountTypeCus> data = entityManagerService.getAccountTypeCusData();
        System.out.println(data.get(0).getUserId());


    }
}

package showme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import showme.models.api.spending.SpendingGetTypeResponse;
import showme.services.SpendingService;
import showme.services.serviceImpl.SpendingServiceImpl;

@RestController
public class SpendingController {

    @Autowired
    private SpendingService spendingService;

    @GetMapping("/get-type/{userId}")
    public SpendingGetTypeResponse getType(@PathVariable String userId) {
        return spendingService.getType(userId);
    }

}

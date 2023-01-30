package showme.services.serviceImpl;

import org.springframework.stereotype.Service;
import showme.services.BillingCategoryService;
import showme.services.entityManager.JpaEntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class BillingCategoryServiceImpl implements BillingCategoryService {


    private JpaEntityManager jpaEntityManager;

    public BillingCategoryServiceImpl(JpaEntityManager jpaEntityManager) {
        this.jpaEntityManager = jpaEntityManager;
    }


    @Override
    public List<Object> getInitType() {
         return new ArrayList<>();
    }



}

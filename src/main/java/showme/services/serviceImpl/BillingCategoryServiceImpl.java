package showme.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import showme.models.entites.TbTypePay;
import showme.repositories.TbTypePayRepository;
import showme.services.BillingCategoryService;

import java.util.List;


@Service
public class BillingCategoryServiceImpl implements BillingCategoryService {


    @Autowired
    TbTypePayRepository tbTypePayRepository;


    @Override
    public List<TbTypePay> getInitType() {
        List<TbTypePay> typePayList = tbTypePayRepository.findAll();
        return typePayList ;
    }
}

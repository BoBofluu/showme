package showme.services;

import org.springframework.stereotype.Service;
import showme.models.entites.TbTypePay;

import java.util.List;

@Service
public interface BillingCategoryService {

    public List<TbTypePay> getInitType();
}

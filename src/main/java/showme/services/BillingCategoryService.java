package showme.services;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface BillingCategoryService {

    List<Object> getInitType();


}

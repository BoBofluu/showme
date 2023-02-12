package showme.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import showme.models.api.spending.SpendingGetTypeResponse;
import showme.models.entites.IncomeTypeCus;
import showme.models.entites.PayTypeCus;
import showme.repositories.IncomeTypeCusRepository;
import showme.repositories.PayTypeCusRepository;
import showme.services.SpendingService;

import java.util.List;

@Service
public class SpendingServiceImpl implements SpendingService {

    @Autowired
    private IncomeTypeCusRepository incomeTypeCusRepository;
    @Autowired
    private PayTypeCusRepository payTypeCusRepository;

    @Override
    public SpendingGetTypeResponse getType(String userId) {
        return SpendingGetTypeResponse.builder().payTypeCusList(payTypeCusRepository.findAllByUserId(userId))
                .incomeTypeCusList(incomeTypeCusRepository.findAllByUserId(userId)).build();
    }
}

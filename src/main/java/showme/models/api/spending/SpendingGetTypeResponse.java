package showme.models.api.spending;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import showme.models.entites.IncomeTypeCus;
import showme.models.entites.PayTypeCus;

import java.util.List;

@Getter
@Setter
@Builder
public class SpendingGetTypeResponse {

    private List<IncomeTypeCus> incomeTypeCusList;

    private List<PayTypeCus> payTypeCusList;
}

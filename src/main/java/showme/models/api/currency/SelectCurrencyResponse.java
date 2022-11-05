package showme.models.api.currency;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SelectCurrencyResponse {

    private List<SelectCurrencyInfo> selectCurrencyInfoList;
}

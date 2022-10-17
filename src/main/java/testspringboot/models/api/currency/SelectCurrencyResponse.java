package testspringboot.models.api.currency;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SelectCurrencyResponse {

	private List<SelectCurrencyInfo> selectCurrencyInfoList;
}

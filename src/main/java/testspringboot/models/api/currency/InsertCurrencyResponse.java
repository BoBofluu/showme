package testspringboot.models.api.currency;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsertCurrencyResponse {

	private String insertResult;
}

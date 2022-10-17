package testspringboot.models.api.currency;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectCurrencyInfo {

	@JsonProperty("CurrencyId")
	private String currencyId;

	@JsonProperty("CurrencyName")
	private String currencyName;
}

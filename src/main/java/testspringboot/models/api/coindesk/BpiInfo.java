package testspringboot.models.api.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BpiInfo {

	@JsonProperty("USD")
	private BpiInfoDesc usd;

	@JsonProperty("GBP")
	private BpiInfoDesc gbp;

	@JsonProperty("EUR")
	private BpiInfoDesc eur;

}

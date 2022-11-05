package showme.models.api.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bpi {

    @JsonProperty("USD")
    private BpiDesc usd;

    @JsonProperty("GBP")
    private BpiDesc gbp;

    @JsonProperty("EUR")
    private BpiDesc eur;
}

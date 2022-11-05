package showme.models.api.coindesk;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConvertCoinDeskResponse {

    private Time time;

    private BpiInfo bpiInfo;
}

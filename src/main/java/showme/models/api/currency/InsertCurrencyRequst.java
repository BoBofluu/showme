package showme.models.api.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "InsertCurrencyRequest")
public class InsertCurrencyRequst {

    @Schema(title = "幣別")
    private String currencyId;

    @Schema(title = "幣別中文資訊")
    private String currencyName;
}

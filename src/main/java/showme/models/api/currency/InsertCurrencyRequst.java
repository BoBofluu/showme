package showme.models.api.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import showme.models.api.Request;

@Getter
@Setter
@Schema(title = "InsertCurrencyRequest")
public class InsertCurrencyRequst extends Request {

    @Schema(title = "幣別")
    private String currencyId;

    @Schema(title = "幣別中文資訊")
    private String currencyName;

    @Override
    public boolean isValidate() {
        boolean validate = true;
        if (StringUtils.equals("", this.currencyId)) {
            validate = false;
        }

        return validate;
    }
}

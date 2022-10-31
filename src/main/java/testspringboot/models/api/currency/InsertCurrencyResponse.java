package testspringboot.models.api.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(title = "InsertCurrencyResponse")
public class InsertCurrencyResponse {

    @Schema(title = "寫入幣別資料庫結果")
    private String insertResult;
}

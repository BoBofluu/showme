package testspringboot.controllers.advice;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "ErrorResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @Schema(title = "發生時間")
    private String timestamp;

    @Schema(title = "錯誤代號")
    private String errorCode;

    @Schema(title = "錯誤類型 發生異常的模組")
    private String type;

    @Schema(title = "錯誤說明")
    private String message;

    @Schema(title = "UUID")
    private String trackerId;
}

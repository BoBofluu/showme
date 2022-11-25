package showme.models.api.billingCategory;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import showme.models.api.Responses;
import showme.models.entites.TbTypePay;

import java.util.List;


@Getter
@Setter
@Builder
@Schema(title = "GetInitType")
public class GetInitType {

    @Schema(title = "待補充")
    private List<TbTypePay> tbList;

    @Schema(title = "待補充")
    private String myName;
}

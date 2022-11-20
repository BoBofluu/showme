package showme.models.api.billingCategory;

import lombok.Getter;
import lombok.Setter;
import showme.models.api.Responses;
import showme.models.entites.TbTypePay;

import java.util.List;


@Getter
@Setter
public class GetInitType extends Responses {
    private List<TbTypePay> tbList;
    private String myName;
}

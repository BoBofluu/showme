package showme.models.entites;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "pay_type_cus")
public class PayTypeCus {

    @EmbeddedId
    private PayTypeCusId id;
    private String typeName;
    private String typeColor;


}

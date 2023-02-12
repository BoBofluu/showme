package showme.models.entites;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "income_type_cus")
public class IncomeTypeCus {

    @EmbeddedId
    private IncomeTypeCusId id;
    private String typeName;
    private String typeColor;

}

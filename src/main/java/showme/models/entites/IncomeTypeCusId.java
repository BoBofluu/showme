package showme.models.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IncomeTypeCusId implements java.io.Serializable {

    private String userId;
    private long orderSeq;
}

package showme.models.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "account_type_cus")
public class AccountTypeCus {

    @Id
    private String userId;
    private long orderSeq;
    private String typeName;
    private String typeColor;

}

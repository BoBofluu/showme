package showme.models.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "sys_code")
public class SysCode {

    @Id
    private String codeCategory;
    private String codeId;
    private String codeName;
    private long orderSeq;
    private String remark;




}

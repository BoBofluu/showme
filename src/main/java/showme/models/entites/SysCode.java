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


    public String getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }


    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }


    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }


    public long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(long orderSeq) {
        this.orderSeq = orderSeq;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

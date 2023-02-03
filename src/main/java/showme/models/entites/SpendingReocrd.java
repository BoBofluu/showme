package showme.models.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "spending_reocrd")
public class SpendingReocrd {

    @Id
    private String recordId;
    private String payOrIncome;
    private java.sql.Date recordDate;
    private String recordAme;
    private String recordType;
    private String accountType;
    private String remark;
    private String createId;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;



}

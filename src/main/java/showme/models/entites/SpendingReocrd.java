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


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }


    public String getPayOrIncome() {
        return payOrIncome;
    }

    public void setPayOrIncome(String payOrIncome) {
        this.payOrIncome = payOrIncome;
    }


    public java.sql.Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(java.sql.Date recordDate) {
        this.recordDate = recordDate;
    }


    public String getRecordAme() {
        return recordAme;
    }

    public void setRecordAme(String recordAme) {
        this.recordAme = recordAme;
    }


    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}

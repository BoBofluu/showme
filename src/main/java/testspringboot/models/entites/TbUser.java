package testspringboot.models.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table( name ="tb_user" )
@Getter
@Setter
public class TbUser  implements Serializable {

    private static final long serialVersionUID = 1559005131803490305L;
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * Base64加密
     */
    @Column(name = "user_credential")
    private String userCredential;

    @Column(name = "user_name")
    private String userName;

    /**
     * N = normal: 一般使用者
     * V = vip: 付費會員
     * O = owner: 我們自己
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 實名用，需收驗證碼
     */
    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 找回密碼用
     */
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 有可能改密碼時需要
     */
    @Column(name = "modify_time")
    private Date modifyTime;
}

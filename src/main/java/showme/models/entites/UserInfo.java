package showme.models.entites;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@Entity(name = "user_info")
public class UserInfo {

  @Id
  private String userId;
  private String mobile;
  private String credential;
  private String userName;
  private String userType;
  private String email;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;

}

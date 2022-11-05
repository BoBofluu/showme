package testspringboot.models.entites;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.*;

/**
 * @Description  
 * @Author  zhulei
 * @Date 2022-11-01 
 */

@Entity
@Table ( name ="tb_type_income_custom" )
@Getter
@Setter
public class TbTypeIncomeCustom  implements Serializable {

	private static final long serialVersionUID =  5382309652566852245L;

   	@Column(name = "type_id" )
	private Long typeId;
	@Id
   	@Column(name = "type_name" )
	private String typeName;

   	@Column(name = "type_seq" )
	private Long typeSeq;

   	@Column(name = "type_color" )
	private String typeColor;

   	@Column(name = "user_id" )
	private String userId;

}

package showme.models.entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.*;

/**
 * @Description
 * @Author zhulei
 * @Date 2022-11-01
 */

@Entity
@Table(name = "tb_type_pay_custom")
@Getter
@Setter
public class TbTypePayCustom implements Serializable {

    private static final long serialVersionUID = 2242146813387144180L;

    @Column(name = "type_id")
    private Long typeId;

    @Id
    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_seq")
    private Long typeSeq;

    @Column(name = "type_color")
    private String typeColor;

    @Column(name = "user_id")
    private String userId;

}

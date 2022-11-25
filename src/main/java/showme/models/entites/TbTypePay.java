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
@Table(name = "tb_type_pay")
@Getter
@Setter
public class TbTypePay implements Serializable {

    private static final long serialVersionUID = 3706604697342736744L;
    @Id
    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_seq")
    private Long typeSeq;

    @Column(name = "type_color")
    private String typeColor;

}

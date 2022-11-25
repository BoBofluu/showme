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
@Table(name = "tb_type_income")
@Getter
@Setter
public class TbTypeIncome implements Serializable {

    private static final long serialVersionUID = 569308267685946161L;

    @Column(name = "type_id")
    private Long typeId;

    @Id
    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_seq")
    private Long typeSeq;

    @Column(name = "type_color")
    private String typeColor;

}

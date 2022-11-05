package showme.models.entites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "CURRENCY")
public class Currency implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CurrencyId")
    private String currencyId;

    @Column(name = "CurrencyName")
    private String currencyName;
}

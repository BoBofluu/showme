package testspringboot.models.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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

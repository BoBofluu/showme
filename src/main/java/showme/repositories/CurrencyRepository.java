package showme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import showme.models.entites.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {

}

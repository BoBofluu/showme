package testspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testspringboot.models.entites.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {

}

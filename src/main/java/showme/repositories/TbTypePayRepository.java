package showme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import showme.models.entites.TbTypePay;

@Repository
public interface TbTypePayRepository extends JpaRepository<TbTypePay, String> {

}

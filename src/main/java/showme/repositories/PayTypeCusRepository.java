package showme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import showme.models.entites.PayTypeCus;
import showme.models.entites.PayTypeCusId;

import java.util.List;

@Repository
public interface PayTypeCusRepository extends JpaRepository<PayTypeCus, PayTypeCusId> {

    @Query(value = "select * from pay_type_cus p where p.userId = :userId", nativeQuery = true)
    List<PayTypeCus> findAllByUserId(String userId);
}

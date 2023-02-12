package showme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import showme.models.entites.IncomeTypeCus;
import showme.models.entites.IncomeTypeCusId;
import showme.models.entites.PayTypeCus;

import java.util.List;

@Repository
public interface IncomeTypeCusRepository extends JpaRepository<IncomeTypeCus, IncomeTypeCusId> {

    @Query(value = "select * from income_type_cus i where i.userId = :userId", nativeQuery = true)
    List<IncomeTypeCus> findAllByUserId(String userId);
}

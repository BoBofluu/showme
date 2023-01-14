package showme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import showme.models.entites.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}

package showme.services.entityManager;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class JpaEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 無參數存查詢 各自呼叫方法傳，sql語法近來
     * @param sqlStr
     * @return List
     */
    private List getData(String sqlStr) {
        StringBuilder sb = new StringBuilder();
//        sb.append("select * from user_info ");
        sb.append(sqlStr);
        String sql = sb.toString();
        return entityManager.createNativeQuery(sql).getResultList();
    }



}

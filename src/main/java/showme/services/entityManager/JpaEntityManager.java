package showme.services.entityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JpaEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LogManager.getLogger(JpaEntityManager.class);


    /**
     * 無參數存查詢 各自呼叫方法傳，sql語法近來
     *
     * @param sqlSb sql語法
     * @return List
     */
    public List<Map<Object, Object>> getData(StringBuilder sqlSb) {
        List<Map<Object, Object>> result = null;
        try {
            String sqlStr = sbToStr(sqlSb);
            Query query = entityManager.createQuery(sqlStr);

            result = query.getResultList();

//            Query query = entityManager.createQuery(sql);
//            query.setParameter(1, o);
//            List<T> list = query.getResultList();
            entityManager.close();

        } catch (Exception e) {
            logger.error("getData() " + e.getMessage());
            e.getStackTrace();
        }

        return result;
    }

    /**
     * 有參數存查詢 各自呼叫方法傳，sql語法近來
     *
     * @param sqlSb        sql語法
     * @param parameterMap 對應的參數
     * @return List
     */
    public List<Map<Object, Object>> getData(StringBuilder sqlSb, HashMap<String, Object> parameterMap) {

        List<Map<Object, Object>> result = null;
        try {
            String sqlStr = sbToStr(sqlSb);
            Query query = entityManager.createNativeQuery(sqlStr);
            parameterMap.entrySet().forEach(k -> {
                query.setParameter(k.getKey(), k.getValue());
            });

            result = query.getResultList();

        } catch (Exception e) {

            logger.error("getData() " + e.getMessage());
            e.getStackTrace();
        }
        return result;
    }


    /**
     * 有參數insert 各自呼叫方法傳，sql語法近來
     *
     * @param sqlSb        sql語法
     * @param parameterMap 對應的參數
     * @return List
     */
    @Transactional
    @Modifying
    public void insert(StringBuilder sqlSb, HashMap<Integer, Object> parameterMap) {
        try {

            String sqlStr = sbToStr(sqlSb);
            Query query = entityManager.createNativeQuery(sqlStr);
            if (parameterMap != null) {
                parameterMap.forEach((key, value) -> {
                    query.setParameter(key, value);
                });
            } else {
                logger.error("insert()： NoCorrectParameters ");
                throw new NullPointerException();
            }
            query.executeUpdate();
        } catch (Exception e) {
            logger.error("getData() " + e);
            e.getStackTrace();
        }

    }

    private String sbToStr(StringBuilder sqlSb) {
        String result = null;
        try {
            result = sqlSb.toString();

        } catch (Exception e) {
            logger.error("sbToStr() " + e.getMessage());
            e.getStackTrace();
        }
        return result;
    }

}

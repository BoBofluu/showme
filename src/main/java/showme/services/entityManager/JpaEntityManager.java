package showme.services.entityManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

@Repository
public class JpaEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LogManager.getLogger(JpaEntityManager.class);


    private static final Gson gson;

    static {
        gson = new GsonBuilder().serializeNulls().create();
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

    /**
     * 無參數存查詢 各自呼叫方法傳，sql語法近來
     *
     * @param sqlSb sql語法
     * @return List
     */
    public List getData(StringBuilder sqlSb) {
        List result = null;
        try {
            String sqlStr = sbToStr(sqlSb);
            result = entityManager.createNativeQuery(sqlStr).getResultList();
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
    public List getData(StringBuilder sqlSb, HashMap<String, Object> parameterMap) {
        List result = null;
        try {
            String sqlStr = sbToStr(sqlSb);
            Query query = entityManager.createNativeQuery(sqlStr);
            parameterMap.entrySet().forEach(k -> {
                System.out.printf("Key: %s , Value: %s", k.getKey(), k.getValue());
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
     * 有參數存查詢 各自呼叫方法傳，sql語法近來
     * 轉物件出去呼叫此方法
     *
     * @param sqlSb        sql語法
     * @param parameterMap 對應的參數
     * @param clazz        要轉出去的物件
     * @return List
     */
    public <T> T getData(StringBuilder sqlSb, HashMap<String, Object> parameterMap, Class<T> clazz) {
        T result = null;

        try {
            String sqlStr = sbToStr(sqlSb);
            Query query = entityManager.createNativeQuery(sqlStr);
            parameterMap.forEach((key, value) -> {
                System.out.printf("Key: %s , Value: %s", key, value);
                query.setParameter(key, value);
            });
            List list = query.getResultList();
            result = fromJson(gson.toJson(list), clazz);
        } catch (Exception e) {
            logger.error("getData() " + e.getMessage());
            e.getStackTrace();
        }


        return result;
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

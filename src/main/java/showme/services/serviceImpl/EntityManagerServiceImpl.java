package showme.services.serviceImpl;

import org.springframework.stereotype.Service;
import showme.models.entites.AccountTypeCus;
import showme.services.EntityManagerService;
import showme.services.entityManager.JpaEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

@Service
public class EntityManagerServiceImpl implements EntityManagerService {

    private JpaEntityManager jpaEntityManager;

    @PersistenceContext
    private EntityManager entityManager;


    public EntityManagerServiceImpl(JpaEntityManager jpaEntityManager) {
        this.jpaEntityManager = jpaEntityManager;
    }

    @Override
    public void insert(StringBuilder sb, HashMap<Integer, Object> map) {
        jpaEntityManager.insert(sb, map);
    }

    @Override
    public List<AccountTypeCus> getAccountTypeCusAllData() {
        return entityManager.createNativeQuery("select * FROM public.account_type_cus ", AccountTypeCus.class).getResultList();
    }

    @Override
    public List<AccountTypeCus> getAccountTypeCusData() {
        return entityManager
                .createNativeQuery("select * FROM public.account_type_cus  where userid = :userid", AccountTypeCus.class)
                .setParameter("userid", "1")
                .getResultList();

    }


}

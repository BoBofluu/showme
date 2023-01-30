package showme.services;

import org.springframework.stereotype.Service;
import showme.models.entites.AccountTypeCus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Service
public interface EntityManagerService extends Serializable {

    public void insert(StringBuilder sb, HashMap<Integer, Object> map);

    public List<AccountTypeCus> getAccountTypeCusAllData();

    public List<AccountTypeCus> getAccountTypeCusData();


}

package pl.java.scalatech.repository;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.java.scalatech.entity.User;
import pl.java.scalatech.entity.common.PKEntity;
@Repository
@Slf4j
@NoArgsConstructor
public class UserSpecificRepositoryImpl<T extends PKEntity> implements UserSpecificRepository<T>{
    
    private  Class<T> type = null;

    
    public UserSpecificRepositoryImpl(Class<T> type) {
         this.type = type;
    }
    
    @Autowired
    protected EntityManagerFactory entityManagerFactory;
    
    @Override
    public T getResult(Map<String,String> map){
        EntityManager em  = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> c= cb.createTupleQuery();
        Root<T> emp = c.from(type);
        CriteriaQuery<Tuple> queryTuple = c.multiselect(cb.construct(User.class, emp.get("name"), emp.get("login"),emp.get("salary")));  
        TypedQuery<Tuple> query = em.createQuery(queryTuple);
        
        Tuple tuple = query.getSingleResult();
        T t = null;
        try {
            t = type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
          log.error("error during create new entity",e);
        }
        for(String key :map.keySet()){
            //user.setLogin(login);
        }
        
        
        return t;
        
    }

    
}

package vn.ute.library.repository.impl;
import vn.ute.library.repository.*; import vn.ute.library.model.*; import vn.ute.library.util.*; import jakarta.persistence.*;
public class UserRepositoryImpl_24110329 implements UserRepository_24110329 {
 public User_24110329 findByEmail(String email){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.createQuery("from User_24110329 u where u.email=:e",User_24110329.class).setParameter("e",email).getResultStream().findFirst().orElse(null);}finally{em.close();}}
 public User_24110329 save(User_24110329 u){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();User_24110329 x=u.getId()==null?u:em.merge(u);if(u.getId()==null)em.persist(u);em.getTransaction().commit();return x;}finally{em.close();}}
}

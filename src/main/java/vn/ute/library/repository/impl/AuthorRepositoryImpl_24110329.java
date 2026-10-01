package vn.ute.library.repository.impl;
import vn.ute.library.repository.*; import vn.ute.library.model.*; import vn.ute.library.util.*; import jakarta.persistence.*; import java.util.*;
public class AuthorRepositoryImpl_24110329 implements AuthorRepository_24110329 {
 public List<Author_24110329> findPage(int p,int s){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.createQuery("from Author_24110329 a order by a.author_id desc",Author_24110329.class).setFirstResult(p*s).setMaxResults(s).getResultList();}finally{em.close();}}
 public long count(){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.createQuery("select count(a) from Author_24110329 a",Long.class).getSingleResult();}finally{em.close();}}
 public Author_24110329 findById(Long id){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.find(Author_24110329.class,id);}finally{em.close();}}
 public void save(Author_24110329 a){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();em.persist(a);em.getTransaction().commit();}finally{em.close();}}
 public void update(Author_24110329 a){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();em.merge(a);em.getTransaction().commit();}finally{em.close();}}
 public void delete(Long id){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();Author_24110329 a=em.find(Author_24110329.class,id);if(a!=null)em.remove(a);em.getTransaction().commit();}finally{em.close();}}
}

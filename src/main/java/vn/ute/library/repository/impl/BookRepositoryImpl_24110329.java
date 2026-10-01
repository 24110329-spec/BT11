package vn.ute.library.repository.impl;
import vn.ute.library.repository.*; import vn.ute.library.model.*; import vn.ute.library.util.*; import jakarta.persistence.*; import java.util.*;
public class BookRepositoryImpl_24110329 implements BookRepository_24110329 {
 public List<Book_24110329> findPage(int p,int s){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.createQuery("select distinct b from Book_24110329 b left join fetch b.authors order by b.bookid desc",Book_24110329.class).setFirstResult(p*s).setMaxResults(s).getResultList();}finally{em.close();}}
 public long count(){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.createQuery("select count(b) from Book_24110329 b",Long.class).getSingleResult();}finally{em.close();}}
 public Book_24110329 findById(Long id){EntityManager em=JPAUtil_24110329.getEntityManager();try{return em.createQuery("select distinct b from Book_24110329 b left join fetch b.authors where b.bookid=:id",Book_24110329.class).setParameter("id",id).getResultStream().findFirst().orElse(null);}finally{em.close();}}
 public void save(Book_24110329 b){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();em.persist(b);em.getTransaction().commit();}finally{em.close();}}
 public void update(Book_24110329 b){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();em.merge(b);em.getTransaction().commit();}finally{em.close();}}
 public void delete(Long id){EntityManager em=JPAUtil_24110329.getEntityManager();try{em.getTransaction().begin();Book_24110329 b=em.find(Book_24110329.class,id);if(b!=null)em.remove(b);em.getTransaction().commit();}finally{em.close();}}
}

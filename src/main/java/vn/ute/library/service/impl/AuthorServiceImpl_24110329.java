package vn.ute.library.service.impl;
import vn.ute.library.service.*; import vn.ute.library.repository.*; import vn.ute.library.repository.impl.*; import vn.ute.library.model.*; import java.util.*;
public class AuthorServiceImpl_24110329 implements AuthorService_24110329 {
 private final AuthorRepository_24110329 repo=new AuthorRepositoryImpl_24110329();
 public List<Author_24110329> findPage(int p,int s){return repo.findPage(p,s);} public long count(){return repo.count();}
 public Author_24110329 findById(Long id){return repo.findById(id);} public void save(Author_24110329 a){repo.save(a);}
 public void update(Author_24110329 a){repo.update(a);} public void delete(Long id){repo.delete(id);}
}

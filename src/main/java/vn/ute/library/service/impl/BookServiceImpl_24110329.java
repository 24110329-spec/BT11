package vn.ute.library.service.impl;
import vn.ute.library.service.*; import vn.ute.library.repository.*; import vn.ute.library.repository.impl.*; import vn.ute.library.model.*; import java.util.*;
public class BookServiceImpl_24110329 implements BookService_24110329 {
 private final BookRepository_24110329 repo=new BookRepositoryImpl_24110329();
 public List<Book_24110329> findPage(int p,int s){return repo.findPage(p,s);} public long count(){return repo.count();}
 public Book_24110329 findById(Long id){return repo.findById(id);} public void save(Book_24110329 b){repo.save(b);}
 public void update(Book_24110329 b){repo.update(b);} public void delete(Long id){repo.delete(id);}
}

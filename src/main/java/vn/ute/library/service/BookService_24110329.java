package vn.ute.library.service;
import vn.ute.library.model.Book_24110329; import java.util.*;
public interface BookService_24110329 { List<Book_24110329> findPage(int p,int s); long count(); Book_24110329 findById(Long id); void save(Book_24110329 b); void update(Book_24110329 b); void delete(Long id); }

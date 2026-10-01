package vn.ute.library.repository;
import vn.ute.library.model.Book_24110329; import java.util.*;
public interface BookRepository_24110329 {
 List<Book_24110329> findPage(int page,int size);
 long count();
 Book_24110329 findById(Long id);
 void save(Book_24110329 b);
 void update(Book_24110329 b);
 void delete(Long id);
}

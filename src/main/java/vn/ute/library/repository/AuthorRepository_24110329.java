package vn.ute.library.repository;
import vn.ute.library.model.Author_24110329; import java.util.*;
public interface AuthorRepository_24110329 {
 List<Author_24110329> findPage(int page,int size); long count();
 Author_24110329 findById(Long id); void save(Author_24110329 a); void update(Author_24110329 a); void delete(Long id);
}

package vn.ute.library.service;
import vn.ute.library.model.Author_24110329; import java.util.*;
public interface AuthorService_24110329 { List<Author_24110329> findPage(int p,int s); long count(); Author_24110329 findById(Long id); void save(Author_24110329 a); void update(Author_24110329 a); void delete(Long id); }

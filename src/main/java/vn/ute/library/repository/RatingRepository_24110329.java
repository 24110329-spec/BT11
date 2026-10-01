package vn.ute.library.repository;
import vn.ute.library.model.Rating_24110329; import java.util.*;
public interface RatingRepository_24110329 {
 List<Rating_24110329> findByBook(Long bookId);
 double average(Long bookId);
 void save(Rating_24110329 rating);
}

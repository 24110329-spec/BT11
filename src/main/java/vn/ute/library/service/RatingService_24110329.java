package vn.ute.library.service;
import vn.ute.library.model.Rating_24110329; import java.util.*;
public interface RatingService_24110329 { List<Rating_24110329> findByBook(Long id); double average(Long id); void save(Rating_24110329 r); }

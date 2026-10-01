package vn.ute.library.repository;
import vn.ute.library.model.User_24110329;
public interface UserRepository_24110329 {
 User_24110329 findByEmail(String email);
 User_24110329 save(User_24110329 user);
}

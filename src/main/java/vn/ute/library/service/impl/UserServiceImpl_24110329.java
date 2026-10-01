package vn.ute.library.service.impl;
import vn.ute.library.service.*; import vn.ute.library.repository.*; import vn.ute.library.repository.impl.*; import vn.ute.library.model.*; import vn.ute.library.util.*; import java.time.*;
public class UserServiceImpl_24110329 implements UserService_24110329 {
 private final UserRepository_24110329 repo=new UserRepositoryImpl_24110329();
 public User_24110329 login(String e,String p){User_24110329 u=repo.findByEmail(e);if(u!=null && (u.getPasswd().equals(p)||u.getPasswd().equals(PasswordUtil_24110329.sha256(p)))){u.setLast_login(LocalDateTime.now());repo.save(u);return u;}return null;}
 public boolean register(User_24110329 u){if(repo.findByEmail(u.getEmail())!=null)return false;u.setSignup_date(LocalDateTime.now());u.setIs_admin(false);u.setPasswd(PasswordUtil_24110329.sha256(u.getPasswd()));repo.save(u);return true;}
}

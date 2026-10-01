package vn.ute.library.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="users")
public class User_24110329 {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String email;
 private String fullName, phone, passwd;
 private LocalDateTime signup_date,last_login;
 private boolean is_admin;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getPasswd(){return passwd;} public void setPasswd(String v){passwd=v;}
 public LocalDateTime getSignup_date(){return signup_date;} public void setSignup_date(LocalDateTime v){signup_date=v;}
 public LocalDateTime getLast_login(){return last_login;} public void setLast_login(LocalDateTime v){last_login=v;}
 public boolean isIs_admin(){return is_admin;} public void setIs_admin(boolean v){is_admin=v;}
}

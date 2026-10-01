package vn.ute.library.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="author")
public class Author_24110329 {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long author_id;
 private String author_name; private LocalDate date_of_birth;
 public Long getAuthor_id(){return author_id;} public void setAuthor_id(Long v){author_id=v;}
 public String getAuthor_name(){return author_name;} public void setAuthor_name(String v){author_name=v;}
 public LocalDate getDate_of_birth(){return date_of_birth;} public void setDate_of_birth(LocalDate v){date_of_birth=v;}
}

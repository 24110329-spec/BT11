package vn.ute.library.model;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDate; import java.util.*;
@Entity @Table(name="books")
public class Book_24110329 {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long bookid;
 @Column(nullable=false,unique=true) private String isbn; private String title,publisher;
 private BigDecimal price; @Column(columnDefinition="TEXT") private String description;
 private LocalDate publish_date; private String cover_image; private int quantity;
 @ManyToMany(fetch=FetchType.LAZY) @JoinTable(name="book_author",
  joinColumns=@JoinColumn(name="bookid"), inverseJoinColumns=@JoinColumn(name="author_id"))
 private List<Author_24110329> authors=new ArrayList<>();
 public Long getBookid(){return bookid;} public void setBookid(Long v){bookid=v;}
 public String getIsbn(){return isbn;} public void setIsbn(String v){isbn=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getPublisher(){return publisher;} public void setPublisher(String v){publisher=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public LocalDate getPublish_date(){return publish_date;} public void setPublish_date(LocalDate v){publish_date=v;}
 public String getCover_image(){return cover_image;} public void setCover_image(String v){cover_image=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public List<Author_24110329> getAuthors(){return authors;} public void setAuthors(List<Author_24110329> v){authors=v;}
}

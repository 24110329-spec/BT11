package vn.ute.library.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="order_items")
public class OrderItem_24110329 {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="order_id",nullable=false) private Order_24110329 order;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="book_id",nullable=false) private Book_24110329 book;
 private int quantity; private BigDecimal unit_price;
 public Long getId(){return id;} public Order_24110329 getOrder(){return order;} public void setOrder(Order_24110329 v){order=v;}
 public Book_24110329 getBook(){return book;} public void setBook(Book_24110329 v){book=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public BigDecimal getUnit_price(){return unit_price;} public void setUnit_price(BigDecimal v){unit_price=v;}
}

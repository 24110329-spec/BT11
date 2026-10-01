package vn.ute.library.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
@Entity @Table(name="orders")
public class Order_24110329 {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="user_id",nullable=false) private User_24110329 user;
 private BigDecimal total_amount;
 @Column(nullable=false) private String payment_method="COD";
 @Column(nullable=false) private String status="PENDING";
 private String receiver_name, receiver_phone, receiver_address;
 private LocalDateTime created_at=LocalDateTime.now();
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
 private List<OrderItem_24110329> items=new ArrayList<>();
 public Long getId(){return id;} public User_24110329 getUser(){return user;} public void setUser(User_24110329 v){user=v;}
 public BigDecimal getTotal_amount(){return total_amount;} public void setTotal_amount(BigDecimal v){total_amount=v;}
 public String getPayment_method(){return payment_method;} public void setPayment_method(String v){payment_method=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public String getReceiver_name(){return receiver_name;} public void setReceiver_name(String v){receiver_name=v;}
 public String getReceiver_phone(){return receiver_phone;} public void setReceiver_phone(String v){receiver_phone=v;}
 public String getReceiver_address(){return receiver_address;} public void setReceiver_address(String v){receiver_address=v;}
 public LocalDateTime getCreated_at(){return created_at;} public void setCreated_at(LocalDateTime v){created_at=v;}
 public List<OrderItem_24110329> getItems(){return items;}
 public void addItem(OrderItem_24110329 i){items.add(i);i.setOrder(this);}
}

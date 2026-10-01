package vn.ute.library.model;
import java.math.BigDecimal;
public class CartItem_24110329 {
 private Book_24110329 book; private int quantity;
 public CartItem_24110329(Book_24110329 b,int q){book=b;quantity=q;}
 public Book_24110329 getBook(){return book;} public int getQuantity(){return quantity;}
 public BigDecimal getSubtotal(){return book.getPrice().multiply(BigDecimal.valueOf(quantity));}
}

package vn.ute.library.service.impl;
import vn.ute.library.service.*; import vn.ute.library.model.*; import vn.ute.library.util.*;
import jakarta.persistence.*; import java.math.*; import java.util.*;

public class OrderServiceImpl_24110329 implements OrderService_24110329 {

 public List<Order_24110329> findByUserAndStatus(Long userId, String status){
  EntityManager em=JPAUtil_24110329.getEntityManager();
  try{
   String jpql="SELECT o FROM Order_24110329 o WHERE o.user.id=:uid";
   if(status!=null && !status.isBlank()) jpql+=" AND o.status=:status";
   jpql+=" ORDER BY o.created_at DESC";
   TypedQuery<Order_24110329> q=em.createQuery(jpql,Order_24110329.class).setParameter("uid",userId);
   if(status!=null && !status.isBlank()) q.setParameter("status",status);
   return q.getResultList();
  }finally{em.close();}
 }

 public List<Order_24110329> findByUser(Long userId){
  return findByUserAndStatus(userId,null);
 }

 public Order_24110329 checkout(Long userId, Map<Long,Integer> cart,String name,String phone,String address){
  if(cart==null||cart.isEmpty()) throw new IllegalArgumentException("Giỏ hàng đang trống.");
  EntityManager em=JPAUtil_24110329.getEntityManager();
  try{
   em.getTransaction().begin();
   User_24110329 u=em.find(User_24110329.class,userId);
   if(u==null) throw new IllegalArgumentException("Tài khoản không tồn tại.");
   Order_24110329 o=new Order_24110329();
   o.setUser(u); o.setReceiver_name(name); o.setReceiver_phone(phone); o.setReceiver_address(address);
   BigDecimal total=BigDecimal.ZERO;
   for(var e:cart.entrySet()){
    int qty=e.getValue();
    if(qty<=0) throw new IllegalArgumentException("Số lượng không hợp lệ.");
    Book_24110329 b=em.find(Book_24110329.class,e.getKey());
    if(b==null) throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    if(qty>b.getQuantity()) throw new IllegalArgumentException("Sách '"+b.getTitle()+"' chỉ còn "+b.getQuantity()+" cuốn.");
    OrderItem_24110329 item=new OrderItem_24110329();
    item.setBook(b); item.setQuantity(qty); item.setUnit_price(b.getPrice()); o.addItem(item);
    total=total.add(b.getPrice().multiply(BigDecimal.valueOf(qty)));
    b.setQuantity(b.getQuantity()-qty);
   }
   o.setTotal_amount(total); o.setPayment_method("COD"); o.setStatus("PENDING");
   em.persist(o); em.getTransaction().commit(); return o;
  }catch(RuntimeException ex){
   if(em.getTransaction().isActive()) em.getTransaction().rollback();
   throw ex;
  }finally{em.close();}
 }
}

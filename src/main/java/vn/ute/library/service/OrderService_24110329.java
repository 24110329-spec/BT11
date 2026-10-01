package vn.ute.library.service;
import vn.ute.library.model.*;
public interface OrderService_24110329 {
 Order_24110329 checkout(Long userId, java.util.Map<Long,Integer> cart, String name, String phone, String address);
 java.util.List<Order_24110329> findByUserAndStatus(Long userId, String status);
 java.util.List<Order_24110329> findByUser(Long userId);
}

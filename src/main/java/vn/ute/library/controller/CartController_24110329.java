package vn.ute.library.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import java.math.*;
import java.util.*; import vn.ute.library.model.*; import vn.ute.library.service.*; import vn.ute.library.service.impl.*;
@WebServlet("/cart")
public class CartController_24110329 extends HttpServlet {
 private final BookService_24110329 books=new BookServiceImpl_24110329();
 private final OrderService_24110329 orders=new OrderServiceImpl_24110329();
 @SuppressWarnings("unchecked") private Map<Long,Integer> cart(HttpServletRequest r){
  var s=r.getSession(); var c=(Map<Long,Integer>)s.getAttribute("cart");
  if(c==null){c=new LinkedHashMap<>();s.setAttribute("cart",c);} return c;
 }
 private void redirect(HttpServletRequest r,HttpServletResponse p,String msg)throws IOException{
  if(msg!=null)r.getSession().setAttribute("cartMsg",msg);p.sendRedirect(r.getContextPath()+"/cart");
 }
 protected void doGet(HttpServletRequest r,HttpServletResponse p)throws ServletException,IOException{
  Map<Long,Integer> c=cart(r); String a=r.getParameter("action");
  if("remove".equals(a)){c.remove(Long.valueOf(r.getParameter("id")));redirect(r,p,"Đã xóa sản phẩm.");return;}
  if("clear".equals(a)){c.clear();redirect(r,p,"Đã xóa toàn bộ giỏ hàng.");return;}
  List<CartItem_24110329> items=new ArrayList<>();BigDecimal total=BigDecimal.ZERO;
  for(var it=c.entrySet().iterator();it.hasNext();){var e=it.next();Book_24110329 b=books.findById(e.getKey());if(b==null){it.remove();continue;}var i=new CartItem_24110329(b,e.getValue());items.add(i);total=total.add(i.getSubtotal());}
  r.setAttribute("cartItems",items);r.setAttribute("cartTotal",total);r.setAttribute("message",r.getSession().getAttribute("cartMsg"));r.getSession().removeAttribute("cartMsg");
  r.setAttribute("successOrder",r.getSession().getAttribute("orderSuccess"));r.getSession().removeAttribute("orderSuccess");
  if("checkout".equals(a)){
   if(r.getSession().getAttribute("user")==null){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}
   r.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(r,p);return;
  }
  r.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(r,p);
 }
 protected void doPost(HttpServletRequest r,HttpServletResponse p)throws ServletException,IOException{
  r.setCharacterEncoding("UTF-8"); Map<Long,Integer> c=cart(r); String a=r.getParameter("action");
  try{
   if("add".equals(a)){
    long id=Long.parseLong(r.getParameter("id"));Book_24110329 b=books.findById(id);if(b==null)throw new IllegalArgumentException("Không tìm thấy sách.");
    int old=c.getOrDefault(id,0), add=Integer.parseInt(r.getParameter("quantity")==null?"1":r.getParameter("quantity"));
    if(add<1||old+add>b.getQuantity())throw new IllegalArgumentException("Số lượng vượt quá tồn kho ("+b.getQuantity()+").");
    c.put(id,old+add);redirect(r,p,"Đã thêm sách vào giỏ hàng.");return;
   }
   if("update".equals(a)){
    long id=Long.parseLong(r.getParameter("id"));int q=Integer.parseInt(r.getParameter("quantity"));Book_24110329 b=books.findById(id);
    if(q<1||b==null||q>b.getQuantity())throw new IllegalArgumentException("Số lượng phải từ 1 đến "+(b==null?0:b.getQuantity())+".");
    c.put(id,q);redirect(r,p,"Đã cập nhật số lượng.");return;
   }
   if("checkout".equals(a)){
    User_24110329 u=(User_24110329)r.getSession().getAttribute("user");if(u==null){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}
    String name=r.getParameter("name"),phone=r.getParameter("phone"),address=r.getParameter("address");
    if(name==null||name.isBlank()||phone==null||phone.isBlank()||address==null||address.isBlank())throw new IllegalArgumentException("Vui lòng nhập đầy đủ thông tin nhận hàng.");
    Order_24110329 o=orders.checkout(u.getId(),new LinkedHashMap<>(c),name,phone,address);c.clear();
    r.getSession().setAttribute("orderSuccess",o.getId());p.sendRedirect(r.getContextPath()+"/cart?success=1");return;
   }
  }catch(Exception ex){r.getSession().setAttribute("cartMsg",ex.getMessage());}
  p.sendRedirect(r.getContextPath()+"/cart");
 }
}

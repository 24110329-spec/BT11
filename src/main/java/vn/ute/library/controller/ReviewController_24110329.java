package vn.ute.library.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.IOException; import vn.ute.library.model.*; import vn.ute.library.service.*; import vn.ute.library.service.impl.*; import vn.ute.library.util.*;
@WebServlet("/reviews")
public class ReviewController_24110329 extends HttpServlet {
 private final RatingService_24110329 rs=new RatingServiceImpl_24110329(); private final BookService_24110329 bs=new BookServiceImpl_24110329();
 protected void doPost(HttpServletRequest r,HttpServletResponse p)throws IOException{User_24110329 u=(User_24110329)r.getSession().getAttribute("user");if(u==null){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}Long id=Long.valueOf(r.getParameter("bookid"));Book_24110329 b=bs.findById(id);Rating_24110329 x=new Rating_24110329();x.setUser(u);x.setBook(b);x.setRating(Integer.parseInt(r.getParameter("rating")));x.setReview_text(r.getParameter("review_text"));rs.save(x);p.sendRedirect(r.getContextPath()+"/books?id="+id);}
}

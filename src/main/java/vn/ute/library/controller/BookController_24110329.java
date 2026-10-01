package vn.ute.library.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.IOException;
import vn.ute.library.service.*; import vn.ute.library.service.impl.*;
@WebServlet("/books")
public class BookController_24110329 extends HttpServlet {
 private final BookService_24110329 service=new BookServiceImpl_24110329();
 private final RatingService_24110329 reviewService=new RatingServiceImpl_24110329();
 protected void doGet(HttpServletRequest r,HttpServletResponse p)throws ServletException,IOException{
  String id=r.getParameter("id");
  if(id!=null){
   Long bookId=Long.valueOf(id); var b=service.findById(bookId);
   r.setAttribute("book",b); r.setAttribute("reviews",reviewService.findByBook(bookId)); r.setAttribute("average",reviewService.average(bookId));
   r.getRequestDispatcher("/WEB-INF/views/book-detail.jsp").forward(r,p); return;
  }
  int page=Math.max(0,Integer.parseInt(r.getParameter("page")==null?"0":r.getParameter("page"))); int size=6;
  r.setAttribute("books",service.findPage(page,size)); r.setAttribute("page",page);
  r.setAttribute("pages",(int)Math.ceil((double)service.count()/size));
  r.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(r,p);
 }
}
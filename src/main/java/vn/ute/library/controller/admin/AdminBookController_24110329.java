package vn.ute.library.controller.admin;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.IOException; import java.math.BigDecimal; import java.time.LocalDate; import java.util.*;
import vn.ute.library.model.*; import vn.ute.library.service.*; import vn.ute.library.service.impl.*;
@WebServlet("/admin/books")
public class AdminBookController_24110329 extends HttpServlet {
 private final BookService_24110329 bs=new BookServiceImpl_24110329(); private final AuthorService_24110329 as=new AuthorServiceImpl_24110329();
 private boolean ok(HttpServletRequest r){var u=(User_24110329)r.getSession().getAttribute("user");return u!=null&&u.isIs_admin();}
 protected void doGet(HttpServletRequest r,HttpServletResponse p)throws ServletException,IOException{
  if(!ok(r)){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}
  String a=r.getParameter("action");
  if("delete".equals(a)){bs.delete(Long.valueOf(r.getParameter("id")));p.sendRedirect(r.getContextPath()+"/admin/books");return;}
  int page=Integer.parseInt(r.getParameter("page")==null?"0":r.getParameter("page"));
  r.setAttribute("editBook","edit".equals(a)?bs.findById(Long.valueOf(r.getParameter("id"))):null);
  r.setAttribute("books",bs.findPage(page,5)); r.setAttribute("page",page); r.setAttribute("pages",(int)Math.ceil((double)bs.count()/5));
  r.setAttribute("authors",as.findPage(0,100)); r.getRequestDispatcher("/WEB-INF/views/admin/books.jsp").forward(r,p);
 }
 protected void doPost(HttpServletRequest r,HttpServletResponse p)throws IOException{
  if(!ok(r)){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}
  String id=r.getParameter("id"); Book_24110329 b=(id==null||id.isBlank())?new Book_24110329():bs.findById(Long.valueOf(id));
  b.setIsbn(r.getParameter("isbn")); b.setTitle(r.getParameter("title")); b.setPublisher(r.getParameter("publisher"));
  b.setPrice(new BigDecimal(r.getParameter("price"))); b.setDescription(r.getParameter("description"));
  b.setPublish_date(LocalDate.parse(r.getParameter("publish_date"))); b.setCover_image(r.getParameter("cover_image"));
  b.setQuantity(Integer.parseInt(r.getParameter("quantity")));
  String aid=r.getParameter("author_id"); if(aid!=null&&!aid.isBlank())b.setAuthors(List.of(as.findById(Long.valueOf(aid))));
  if(b.getBookid()==null)bs.save(b);else bs.update(b); p.sendRedirect(r.getContextPath()+"/admin/books");
 }
}
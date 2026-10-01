package vn.ute.library.controller.admin;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.IOException; import java.time.LocalDate;
import vn.ute.library.model.*; import vn.ute.library.service.*; import vn.ute.library.service.impl.*;
@WebServlet("/admin/authors")
public class AdminAuthorController_24110329 extends HttpServlet {
 private final AuthorService_24110329 s=new AuthorServiceImpl_24110329();
 private boolean ok(HttpServletRequest r){var u=(User_24110329)r.getSession().getAttribute("user");return u!=null&&u.isIs_admin();}
 protected void doGet(HttpServletRequest r,HttpServletResponse p)throws ServletException,IOException{
  if(!ok(r)){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}
  if("delete".equals(r.getParameter("action"))){s.delete(Long.valueOf(r.getParameter("id")));p.sendRedirect(r.getContextPath()+"/admin/authors");return;}
  int page=Integer.parseInt(r.getParameter("page")==null?"0":r.getParameter("page"));
  r.setAttribute("editAuthor","edit".equals(r.getParameter("action"))?s.findById(Long.valueOf(r.getParameter("id"))):null);
  r.setAttribute("authors",s.findPage(page,5));r.setAttribute("page",page);r.setAttribute("pages",(int)Math.ceil((double)s.count()/5));
  r.getRequestDispatcher("/WEB-INF/views/admin/authors.jsp").forward(r,p);
 }
 protected void doPost(HttpServletRequest r,HttpServletResponse p)throws IOException{
  if(!ok(r)){p.sendRedirect(r.getContextPath()+"/auth?action=login");return;}
  String id=r.getParameter("id");Author_24110329 a=(id==null||id.isBlank())?new Author_24110329():s.findById(Long.valueOf(id));
  a.setAuthor_name(r.getParameter("author_name"));
  String dob=r.getParameter("date_of_birth");
  a.setDate_of_birth(dob==null||dob.isBlank()?null:LocalDate.parse(dob));
  if(a.getAuthor_id()==null)s.save(a);else s.update(a);p.sendRedirect(r.getContextPath()+"/admin/authors");
 }
}
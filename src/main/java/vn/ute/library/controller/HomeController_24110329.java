package vn.ute.library.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/", "/home"})
public class HomeController_24110329 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Trang chủ dùng chung dữ liệu với BookController.
        resp.sendRedirect(req.getContextPath() + "/books");
    }
}

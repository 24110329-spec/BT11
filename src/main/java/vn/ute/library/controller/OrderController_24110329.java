package vn.ute.library.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;
import vn.ute.library.model.*;
import vn.ute.library.service.*;
import vn.ute.library.service.impl.*;

@WebServlet("/orders")
public class OrderController_24110329 extends HttpServlet {
    private final OrderService_24110329 orders = new OrderServiceImpl_24110329();

    private static final LinkedHashMap<String,String> STATUSES = new LinkedHashMap<>();
    static {
        STATUSES.put("PENDING","Đơn hàng mới");
        STATUSES.put("CONFIRMED","Đã xác nhận");
        STATUSES.put("PREPARING","Chuẩn bị hàng");
        STATUSES.put("SHIPPING","Vận chuyển");
        STATUSES.put("DELIVERING","Giao hàng");
        STATUSES.put("DELIVERED","Đã giao");
        STATUSES.put("CANCELLED","Đơn hàng hủy");
        STATUSES.put("RETURNED","Đơn hàng hoàn");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User_24110329 user=(User_24110329)req.getSession().getAttribute("user");
        if(user==null){
            resp.sendRedirect(req.getContextPath()+"/auth?action=login");
            return;
        }
        String status=req.getParameter("status");
        if(status==null || !STATUSES.containsKey(status)) status="";
        req.setAttribute("statuses",STATUSES);
        req.setAttribute("selectedStatus",status);
        req.setAttribute("orders",orders.findByUserAndStatus(user.getId(),status));
        req.getRequestDispatcher("/WEB-INF/views/orders.jsp").forward(req,resp);
    }
}

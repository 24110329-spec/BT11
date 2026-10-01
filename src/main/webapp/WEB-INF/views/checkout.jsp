<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %><% request.setAttribute("title","Thanh toán COD"); %>
<h1>Thanh toán đơn hàng</h1>
<c:if test="${not empty message}"><div class="alert alert-danger">${message}</div></c:if>
<div class="row"><div class="col-md-7"><form action="${pageContext.request.contextPath}/cart" method="post" class="card p-4">
<input type="hidden" name="action" value="checkout">
<h5>Thông tin nhận hàng</h5><label class="form-label">Họ tên</label><input class="form-control mb-3" name="name" required>
<label class="form-label">Số điện thoại</label><input class="form-control mb-3" name="phone" required>
<label class="form-label">Địa chỉ</label><textarea class="form-control mb-3" name="address" required></textarea>
<div class="alert alert-warning">Phương thức thanh toán: <b>COD - Thanh toán khi nhận hàng</b></div>
<button class="btn btn-success w-100">Xác nhận đặt hàng</button></form></div>
<div class="col-md-5"><div class="card p-3"><h5>Tóm tắt đơn hàng</h5><c:forEach var="i" items="${cartItems}"><div class="d-flex justify-content-between border-bottom py-2"><span>${i.book.title} × ${i.quantity}</span><b>${i.subtotal} đ</b></div></c:forEach><h5 class="text-end mt-3">Tổng: ${cartTotal} đ</h5></div></div></div>

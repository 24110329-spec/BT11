<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %><h2>Đăng ký tài khoản</h2>
<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if><c:if test="${not empty message}"><div class="alert alert-info">${message}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/auth">
<input type="hidden" name="action" value="sendOtp"><input class="form-control mb-2" name="email" type="email" placeholder="Email" required>
<button class="btn btn-secondary">Gửi OTP</button></form><hr>
<form method="post" action="${pageContext.request.contextPath}/auth"><input type="hidden" name="action" value="register">
<input class="form-control mb-2" name="email" placeholder="Email" required><input class="form-control mb-2" name="fullName" placeholder="Họ tên" required>
<input class="form-control mb-2" name="phone" placeholder="Số điện thoại"><input class="form-control mb-2" name="password" type="password" placeholder="Mật khẩu" required>
<input class="form-control mb-2" name="otp" placeholder="OTP" required><button class="btn btn-primary">Đăng ký</button></form>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %><h2>Đăng nhập</h2>
<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/auth"><input type="hidden" name="action" value="login">
<input class="form-control mb-2" name="email" type="email" placeholder="Email" required><input class="form-control mb-2" name="password" type="password" placeholder="Mật khẩu" required>
<button class="btn btn-primary">Đăng nhập</button> <a href="${pageContext.request.contextPath}/auth?action=register">Đăng ký</a></form>

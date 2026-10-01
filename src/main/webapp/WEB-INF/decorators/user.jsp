<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><%= "<sitemesh:write property=\"title\"/>" %></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%= "<sitemesh:write property=\"head\"/>" %>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/books">Library</a>
        <div>
            <a class="text-white me-3" href="${pageContext.request.contextPath}/books">Trang Chủ</a>
            <a class="text-white me-3" href="${pageContext.request.contextPath}/books">Sản phẩm</a><a class="text-white me-3" href="${pageContext.request.contextPath}/cart">🛒 Giỏ hàng</a><a class="text-white me-3" href="${pageContext.request.contextPath}/orders">📦 Đơn hàng</a>

            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <a class="text-white me-3" href="${pageContext.request.contextPath}/auth?action=login">Đăng nhập</a>
                </c:when>
                <c:otherwise>
                    <a class="text-white me-3" href="${pageContext.request.contextPath}/auth?action=logout">Đăng xuất</a>
                    <c:if test="${sessionScope.user.is_admin}">
                        <a class="text-white" href="${pageContext.request.contextPath}/admin/books">Trang quản trị</a>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<main class="container py-4">
    <%= "<sitemesh:write property=\"body\"/>" %>
</main>

<footer class="text-center border-top py-3">
    Trần Thanh Thảo - MSSV: 24110329 - Mã đề: 01
</footer>
</body>
</html>

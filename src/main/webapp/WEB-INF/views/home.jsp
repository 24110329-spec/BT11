<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% request.setAttribute("title","Trang Chủ - Sách"); %>
<h1>Danh sách sách</h1><div class="row g-4">
<c:forEach var="b" items="${books}">
<div class="col-md-4"><div class="card h-100 shadow-sm"><img src="${b.cover_image}" class="card-img-top" style="height:300px;object-fit:cover" onerror="this.src='https://via.placeholder.com/300x300?text=Book'">
<div class="card-body"><h5><a href="${pageContext.request.contextPath}/books?id=${b.bookid}">${b.title}</a></h5>
<div>Tiêu đề: ${b.title}</div><div>Mã ISBN: ${b.isbn}</div><div>Tác giả: <c:forEach var="a" items="${b.authors}" varStatus="s">${a.author_name}<c:if test="${!s.last}">, </c:if></c:forEach></div>
<div>Publisher: ${b.publisher}</div><div>Publisher_date: ${b.publish_date}</div><div>Quantity: ${b.quantity}</div><form action="${pageContext.request.contextPath}/cart" method="post" class="mt-2 d-flex gap-2"><input type="hidden" name="action" value="add"><input type="hidden" name="id" value="${b.bookid}"><input class="form-control" type="number" name="quantity" value="1" min="1" max="${b.quantity}" style="width:90px" ${b.quantity==0?"disabled":""}><button class="btn btn-primary" ${b.quantity==0?"disabled":""}>Thêm vào giỏ</button></form></div></div></div>
</c:forEach></div>
<nav class="mt-4"><ul class="pagination"><c:forEach begin="0" end="${pages-1}" var="p"><li class="page-item ${p==page?'active':''}"><a class="page-link" href="${pageContext.request.contextPath}/books?page=${p}">${p+1}</a></li></c:forEach></ul></nav>

<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>Quản trị Authors - CRUD</h2>
<form method="post" class="row g-2 mb-4" action="${pageContext.request.contextPath}/admin/authors">
<input type="hidden" name="id" value="${editAuthor.author_id}">
<div class="col-md-5"><input class="form-control" name="author_name" placeholder="Tên tác giả" value="${editAuthor.author_name}" required></div>
<div class="col-md-4"><input class="form-control" name="date_of_birth" type="date" value="${editAuthor.date_of_birth}"></div>
<button class="btn btn-success col-md-2">${empty editAuthor ? 'Tạo Author' : 'Cập nhật Author'}</button>
<c:if test="${not empty editAuthor}"><a class="btn btn-secondary col-md-2" href="${pageContext.request.contextPath}/admin/authors">Hủy</a></c:if>
</form>
<table class="table table-bordered"><tr><th>ID</th><th>Author</th><th>Date of birth</th><th>Action</th></tr>
<c:forEach var="a" items="${authors}"><tr><td>${a.author_id}</td><td>${a.author_name}</td><td>${a.date_of_birth}</td><td>
<a class="btn btn-sm btn-warning" href="?action=edit&id=${a.author_id}">Sửa</a>
<a class="btn btn-sm btn-danger" href="?action=delete&id=${a.author_id}" onclick="return confirm('Xóa?')">Xóa</a></td></tr></c:forEach></table>
<nav><c:forEach begin="0" end="${pages-1}" var="p"><a class="btn btn-sm btn-outline-primary" href="?page=${p}">${p+1}</a></c:forEach></nav>
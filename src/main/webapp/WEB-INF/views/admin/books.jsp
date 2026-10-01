<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>Quản trị Books - CRUD</h2>
<form method="post" class="row g-2 mb-4" action="${pageContext.request.contextPath}/admin/books">
<input type="hidden" name="id" value="${editBook.bookid}">
<div class="col-md-2"><input class="form-control" name="isbn" placeholder="ISBN" value="${editBook.isbn}" required></div>
<div class="col-md-3"><input class="form-control" name="title" placeholder="Title" value="${editBook.title}" required></div>
<div class="col-md-2"><input class="form-control" name="publisher" placeholder="Publisher" value="${editBook.publisher}"></div>
<div class="col-md-1"><input class="form-control" name="price" value="${empty editBook.price ? '0' : editBook.price}" type="number"></div>
<div class="col-md-1"><input class="form-control" name="quantity" value="${empty editBook.quantity ? '1' : editBook.quantity}" type="number"></div>
<div class="col-md-2"><input class="form-control" name="publish_date" value="${editBook.publish_date}" type="date"></div>
<div class="col-md-12"><input class="form-control" name="cover_image" placeholder="Cover URL" value="${editBook.cover_image}"></div>
<div class="col-md-12"><textarea class="form-control" name="description" placeholder="Description">${editBook.description}</textarea></div>
<div class="col-md-3"><select class="form-select" name="author_id"><c:forEach var="a" items="${authors}"><option value="${a.author_id}">${a.author_name}</option></c:forEach></select></div>
<button class="btn btn-success col-md-2">${empty editBook ? 'Tạo Book' : 'Cập nhật Book'}</button>
<c:if test="${not empty editBook}"><a class="btn btn-secondary col-md-2" href="${pageContext.request.contextPath}/admin/books">Hủy</a></c:if>
</form>
<table class="table table-bordered"><tr><th>ID</th><th>ISBN</th><th>Title</th><th>Quantity</th><th>Action</th></tr>
<c:forEach var="b" items="${books}"><tr><td>${b.bookid}</td><td>${b.isbn}</td><td>${b.title}</td><td>${b.quantity}</td>
<td><a class="btn btn-sm btn-warning" href="?action=edit&id=${b.bookid}">Sửa</a>
<a class="btn btn-sm btn-danger" href="?action=delete&id=${b.bookid}" onclick="return confirm('Xóa?')">Xóa</a></td></tr></c:forEach></table>
<nav><c:forEach begin="0" end="${pages-1}" var="p"><a class="btn btn-sm btn-outline-primary" href="?page=${p}">${p+1}</a></c:forEach></nav>
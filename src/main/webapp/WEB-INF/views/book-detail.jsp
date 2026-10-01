<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h1>${book.title}</h1><div class="row"><div class="col-md-4"><img src="${book.cover_image}" class="img-fluid"></div><div class="col-md-8">
<p>Tiêu đề: ${book.title}</p><p>Mã ISBN: ${book.isbn}</p><p>Tác giả: <c:forEach var="a" items="${book.authors}">${a.author_name} </c:forEach></p>
<p>Publisher: ${book.publisher}</p><p>Publisher_date: ${book.publish_date}</p><p>Quantity: ${book.quantity}</p><form action="${pageContext.request.contextPath}/cart" method="post" class="d-flex gap-2 mb-3"><input type="hidden" name="action" value="add"><input type="hidden" name="id" value="${book.bookid}"><input class="form-control" type="number" name="quantity" value="1" min="1" max="${book.quantity}" style="width:100px" ${book.quantity==0?"disabled":""}><button class="btn btn-success" ${book.quantity==0?"disabled":""}>Thêm vào giỏ</button></form>
<h4>Reviews (${reviews.size()}) - Điểm trung bình: ${average}/10</h4>
<c:forEach var="r" items="${reviews}"><div class="border rounded p-2 mb-2"><b>${r.user.fullName}</b> - ${r.rating}/10<br>${r.review_text}</div></c:forEach>
<form action="${pageContext.request.contextPath}/reviews" method="post"><input type="hidden" name="bookid" value="${book.bookid}">
<label>Rating</label><input class="form-control" type="number" min="1" max="10" name="rating" required>
<label>Review</label><textarea class="form-control" name="review_text"></textarea><button class="btn btn-primary mt-2">Submit</button></form>
</div></div>
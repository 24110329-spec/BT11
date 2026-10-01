<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %><% request.setAttribute("title","Giỏ hàng"); %>
<h1>🛒 Giỏ hàng</h1>
<c:if test="${not empty message}"><div class="alert alert-info">${message}</div></c:if>
<c:if test="${not empty successOrder}"><div class="alert alert-success">Đặt hàng thành công! Mã đơn hàng: <b>#${successOrder}</b>. Thanh toán khi nhận hàng (COD).</div></c:if>
<c:choose><c:when test="${empty cartItems}"><div class="alert alert-secondary">Giỏ hàng đang trống.</div><a class="btn btn-primary" href="${pageContext.request.contextPath}/books">Tiếp tục mua sách</a></c:when>
<c:otherwise>
<div class="table-responsive"><table class="table table-bordered align-middle"><thead><tr><th>Sách</th><th>Đơn giá</th><th style="width:180px">Số lượng</th><th>Thành tiền</th><th></th></tr></thead><tbody>
<c:forEach var="i" items="${cartItems}"><tr><td>${i.book.title}</td><td>${i.book.price} đ</td><td>
<form action="${pageContext.request.contextPath}/cart" method="post" class="d-flex gap-1"><input type="hidden" name="action" value="update"><input type="hidden" name="id" value="${i.book.bookid}"><input class="form-control" type="number" name="quantity" min="1" max="${i.book.quantity}" value="${i.quantity}"><button class="btn btn-outline-primary">Sửa</button></form>
</td><td>${i.subtotal} đ</td><td><a class="btn btn-sm btn-outline-danger" href="${pageContext.request.contextPath}/cart?action=remove&id=${i.book.bookid}">Xóa</a></td></tr></c:forEach>
</tbody></table></div>
<h4 class="text-end">Tổng: <b>${cartTotal} đ</b></h4>
<div class="d-flex justify-content-end gap-2"><a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/cart?action=clear">Xóa giỏ hàng</a><a class="btn btn-success" href="${pageContext.request.contextPath}/cart?action=checkout">Thanh toán COD</a></div>
</c:otherwise></c:choose>

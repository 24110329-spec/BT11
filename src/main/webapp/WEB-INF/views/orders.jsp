<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.Map" %>
<% request.setAttribute("title","Lịch sử đặt hàng"); %>

<h1 class="mb-4">📦 Lịch sử đặt hàng</h1>

<div class="card mb-4">
  <div class="card-body">
    <form method="get" action="${pageContext.request.contextPath}/orders" class="row g-2 align-items-center">
      <div class="col-md-4">
        <label class="form-label fw-bold">Lọc theo trạng thái</label>
        <select name="status" class="form-select" onchange="this.form.submit()">
          <option value="">Tất cả đơn hàng</option>
          <c:forEach var="s" items="${statuses}">
            <option value="${s.key}" ${selectedStatus == s.key ? 'selected' : ''}>${s.value}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-md-auto pt-md-4">
        <button class="btn btn-primary">Lọc</button>
        <a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/orders">Tất cả</a>
      </div>
    </form>
  </div>
</div>

<c:choose>
  <c:when test="${empty orders}">
    <div class="alert alert-info">Không có đơn hàng ở trạng thái này.</div>
  </c:when>
  <c:otherwise>
    <c:forEach var="o" items="${orders}">
      <div class="card mb-3 shadow-sm">
        <div class="card-header d-flex justify-content-between align-items-center">
          <div>
            <b>Đơn hàng #${o.id}</b>
            <span class="text-muted ms-2">${o.created_at}</span>
          </div>
          <c:choose>
            <c:when test="${o.status == 'PENDING'}"><span class="badge bg-secondary">${statuses[o.status]}</span></c:when>
            <c:when test="${o.status == 'CONFIRMED'}"><span class="badge bg-primary">${statuses[o.status]}</span></c:when>
            <c:when test="${o.status == 'PREPARING'}"><span class="badge bg-info text-dark">${statuses[o.status]}</span></c:when>
            <c:when test="${o.status == 'SHIPPING' || o.status == 'DELIVERING'}"><span class="badge bg-warning text-dark">${statuses[o.status]}</span></c:when>
            <c:when test="${o.status == 'DELIVERED'}"><span class="badge bg-success">${statuses[o.status]}</span></c:when>
            <c:when test="${o.status == 'CANCELLED'}"><span class="badge bg-danger">${statuses[o.status]}</span></c:when>
            <c:otherwise><span class="badge bg-dark">${statuses[o.status]}</span></c:otherwise>
          </c:choose>
        </div>
        <div class="card-body">
          <div><b>Người nhận:</b> ${o.receiver_name} - ${o.receiver_phone}</div>
          <div><b>Địa chỉ:</b> ${o.receiver_address}</div>
          <div><b>Thanh toán:</b> COD</div>
          <div class="text-end mt-2"><b>Tổng tiền: ${o.total_amount} đ</b></div>
        </div>
      </div>
    </c:forEach>
  </c:otherwise>
</c:choose>

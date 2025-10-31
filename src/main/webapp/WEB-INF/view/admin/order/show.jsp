<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="LaptopShop - Quản lý đơn hàng" />
                <meta name="author" content="Phạm Lâm" />
                <title>Manage Orders - LaptopShop</title>
                <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Orders</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Orders</li>
                                </ol>

                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Table Orders</h3>
                                                <a href="/admin/order/create" class="btn btn-primary">Create Order</a>
                                            </div>

                                            <hr />
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Total Price (VNĐ)</th>
                                                        <th>User</th>
                                                        <th>Status</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="order" items="${orders}">
                                                        <tr>
                                                            <td>${order.id}</td>
                                                            <td>
                                                                <fmt:formatNumber value="${order.totalPrice}"
                                                                    type="number" />
                                                            </td>
                                                            <td>
                                                                <c:choose>
                                                                    <c:when test="${not empty order.user}">
                                                                        ${order.user.fullName}
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <i class="text-muted">No user</i>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td>${order.status}</td>
                                                            <td>
                                                                <a href="/admin/order/${order.id}"
                                                                    class="btn btn-success btn-sm">View</a>
                                                                <a href="/admin/order/update/${order.id}"
                                                                    class="btn btn-warning btn-sm mx-2">Update</a>
                                                                <a href="/admin/order/delete/${order.id}"
                                                                    class="btn btn-danger btn-sm">Delete</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>

                                            <c:if test="${empty orders}">
                                                <p class="text-center text-muted mt-3">No orders found.</p>
                                            </c:if>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="<c:url value='/resources/js/scripts.js' />"></script>
            </body>

            </html>
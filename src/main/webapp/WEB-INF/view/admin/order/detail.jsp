<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="LaptopShop - Order Detail" />
                <meta name="author" content="Phạm Lâm" />
                <title>Order Detail - LaptopShop</title>
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
                                <h1 class="mt-4">Order Detail</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/order">Orders</a></li>
                                    <li class="breadcrumb-item active">Detail</li>
                                </ol>

                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <!-- Tiêu đề có id động -->
                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                <h3>Orders detail with id ${order.id}</h3>

                                            </div>

                                            <hr />

                                            <!-- Bảng chi tiết sản phẩm -->
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Product</th>
                                                        <th>Price (VNĐ)</th>
                                                        <th>Quantity</th>
                                                        <th>Total (VNĐ)</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="detail" items="${order.orderDetails}">
                                                        <tr>
                                                            <td>${detail.product.name}</td>
                                                            <td>
                                                                <fmt:formatNumber value="${detail.product.price}"
                                                                    type="number" />
                                                            </td>
                                                            <td>${detail.quantity}</td>
                                                            <td>
                                                                <fmt:formatNumber
                                                                    value="${detail.quantity * detail.product.price}"
                                                                    type="number" />
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <a href="/admin/order" class="btn btn-success">
                                                <i class="fas fa-arrow-left"></i> Back
                                            </a>


                                            <!-- Tổng cộng -->
                                            <!-- <div class="text-end mt-3">
                                                <strong>Total Price: </strong>
                                                <fmt:formatNumber value="${order.totalPrice}" type="number" /> VNĐ
                                            </div> -->

                                            <!-- Nếu không có sản phẩm -->
                                            <c:if test="${empty order.orderDetails}">
                                                <p class="text-center text-muted mt-3">No products in this order.</p>
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
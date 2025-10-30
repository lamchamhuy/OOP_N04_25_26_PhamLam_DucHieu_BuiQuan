<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <title>Thanh Toán - Laptopshop</title>
                    <meta content="width=device-width, initial-scale=1.0" name="viewport">

                    <!-- Google Web Fonts -->
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                        rel="stylesheet">

                    <!-- Icon Font Stylesheet -->
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                        rel="stylesheet">

                    <!-- Libraries Stylesheet -->
                    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

                    <!-- Customized Bootstrap Stylesheet -->
                    <link href="/client/css/bootstrap.min.css" rel="stylesheet">

                    <!-- Template Stylesheet -->
                    <link href="/client/css/style.css" rel="stylesheet">
                </head>

                <body>

                    <!-- Spinner Start -->
                    <div id="spinner"
                        class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50 d-flex align-items-center justify-content-center">
                        <div class="spinner-grow text-primary" role="status"></div>
                    </div>
                    <!-- Spinner End -->

                    <jsp:include page="../layout/header.jsp" />

                    <!-- Checkout Page Start -->
                    <div class="container-fluid py-5">
                        <div class="container py-5">

                            <div class="mb-3">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Thông tin thanh toán</li>
                                    </ol>
                                </nav>
                            </div>

                            <div class="row">
                                <!-- Cột trái: Bảng sản phẩm -->
                                <div class="col-12 mb-4">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead class="table-light">
                                                <tr>
                                                    <th>Sản phẩm</th>
                                                    <th>Tên</th>
                                                    <th>Giá</th>
                                                    <th>Số lượng</th>
                                                    <th>Thành tiền</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="cartDetail" items="${cartDetails}" varStatus="i">
                                                    <tr>
                                                        <td>
                                                            <img src="/images/product/${cartDetail.product.image}"
                                                                class="img-fluid rounded-circle"
                                                                style="width: 80px; height: 80px;" alt="">
                                                        </td>
                                                        <td class="align-middle">
                                                            <a href="/product/${cartDetail.product.id}" target="_blank">
                                                                ${cartDetail.product.name}
                                                            </a>
                                                        </td>
                                                        <td class="align-middle">
                                                            <fmt:formatNumber type="number"
                                                                value="${cartDetail.product.price}" /> đ
                                                        </td>
                                                        <td class="align-middle text-center">${cartDetail.quantity}</td>
                                                        <td class="align-middle">
                                                            <fmt:formatNumber type="number"
                                                                value="${cartDetail.product.price * cartDetail.quantity}" />
                                                            đ
                                                        </td>
                                                    </tr>

                                                    <!-- Gửi hidden inputs để Spring bind lại đúng danh sách cartDetails -->
                                                    <input type="hidden" name="cartDetails[${i.index}].id"
                                                        value="${cartDetail.id}" />
                                                    <input type="hidden" name="cartDetails[${i.index}].quantity"
                                                        value="${cartDetail.quantity}" />
                                                    <input type="hidden" name="cartDetails[${i.index}].price"
                                                        value="${cartDetail.price}" />
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <!-- Form checkout -->
                                <form:form modelAttribute="cart" action="/place-order" method="post" class="w-100">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="row">
                                        <!-- Cột trái: Thông tin người nhận -->
                                        <div class="col-lg-6 col-md-12">
                                            <div class="bg-light rounded p-4 shadow-sm h-100">
                                                <h5 class="mb-3 text-center text-uppercase">Thông Tin Người Nhận</h5>

                                                <div class="mb-3">
                                                    <label>Tên người nhận</label>
                                                    <form:input path="receiverName" class="form-control"
                                                        required="true" />
                                                </div>

                                                <div class="mb-3">
                                                    <label>Địa chỉ người nhận</label>
                                                    <form:input path="receiverAddress" class="form-control"
                                                        required="true" />
                                                </div>

                                                <div class="mb-3">
                                                    <label>Số điện thoại</label>
                                                    <form:input path="receiverPhone" class="form-control"
                                                        required="true" />
                                                </div>

                                                <div class="mt-3">
                                                    <i class="fas fa-arrow-left"></i>
                                                    <a href="/cart"> Quay lại giỏ hàng</a>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Cột phải: Thông tin thanh toán -->
                                        <div class="col-lg-6 col-md-12 mt-4 mt-lg-0">
                                            <div
                                                class="bg-light rounded p-4 shadow-sm h-100 d-flex flex-column justify-content-between">
                                                <div>
                                                    <h5 class="mb-4 text-center text-uppercase">Thông Tin Thanh Toán
                                                    </h5>

                                                    <div class="d-flex justify-content-between mb-3">
                                                        <h6>Tạm tính:</h6>
                                                        <p>
                                                            <fmt:formatNumber type="number" value="${totalPrice}" /> đ
                                                        </p>
                                                    </div>

                                                    <div class="d-flex justify-content-between mb-3">
                                                        <h6>Phí vận chuyển:</h6>
                                                        <p>0 đ</p>
                                                    </div>

                                                    <div class="d-flex justify-content-between mb-3">
                                                        <h6>Hình thức:</h6>
                                                        <p>Thanh toán khi nhận hàng (COD)</p>
                                                    </div>

                                                    <hr>

                                                    <div class="d-flex justify-content-between">
                                                        <h5>Tổng số tiền:</h5>
                                                        <h5 class="text-primary">
                                                            <fmt:formatNumber type="number" value="${totalPrice}" /> đ
                                                        </h5>
                                                    </div>
                                                </div>

                                                <!-- Nút xác nhận nằm dưới tổng số tiền -->
                                                <div class="mt-4">
                                                    <button type="submit"
                                                        class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase w-100">
                                                        Xác nhận thanh toán
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>

                        </div>
                    </div>
                    <!-- Checkout Page End -->

                    <jsp:include page="../layout/footer.jsp" />

                    <!-- Back to Top -->
                    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top">
                        <i class="fa fa-arrow-up"></i>
                    </a>

                    <!-- JavaScript Libraries -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="/client/lib/easing/easing.min.js"></script>
                    <script src="/client/lib/waypoints/waypoints.min.js"></script>
                    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
                    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

                    <!-- Template Javascript -->
                    <script src="/client/js/main.js"></script>

                </body>

                </html>
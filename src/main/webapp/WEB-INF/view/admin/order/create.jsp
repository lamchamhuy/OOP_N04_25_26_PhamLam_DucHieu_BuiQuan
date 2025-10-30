<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Create Order</title>
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
                            <h1 class="mt-4">Create New Order</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                <li class="breadcrumb-item"><a href="/admin/order">Orders</a></li>
                                <li class="breadcrumb-item active">Create</li>
                            </ol>

                            <div class="mt-5">
                                <div class="row">
                                    <div class="col-8 mx-auto">
                                        <form action="/admin/order/create" method="post">

                                            <div class="mb-3">
                                                <label class="form-label">Receiver Name</label>
                                                <input type="text" name="receiverName" class="form-control" required />
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Receiver Address</label>
                                                <input type="text" name="receiverAddress" class="form-control"
                                                    required />
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Receiver Phone</label>
                                                <input type="text" name="receiverPhone" class="form-control" required />
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Total Price (VNĐ)</label>
                                                <input type="number" name="totalPrice" class="form-control" step="0.01"
                                                    required />
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Status</label>
                                                <select name="status" class="form-select" required>
                                                    <option value="PENDING">PENDING</option>
                                                    <option value="CONFIRMED">CONFIRMED</option>
                                                    <option value="SHIPPING">SHIPPING</option>
                                                    <option value="COMPLETED">COMPLETED</option>
                                                </select>
                                            </div>

                                            <button type="submit" class="btn btn-success">
                                                <i class="fas fa-plus-circle"></i> Create Order
                                            </button>
                                            <a href="/admin/order" class="btn btn-success">
                                                <i class="fas fa-arrow-left"></i> Back
                                            </a>
                                        </form>
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
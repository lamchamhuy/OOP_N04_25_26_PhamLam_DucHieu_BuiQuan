<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Update Order - LaptopShop</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Update Order</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/order">Orders</a></li>
                                    <li class="breadcrumb-item active">Update</li>
                                </ol>

                                <div class="row">
                                    <div class="col-md-6 col-12 mx-auto">
                                        <form:form method="post" action="/admin/order/update" modelAttribute="newOrder"
                                            class="p-4 border rounded shadow-sm bg-white">

                                            <!-- Order ID -->
                                            <div class="mb-3">
                                                <label class="form-label fw-bold">Order ID:</label>
                                                <form:input path="id" class="form-control" readonly="true" />
                                            </div>

                                            <!-- Total Price -->
                                            <div class="mb-3">
                                                <label class="form-label fw-bold">Price:</label>
                                                <form:input path="totalPrice" class="form-control" readonly="true" />
                                            </div>

                                            <!-- User -->
                                            <div class="mb-3">
                                                <label class="form-label fw-bold">User:</label>
                                                <form:input path="user.fullName" class="form-control" readonly="true" />
                                            </div>

                                            <!-- Status -->
                                            <div class="mb-3">
                                                <label class="form-label fw-bold">Status:</label>
                                                <form:select path="status" class="form-select">
                                                    <form:option value="PENDING">PENDING</form:option>
                                                    <form:option value="SHIPPING">SHIPPING</form:option>
                                                    <form:option value="COMPLETE">COMPLETE</form:option>
                                                    <form:option value="CANCEL">CANCEL</form:option>
                                                </form:select>
                                            </div>

                                            <div class="d-flex justify-content-end mt-4">
                                                <button type="submit" class="btn btn-primary">Update</button>
                                                <a href="/admin/order" class="btn btn-secondary ms-2">Cancel</a>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

            </html>
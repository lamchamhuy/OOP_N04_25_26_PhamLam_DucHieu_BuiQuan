<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Update User</title>
            <link href="/resources/css/styles.css" rel="stylesheet" />
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4 mt-4">
                            <h3>Update User</h3>
                            <hr />
                            <div class="col-md-6">
                                <form:form method="post" action="/admin/user/update" modelAttribute="newUser">
                                    <form:hidden path="id" />
                                    <div class="mb-3">
                                        <label>Email:</label>
                                        <form:input path="email" class="form-control" type="email" disabled="true" />
                                    </div>
                                    <div class="mb-3">
                                        <label>Phone:</label>
                                        <form:input path="phone" class="form-control" />
                                    </div>
                                    <div class="mb-3">
                                        <label>Full Name:</label>
                                        <form:input path="fullName" class="form-control" />
                                    </div>
                                    <div class="mb-3">
                                        <label>Address:</label>
                                        <form:input path="address" class="form-control" />
                                    </div>
                                    <button type="submit" class="btn btn-warning">Update</button>
                                </form:form>
                            </div>
                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
        </body>

        </html>
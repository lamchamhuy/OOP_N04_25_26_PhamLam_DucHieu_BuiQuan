<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Delete User</title>
            <link href="/resources/css/styles.css" rel="stylesheet" />
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4 mt-4">
                            <div class="alert alert-danger">
                                Are you sure you want to delete this user (ID: ${user.id})?
                            </div>
                            <form:form method="post" action="/admin/user/delete" modelAttribute="newUser">
                                <form:hidden path="id" />
                                <button class="btn btn-danger">Confirm Delete</button>
                                <a href="/admin/user" class="btn btn-secondary">Cancel</a>
                            </form:form>
                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
        </body>

        </html>
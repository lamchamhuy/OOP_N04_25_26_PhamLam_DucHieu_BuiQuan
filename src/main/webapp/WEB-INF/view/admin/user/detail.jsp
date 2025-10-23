<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>User Detail</title>
        <link href="/resources/css/styles.css" rel="stylesheet" />
    </head>

    <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp" />
        <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp" />
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                        <h3>User Detail (ID: ${user.id})</h3>
                        <hr />
                        <ul class="list-group col-md-6">
                            <li class="list-group-item">Email: ${user.email}</li>
                            <li class="list-group-item">Full Name: ${user.fullName}</li>
                            <li class="list-group-item">Phone: ${user.phone}</li>
                            <li class="list-group-item">Address: ${user.address}</li>
                        </ul>
                        <a href="/admin/user" class="btn btn-success mt-3">Back</a>
                    </div>
                </main>
                <jsp:include page="../layout/footer.jsp" />
            </div>
        </div>
    </body>

    </html>
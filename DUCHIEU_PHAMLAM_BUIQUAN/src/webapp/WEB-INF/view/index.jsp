<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Home</title>
        </head>

        <body>
            <h1>Danh sách sản phẩm</h1>
            <a href="${pageContext.request.contextPath}/user/create">Tạo user</a> | <a
                href="${pageContext.request.contextPath}/order/create">Đặt hàng</a>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Mô tả</th>
                    <th>Giá</th>
                </tr>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.description}</td>
                        <td>${p.price}</td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>
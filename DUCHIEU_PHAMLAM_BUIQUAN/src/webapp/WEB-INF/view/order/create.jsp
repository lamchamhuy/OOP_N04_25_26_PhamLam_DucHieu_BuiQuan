<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <body>
            <h2>Tạo đơn hàng</h2>
            <form action="${pageContext.request.contextPath}/order/create" method="post">
                User:
                <select name="user.id">
                    <c:forEach var="u" items="${users}">
                        <option value="${u.id}">${u.fullName} (${u.email})</option>
                    </c:forEach>
                </select><br />
                Product:
                <select name="product.id">
                    <c:forEach var="p" items="${products}">
                        <option value="${p.id}">${p.name} - ${p.price}</option>
                    </c:forEach>
                </select><br />
                Quantity: <input name="quantity" type="number" value="1" /><br />
                <button type="submit">Đặt</button>
            </form>
        </body>

        </html>
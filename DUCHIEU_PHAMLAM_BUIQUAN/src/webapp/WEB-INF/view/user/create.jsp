<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <body>
        <h2>Tạo user</h2>
        <form action="${pageContext.request.contextPath}/user/create" method="post">
            Email: <input name="email" /><br />
            Họ tên: <input name="fullName" /><br />
            Mật khẩu: <input name="password" /><br />
            Địa chỉ: <input name="address" /><br />
            Phone: <input name="phone" /><br />
            <button type="submit">Tạo</button>
        </form>
    </body>

    </html>
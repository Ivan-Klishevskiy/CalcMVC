<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 28.11.2021
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<p>Hello ${sessionScope.user}</p>
<a href="/user/reg">Registration</a><br>
<a href="/user/auth">Authorization</a><br>
</body>
</html>

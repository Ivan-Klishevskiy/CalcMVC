<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 28.11.2021
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<p>Hello ${sessionScope.user.username}!</p>
<c:if test="${sessionScope.user.username==null}">
    <a href="/user/reg">Registration</a><br>
    <a href="/user/auth">Authorization</a><br>
</c:if>
<c:if test="${sessionScope.user.username!=null}">
    <a href="/user/logout">Logout</a><br>
    <a href="/calc">Simple calculator</a><br>
</c:if>
</body>
</html>

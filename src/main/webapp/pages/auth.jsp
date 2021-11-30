<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 28.11.2021
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/user/auth" method="post">
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <button>Submit</button>
</form>
<p>${message}</p>
</body>
</html>

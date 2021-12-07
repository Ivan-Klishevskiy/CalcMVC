<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 28.11.2021
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>


<s:form action="/user/reg" method="post" modelAttribute="regUser">
    <s:input path="name" placeholder="Name"/>
    <br>
    <s:errors path="name"/>
    <br>
    <s:input path="username" placeholder="Username"/>
    <br>
    <s:errors path="username"/>
    <br>
    <s:input path="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Submit</s:button>
</s:form>

<%--<form action="/user/reg" method="post" modelAttribute="newUser">--%>
<%--    <input type="text" name="name" placeholder="Name" required>--%>
<%--    <input type="text" name="username" placeholder="Username" required>--%>
<%--    <input type="password" name="password" placeholder="Password" required>--%>
<%--    <button>Submit</button>--%>
<%--</form>--%>
<%--<p>${message}</p>--%>
</body>
</html>

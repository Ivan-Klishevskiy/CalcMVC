<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 30.11.2021
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calc/simple" method="post">
    <input type="number" name="first" placeholder="First value" value="${first}" step="any" required>
    <select name="sign">
        <option disabled>Select sign</option>
        <option value="+"selected>+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="number" name="second" placeholder="Second value" value="${second}" step="any" required>
    <button>=</button>
    ${result}
</form>
<ul>
    <c:forEach var="record" items="${history}">
        <li><c:out value="${record}"/></li>
    </c:forEach>
</ul>
</body>
</html>

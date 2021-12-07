<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
<s:form action="/calc" method="post" modelAttribute="calcModel">
    <s:input type="number" path="first" placeholder="First value" step="any"/>
    <br>
    <s:errors path="first"/>
    <br>
    <s:input path="sign" placeholder="Sign"/>
    <br>
    <s:errors path="sign"/>
    <br>
    <s:input type="number" path="second" placeholder="Second value" step="any"/>
    <br>
    <s:errors path="second"/>
    <br>
    <s:button>Submit</s:button>
    <br>
    <s:textarea path="result"/>
</s:form>
<ul>
    <c:forEach var="record" items="${history}">
        <li><c:out value="${record}"/></li>
    </c:forEach>
</ul>
</body>
</html>

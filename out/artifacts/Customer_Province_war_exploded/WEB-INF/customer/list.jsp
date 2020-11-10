<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2020
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/customers?action=create">Add New User</a>
</h2>
<h1>Customer List</h1>
<table width="100%" border="1">
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.getId()}"></c:out> </td>
            <td><c:out value="${customer.getName()}"></c:out> </td>
            <td><c:out value="${customer.getImage()}"></c:out> </td>
            <td><c:out value="${customer.getProvince().getName()}"></c:out> </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>

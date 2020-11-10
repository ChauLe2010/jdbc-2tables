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
<form method="post" >
    <table border="1" cellpadding="5">
        <caption>
            <h2>Add New Customer</h2>
        </caption>
        <tr>
            <th>Customer ID:</th>
            <td>
                <input type="text" name="cusId" id="cusId" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Customer Name:</th>
            <td>
                <input type="text" name="cusName" id="cusName" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Customer Image:</th>
            <td>
                <input type="text" name="cusImg" id="cusImg" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Province:</th>
            <td>
                <select name="provinceName">
                    <c:forEach items="${provinces}" var="province">
                        <option value="${province.getName()}"><c:out value="${province.getName()}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>

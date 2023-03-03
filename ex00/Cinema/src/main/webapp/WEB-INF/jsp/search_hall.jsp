<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 01.03.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Result Hall</title>
</head>
<body>
<div align="center">
    <h2>Search Result Hall</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Serial number</th>
            <th>Number of seats</th>
        </tr>
        <c:forEach items="${result}" var="hall">
            <tr>
                <td>${hall.id}</td>
                <td>${hall.serialNumber}</td>
                <td>${hall.numberOfSeats}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

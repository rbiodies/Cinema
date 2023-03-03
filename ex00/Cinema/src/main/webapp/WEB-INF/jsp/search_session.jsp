<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 01.03.2023
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Result Session</title>
</head>
<body>
<div align="center">
    <h2>Search Result Session</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Hall</th>
            <th>Film</th>
            <th>Time</th>
            <th>Ticket cost</th>
        </tr>
        <c:forEach items="${result}" var="session">
            <tr>
                <td>${session.id}</td>
                <td>${session.hall}</td>
                <td>${session.film}</td>
                <td>${session.time}</td>
                <td>${session.ticketCost}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

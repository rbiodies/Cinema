<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 01.03.2023
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Result Film</title>
</head>
<body>
<div align="center">
    <h2>Search Result Film</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Year of release</th>
            <th>Age restrictions</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${result}" var="film">
            <tr>
                <td>${film.id}</td>
                <td>${film.title}</td>
                <td>${film.yearOfRelease}</td>
                <td>${film.ageRestrictions}</td>
                <td>${film.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

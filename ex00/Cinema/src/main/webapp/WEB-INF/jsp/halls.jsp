<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 26.02.2023
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Hall Manager</title>
</head>
<body>
<div align="center">
  <h2>Hall Manager</h2>
  <form method="get" action="halls/search">
    <label>
      <input type="text" name="keyword" />
    </label>
    <input type="submit" value="Search" />
  </form>
  <h3><a href="halls/new">New Hall</a></h3>
  <table border="1" cellpadding="5">
    <tr>
      <th>ID</th>
      <th>Serial number</th>
      <th>Number of seats</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${listHall}" var="hall">
      <tr>
        <td>${hall.id}</td>
        <td>${hall.serialNumber}</td>
        <td>${hall.numberOfSeats}</td>
        <td>
          <a href="halls/edit?id=${hall.id}">Edit</a>

          <a href="halls/delete?id=${hall.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

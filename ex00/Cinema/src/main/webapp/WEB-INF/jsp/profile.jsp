<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 27.02.2023
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>User Manager</title>
  <style>
    body {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%)
    }
  </style>
</head>
<body>
<div align="center">
  <h2>User Manager</h2>

  <p>${user.firstName} ${user.lastName}</p>
  <p>${user.email}</p>

  <table border="1" cellpadding="5">
    <tr>
      <th>Date</th>
      <th>Time</th>
      <th>IP</th>
    </tr>
    <c:forEach items="${resultData}" var="data">
      <tr>
        <td>${data.date}</td>
        <td>${data.time}</td>
        <td>${data.ip}</td>
      </tr>
    </c:forEach>
  </table>

  <img src="client/showPic/${user.avatar}" alt=""/>

  <form method="post" action="client/doUpload" enctype="multipart/form-data" modelAttribute="user">
    Choose a file: <input type="file" name="fileUpload" />
    <input type="submit" value="Upload" />
  </form>

  <form name="profileForm" action="/" method="POST">
    <input type="submit" value="Log out" name="exit"/>
  </form>

  <table border="1" cellpadding="5">
    <tr>
      <th>File name</th>
      <th>Size</th>
      <th>MIME</th>
    </tr>
    <c:forEach items="${resultImages}" var="image">
      <tr>
        <td><a href="client/images/${image.uniqueName}">${image.fileName}</a></td>
        <td>${image.size}</td>
        <td>${image.mime}</td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

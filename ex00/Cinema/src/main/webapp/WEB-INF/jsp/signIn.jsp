<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 26.02.2023
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>User Form</title>
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
  <h2>User Form</h2>
  <form method="get" action="client">
    <label>
      <input type="email" name="email" />
    </label>
    <label>
      <input type="password" name="password" />
    </label>
    <input type="submit" value="Submit" />
    <input type="reset" value="Reset" />
  </form>
</div>
</body>
</html>

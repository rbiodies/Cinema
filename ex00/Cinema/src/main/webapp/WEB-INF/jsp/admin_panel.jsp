<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 28.02.2023
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Panel</title>
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
    <h2>Admin Panel</h2>
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='panel/halls';" value="Halls" />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='panel/films';" value="Films" />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='panel/sessions';" value="Sessions" />
</div>
</body>
</html>

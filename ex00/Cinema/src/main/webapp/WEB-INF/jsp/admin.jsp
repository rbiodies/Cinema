<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 28.02.2023
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Manager</title>
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
    <h2>Admin Manager</h2>
    <form name="panelForm" action="admin/panel" method="POST">
        <input type="submit" value="Settings" name="settings"/>
    </form>
    <form name="profileForm" action="/" method="POST">
        <input type="submit" value="Log out" name="exit"/>
    </form>
</div>
</body>
</html>

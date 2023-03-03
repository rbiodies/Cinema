<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 26.02.2023
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>New User</title>
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
  <h2>New User</h2>
  <form:form action="save" method="post" modelAttribute="user">
    <table border="0" cellpadding="5">
      <tr>
        <td>First name: </td>
        <td><form:input path="firstName" /></td>
      </tr>
      <tr>
        <td>Last name: </td>
        <td><form:input path="lastName" /></td>
      </tr>
      <tr>
        <td>Phone number: </td>
        <td><form:input path="phoneNumber" /></td>
      </tr>
      <tr>
        <td>E-mail: </td>
        <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td>Password: </td>
        <td><form:input path="password" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Save"></td>
        <td colspan="2"><input type="reset" value="Reset"></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>

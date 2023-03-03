<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 26.02.2023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New Hall</title>
</head>
<body>
<div align="center">
    <h2>New Hall</h2>
    <form:form action="save" method="post" modelAttribute="hall">
        <table border="0" cellpadding="5">
            <tr>
                <td>Serial number: </td>
                <td><form:input path="serialNumber" /></td>
            </tr>
            <tr>
                <td>Number of seats: </td>
                <td><form:input path="numberOfSeats" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

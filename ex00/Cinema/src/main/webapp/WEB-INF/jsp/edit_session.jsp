<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 01.03.2023
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Session</title>
</head>
<body>
<div align="center">
    <h2>Edit Session</h2>
    <form:form action="save" method="post" modelAttribute="session">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${session.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Movie: </td>
                <td><form:input path="film" /></td>
            </tr>
            <tr>
                <td>Movie hall: </td>
                <td><form:input path="hall" /></td>
            </tr>
            <tr>
                <td>Time: </td>
                <td><form:input path="time" /></td>
            </tr>
            <tr>
                <td>Ticket host: </td>
                <td><form:input path="ticketCost" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

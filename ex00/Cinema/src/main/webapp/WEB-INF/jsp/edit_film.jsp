<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 01.03.2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Film</title>
</head>
<body>
<div align="center">
    <h2>Edit Film</h2>
    <form:form action="save" method="post" modelAttribute="film">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${film.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Title: </td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td>Year of release: </td>
                <td><form:input path="yearOfRelease" /></td>
            </tr>
            <tr>
                <td>Age restrictions: </td>
                <td><form:input path="ageRestrictions" /></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

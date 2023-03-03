<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20228428
  Date: 26.02.2023
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Film Manager</title>
</head>
<body>
<div align="center">
    <h2>Film Manager</h2>
    <form method="get" action="films/search">
        <label>
            <input type="text" name="keyword" />
        </label>
        <input type="submit" value="Search" />
    </form>
    <h3><a href="films/new">New Film</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Year of release</th>
            <th>Age restrictions</th>
            <th>Description</th>
            <th>Poster</th>>
            <th>Action</th>
        </tr>
        <c:forEach items="${listFilm}" var="film">

            <tr>
                <td>${film.id}</td>
                <td>${film.title}</td>
                <td>${film.yearOfRelease}</td>
                <td>${film.ageRestrictions}</td>
                <td>${film.description}</td>
                <td>
                    <img src="films/showPic/${film.poster}" style="width:100px; height: 100px;" alt=""/></td>>
                <td>
                    <a href="films/edit?id=${film.id}">Edit</a>

                    <a href="films/delete?id=${film.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

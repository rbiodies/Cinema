<html lang="">
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
            <th>Poster</th>
            <th>Action</th>
        </tr>
        <#list films as film>
            <tr>
                <td>${film.id}</td>
                <td>${film.title}</td>
                <td>${film.yearOfRelease}</td>
                <td>${film.ageRestrictions}</td>
                <td>${film.description}</td>
                <td>
                    <img src="/images/${(film.poster)!}" style="width:100px; height: 100px;" alt=""/></td>
                <td>
                    <a href="films/edit?id=${film.id}">Edit</a>

                    <a href="films/delete?id=${film.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
<html lang="">
<head>
    <title>Search Result Film</title>
</head>
<body>
<div align="center">
    <h2>Search Result Film</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Year of release</th>
            <th>Age restrictions</th>
            <th>Description</th>
        </tr>
        <#list films as film>
            <tr>
                <td>${film.id}</td>
                <td>${film.name}</td>
                <td>${film.yearOfRelease}</td>
                <td>${film.ageRestrictions}</td>
                <td>${film.description}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
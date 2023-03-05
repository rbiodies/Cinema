<html>
<head>
    <title>Hall Manager</title>
</head>
<body>
<div align="center">
    <h2>Hall Manager</h2>
    <form method="get" action="halls/search">
        <label>
            <input type="text" name="keyword" />
        </label>
        <input type="submit" value="Search" />
    </form>
    <h3><a href="halls/new">New Hall</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Serial number</th>
            <th>Number of seats</th>
            <th>Action</th>
        </tr>
        <#list halls as hall>
            <tr>
                <td>${hall.id}</td>
                <td>${hall.serialNumber}</td>
                <td>${hall.numberOfSeats}</td>
                <td>
                    <a href="halls/edit?id=${hall.id}">Edit</a>

                    <a href="halls/delete?id=${hall.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
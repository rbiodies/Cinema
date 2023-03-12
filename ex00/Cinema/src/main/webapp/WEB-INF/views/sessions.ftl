<html lang="">
<head>
    <title>Session Manager</title>
</head>
<body>
<div align="center">
    <h2>Session Manager</h2>
    <form method="get" action="sessions/search">
        <label>
            <input type="text" name="keyword" />
        </label>
        <input type="submit" value="Search" />
    </form>
    <h3><a href="sessions/new">New Session</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Hall ID</th>
            <th>Serial number</th>
            <th>Number of seats</th>
            <th>Film ID</th>
            <th>Title</th>
            <th>Year of release</th>
            <th>Age restrictions</th>
            <th>Description</th>
            <th>Poster</th>
            <th>Time</th>
            <th>Ticket cost</th>
            <th>Action</th>
        </tr>
        <#list sessions as session>
            <tr>
                <td>${session.id}</td>
                <td>${session.hall.id}</td>
                <td>${session.hall.serialNumber}</td>
                <td>${session.hall.numberOfSeats}</td>
                <td>${session.film.id}</td>
                <td>${session.film.title}</td>
                <td>${session.film.yearOfRelease}</td>
                <td>${session.film.ageRestrictions}</td>
                <td>${session.film.description}</td>
                <td>
                    <img src="/images/${(session.film.poster)!}" style="width:100px; height: 100px;" alt=""/>
                </td>
                <td>${session.time}</td>
                <td>${session.ticketCost}</td>
                <td>
                    <a href="sessions/edit?id=${session.id}">Edit</a>

                    <a href="sessions/delete?id=${session.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
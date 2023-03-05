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
            <th>Hall</th>
            <th>Film</th>
            <th>Time</th>
            <th>Ticket cost</th>
            <th>Action</th>
        </tr>
        <#list sessions as session>
            <tr>
                <td>${session.id}</td>
                <td>${session.hall}</td>
                <td>${session.film}</td>
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
<html>
<head>
    <title>Search Result Session</title>
</head>
<body>
<div align="center">
    <h2>Search Result Session</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Hall</th>
            <th>Film</th>
            <th>Time</th>
            <th>Ticket cost</th>
        </tr>
        <c:forEach items="${result}" var="session">
            <tr>
                <td>${session.id}</td>
                <td>${session.hall}</td>
                <td>${session.film}</td>
                <td>${session.time}</td>
                <td>${session.ticketCost}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
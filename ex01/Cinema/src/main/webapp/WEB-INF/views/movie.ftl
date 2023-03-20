<html lang="">
<head>
    <title>Movie</title>
</head>
<body>
<div align="center">
    <h2>Movie</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Serial number</th>
            <th>Number of seats</th>
            <th>Title</th>
            <th>Year of release</th>
            <th>Age restrictions</th>
            <th>Description</th>
            <th>Ticket cost</th>
        </tr>
        <tr>
            <td>${session.hall.serialNumber}</td>
            <td>${session.hall.numberOfSeats}</td>
            <td>${session.film.name}</td>
            <td>${session.film.yearOfRelease}</td>
            <td>${session.film.ageRestrictions}</td>
            <td>${session.film.description}</td>
            <td>${session.ticketCost}</td>
        </tr>
    </table>
</div>
</body>
</html>
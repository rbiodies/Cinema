<html lang="">
<head>
    <title>Search Result Hall</title>
</head>
<body>
<div align="center">
    <h2>Search Result Hall</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Serial number</th>
            <th>Number of seats</th>
        </tr>
        <#list halls as hall>
            <tr>
                <td>${hall.id}</td>
                <td>${hall.serialNumber}</td>
                <td>${hall.numberOfSeats}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
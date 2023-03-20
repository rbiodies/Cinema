<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>New Session</title>
</head>
<body>
<div align="center">
    <h2>New Session</h2>
    <form action="save" method="post" modelAttribute="session">
        <table border="0" cellpadding="5">
            <tr>
                <td>Movie ID: </td>
                <td><@spring.formInput "session.film.id" "" "text"/></td>
            </tr>
            <tr>
                <td>Hall ID: </td>
                <td><@spring.formInput "session.hall.id" "" "text"/></td>
            </tr>
            <tr>
                <td>Time: </td>
                <td><@spring.formInput "session.dateTime" "" "text"/></td>
            </tr>
            <tr>
                <td>Ticket cost: </td>
                <td><@spring.formInput "session.ticketCost" "" "text"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
                <td colspan="2"><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
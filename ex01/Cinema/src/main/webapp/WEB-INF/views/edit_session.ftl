<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>Edit Session</title>
</head>
<body>
<div align="center">
    <h2>Edit Session</h2>
    <form action="save" method="post" modelAttribute="session">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${session.id}
                    <@spring.formHiddenInput "session.id" ""/>
                </td>
            </tr>
            <tr>
                <td>Movie: </td>
                <td><@spring.formInput "session.film" "" "text"/></td>
            </tr>
            <tr>
                <td>Movie hall: </td>
                <td><@spring.formInput "session.hall" "" "text"/></td>
            </tr>
            <tr>
                <td>Time: </td>
                <td><@spring.formInput "session.time" "" "text"/></td>
            </tr>
            <tr>
                <td>Ticket host: </td>
                <td><@spring.formInput "session.ticketCost" "" "text"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
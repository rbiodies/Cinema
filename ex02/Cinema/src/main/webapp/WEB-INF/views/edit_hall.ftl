<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>Edit Hall</title>
</head>
<body>
<div align="center">
    <h2>Edit Hall</h2>
    <form action="save" method="post" modelAttribute="hall">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${hall.id}
                    <@spring.formHiddenInput "hall.id" ""/>
                </td>
            </tr>
            <tr>
                <td>Serial number: </td>
                <td><@spring.formInput "hall.serialNumber" "" "text"/></td>
            </tr>
            <tr>
                <td>Number of seats: </td>
                <td><@spring.formInput "hall.numberOfSeats" "" "text"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
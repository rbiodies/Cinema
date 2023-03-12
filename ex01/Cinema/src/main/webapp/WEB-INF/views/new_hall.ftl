<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>New Hall</title>
</head>
<body>
<div align="center">
    <h2>New Hall</h2>
    <form action="save" method="post" modelAttribute="hall">
        <table border="0" cellpadding="5">
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
                <td colspan="2"><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
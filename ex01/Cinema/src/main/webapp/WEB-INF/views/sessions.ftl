<html lang="">
<head>
    <title>Session Manager</title>
</head>
<body>
<div align="center">
    <h2>Session Manager</h2>
    <form method="get" action="sessions/search">
        <label>
            <input type="text" id="SearchBy" name="filmName" />
        </label>
        <input type="submit" id="SearchBtn" value="Search" />
    </form>
    <h3><a href="sessions/new">New Session</a></h3>
    <table border="1" cellpadding="5" id="tblSessions">
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

<#--    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<#--    <script type="text/javascript">-->
<#--        $(function () {-->
<#--            GetSessions();-->
<#--            $("#SearchBtn").keyup(function () {-->
<#--                GetSessions();-->
<#--            });-->
<#--        });-->
<#--        function GetSessions() {-->
<#--            var filmName = $.trim($("#filmName").val());-->
<#--            $.ajax({-->
<#--                type: "POST",-->
<#--                url: "sessions/search",-->
<#--                data: "{filmName:'" + filmName + "'}",-->
<#--                contentType: "application/json; charset=utf-8",-->
<#--                dataType: "json",-->
<#--                success: function (sessions) {-->
<#--                    var table = $("#tblSessions");-->
<#--                    table.find("tr:not(:first)").remove();-->
<#--                    $.each(sessions, function (i, session) {-->
<#--                        var table = $("#tblSessions");-->
<#--                        var row = table[0].insertRow(-1);-->
<#--                        $(row).append("<td />");-->
<#--                        $(row).find("td").eq(0).html(session.hall);-->
<#--                        $(row).append("<td />");-->
<#--                        $(row).find("td").eq(1).html(session.film);-->
<#--                        $(row).append("<td />");-->
<#--                        $(row).find("td").eq(2).html(session.time);-->
<#--                        $(row).append("<td />");-->
<#--                        $(row).find("td").eq(3).html(session.ticketCost);-->
<#--                    });-->
<#--                }-->
<#--            });-->
<#--        }-->
<#--    </script>-->
</body>
</html>
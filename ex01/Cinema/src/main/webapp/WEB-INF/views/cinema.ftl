<!DOCTYPE html>
<html lang="">
<head>
    <title>Cinema</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#search-input').on('input', function() {
                const searchQuery = $(this).val();

                $.ajax({
                    url: '/sessions/search?filmName=' + searchQuery,
                    success: function(sessions) {
                        $('#session-list').empty();

                        sessions.forEach(function(session) {
                            $('#session-list').append(
                                '<tr>' +
                                    '<td>' +
                                        '<img src="/' + session.film.posterUrl + '" style="width:100px; height: 100px;" alt=""/>' +
                                    '</td>' +
                                    '<td>' + session.dateTime + '</td>' +
                                    '<td><a href="/sessions/' + session.id + '">' + session.film.name + '</a></td>' +
                                '<tr>'
                            );
                        });
                    }
                });
            });
        });
    </script>
</head>
<body>

<div align="center">
    <label for="search-input"></label>
    <input type="text" id="search-input" name="filmName" />

    <table id="session-list" border="1" cellpadding="5">
        <#list sessions as session>
            <tr>
                <td>
                    <img src="/${(session.film.posterUrl)!}" style="width:100px; height: 100px;" alt=""/>
                </td>
                <td>${session.dateTime}</td>
                <td><a href="/sessions/${session.id}">${session.film.name}</a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
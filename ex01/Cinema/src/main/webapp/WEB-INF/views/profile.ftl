<html lang="">
<head>
    <title>User</title>
    <style>
        .avatar {
            width: 200px;
            height: 200px;
            object-fit:cover;
            border-radius:50%;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>User</h2>

    <p>${user.firstName} ${user.lastName}</p>
    <p>${user.email}</p>

    <table border="1" cellpadding="5">
        <tr>
            <th>Date</th>
            <th>Time</th>
            <th>IP</th>
        </tr>
        <#list data as data>
            <tr>
                <td>${data.date}</td>
                <td>${data.time}</td>
                <td>${data.ip}</td>
            </tr>
        </#list>
    </table>

    <img src="/${(user.avatarUrl)!}" alt="" class="avatar"/>

    <form method="post" action="client/upload" enctype="multipart/form-data" modelAttribute="user">
        Choose a file: <input type="file" name="fileUpload" />
        <input type="submit" value="Upload" />
    </form>

    <form name="profileForm" action="/" method="POST">
        <input type="submit" value="Log out" name="exit"/>
    </form>

    <table border="1" cellpadding="5">
        <tr>
            <th>File name</th>
            <th>Size</th>
            <th>MIME</th>
        </tr>
        <#list images as image>
            <tr>
                <td><a href="/${(image.url)!}">${image.fileName}</a></td>
                <td>${image.size}</td>
                <td>${image.mime}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
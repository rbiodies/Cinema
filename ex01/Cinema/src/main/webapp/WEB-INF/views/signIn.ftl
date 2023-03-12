<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>User Form</title>
    <style>
        body {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%)
        }
    </style>
</head>
<body>
<div align="center">
    <h2>User Form</h2>
    <form name="user" action="search" method="POST">
            <@spring.formInput "user.email" "" "text"/>
            <@spring.formPasswordInput "user.password" ""/>
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
    </form>
</div>
</body>
</html>
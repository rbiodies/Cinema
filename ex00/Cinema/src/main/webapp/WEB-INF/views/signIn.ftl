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
    <form method="get" action="client">
        <label>
            <input type="email" name="email" />
        </label>
        <label>
            <input type="password" name="password" />
        </label>
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
    </form>
</div>
</body>
</html>
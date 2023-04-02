<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>New Film</title>
</head>
<body>
<div align="center">
    <h2>New Film</h2>
    <form action="save" method="post" enctype="multipart/form-data" modelAttribute="film">
        <table border="0" cellpadding="5">
            <tr>
                <td>Title: </td>
                <td><@spring.formInput "film.name" "" "text"/></td>
            </tr>
            <tr>
                <td>Year of release: </td>
                <td><@spring.formInput "film.yearOfRelease" "" "text"/></td>
            </tr>
            <tr>
                <td>Age restrictions: </td>
                <td><@spring.formInput "film.ageRestrictions" "" "text"/></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><@spring.formInput "film.description" "" "text"/></td>
            </tr>
            <tr>
                <td>Poster: </td>
                <td><input type="file" name="fileUpload" /></td>
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
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form action="/add2" method="post">
        <div>
            <input type="text" name="num">
            <input type="text" name="num">
            <input type="text" name="num">
            <input type="text" name="num">
        </div>
        <div>
            <input type="submit" value="계산">
        </div>
        <div>
            결과 : ${result}
        </div>
    </form>
</body>
</html>
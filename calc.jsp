<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form action="/calc" method="post">
        <div>
            <label>x : </label>
            <input type="text" name="x">
        </div>
        <div>
            <label>y : </label>
            <input type="text" name="y">
        </div>
        <div>
            <input type="submit" name="operator" value="덧셈">
            <input type="submit" name="operator" value="뺄셈">
        </div>
        <div>
            결과 : ${result}
        </div>
    </form>
</body>
</html>
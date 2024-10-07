<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form action="/calc2" method="post">
        <div>
            <label>입력 : </label>
            <input type="text" name="v">
        </div>
        <div>
            <input type="submit" name="operator" value="+">
            <input type="submit" name="operator" value="-">
            <input type="submit" name="operator" value="=">
        </div>
        <div>
            결과 : ${result}
        </div>
    </form>
</body>
</html>
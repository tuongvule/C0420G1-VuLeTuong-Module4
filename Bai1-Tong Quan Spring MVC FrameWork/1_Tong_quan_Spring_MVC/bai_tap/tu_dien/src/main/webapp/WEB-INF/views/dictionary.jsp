
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form method="post" action="/dictionary">
    <label>English: </label>
    <input type="text" name="Eng" placeholder="English" ><br>
    <p>Vietnamese : ${result}</p>
    <input type="submit" id="submit" value="Search">
</form>
</body>
</html>
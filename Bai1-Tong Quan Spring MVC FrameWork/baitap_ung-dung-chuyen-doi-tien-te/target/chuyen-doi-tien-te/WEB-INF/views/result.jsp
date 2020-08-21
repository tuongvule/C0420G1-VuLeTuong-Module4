<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/20/2020
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <label>Usd</label>
    <input type="text" name="usd" value="0">
    <lable>rate</lable>
    <input type="text" name="rate" value="23000">
    <input type="submit" value="convert dollar to vnd">
    <h3>Total: ${result}</h3>
</form>
</body>
</html>

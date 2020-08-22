<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/22/2020
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionaryController" method="post">
    <label >Input a word</label>
    <input type="text" name="key">
    <input type="submit" value="Search" >
    <p>Result: ${key}: ${result}</p>
</form>
</body>
</html>

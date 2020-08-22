<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/20/2020
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<p>Student: ${student}</p>--%>
<%--<h3>${student.name}</h3>--%>
<%--<h3>Age: ${student.age}</h3>--%>

<form action="/student/edit">
    <input type="text" name="name">
    <input type="text" name="age">
    <input type="submit" value="Submit">
</form>
</body>
</html>

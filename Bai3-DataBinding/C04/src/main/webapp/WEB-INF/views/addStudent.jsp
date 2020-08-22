<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 8/21/2020
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Add New Student</h3>
<form:form action="/student/addStudent" method="post" modelAttribute="student">
    <label>Id: </label>
    <form:input path="id"/>
    <br>
    <br>
    <label>Name: </label>
    <form:input path="name"/>
    <br>
    <br>
    <label>Age: </label>
    <form:input path="age"/>
    <br>
    <br>
    <label>Gender: </label>
    <form:radiobuttons items="${gender}" path="gender"/>
<%--    Nu: <c:checkbox path="gender" value="Nu"/>--%>
    <br>
    <br>
    <select>
        <option>Java</option>
        <option>PHP</option>
    </select>
    <input type="submit" value="Add">
</form:form>

</body>
</html>

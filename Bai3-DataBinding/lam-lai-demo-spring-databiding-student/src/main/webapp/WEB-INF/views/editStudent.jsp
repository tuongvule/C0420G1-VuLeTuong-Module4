<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/21/2020
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Edit Student Form</h3>
<c:form action="/student/editStudent" method="post" modelAttribute="student">
    <label></label>
    <c:hidden path="id"/>
    <br>
    <br>
    <label>Name</label>
    <c:input path="name"/>
    <br>
    <br>
    <label>Age</label>
    <c:input path="age"/>
    <br>
    <br>
    <label>Gender</label>
    <c:radiobuttons path="gender" items="${gender}"/>
    <br>
    <br>
    <input type="submit" value="Save">
</c:form>

</body>
</html>
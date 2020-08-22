<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 8/20/2020
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student/addStudent">Add New Student</a>
    <h3>List Student</h3>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.age}</td>
            <td><a href="/student/delete/${student.id}">Delete</a> </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student/addStudent"> Add New Student</a>
<h3>List of Students</h3>
<table border="1" style="border-collapse: collapse">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><a href="/student/delete/${student.id}">Delete</a><span>-   -</span><a href="/student/editStudent/${student.id}">Edit</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

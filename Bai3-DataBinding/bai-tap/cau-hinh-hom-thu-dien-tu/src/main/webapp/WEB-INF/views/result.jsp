<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/23/2020
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="emailConfiguration" method="post">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td>${emailConfiguration.language}</td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size</form:label></td>
            <td>${emailConfiguration.pageSize}</td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spams Filter</form:label></td>
            <td>${emailConfiguration.spamFilter}</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td>${emailConfiguration.signature}</td>
        </tr>
    </table>
</form:form>
</body>
</html>

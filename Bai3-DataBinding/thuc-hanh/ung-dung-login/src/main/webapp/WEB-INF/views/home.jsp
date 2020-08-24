<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/23/2020
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${message}</p>
<form:form action="loginController" method="post" modelAttribute="login" >
  <form:label path="account">Account</form:label>
    <form:input path="account"></form:input>
  <form:label path="password">Password</form:label>
    <form:password path="password"></form:password>
  <form:button>Login</form:button>
</form:form>
</body>
</html>

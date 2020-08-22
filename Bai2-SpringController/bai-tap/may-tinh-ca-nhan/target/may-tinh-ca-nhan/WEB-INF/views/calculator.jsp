<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/22/2020
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Calculator</h3>
<form action="/calculatorController">
    <input type="text" name="number1"><input type="text" name="number2">
    <br><br>
    <input type="submit" name="calculator" value="Addition(+)"><input type="submit" name="calculator" value="Subtraction(-)">
    <input type="submit" name="calculator" value="Multiplication(X)"><input type="submit" name="calculator" value="Division(/)">
    <p > Result: ${result}</p>

</form>
</body>
</html>

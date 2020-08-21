<%--
  Created by IntelliJ IDEA.
  User: sf book
  Date: 08/20/20
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator">
    <div style="margin-bottom: 15px">
        <input type="text" name="num1">
        <input type="text" name="num2"><br>
    </div>
    <input type="submit" name="calculate" value="Addition(+)">
    <input type="submit" name="calculate" value="Subtraction(-)">
    <input type="submit" name="calculate" value="Multiplication(x)">
    <input type="submit" name="calculate" value="Division(/)">

    <p>Result :${result}</p>

</form>

</body>
</html>

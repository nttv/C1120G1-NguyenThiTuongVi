<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 30-Mar-21
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1><br>
<form action="/calculate">
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}">
    <br><br>
    <button type="submit" name="operator" value="Addition">Addition (+)</button>
    <button type="submit" name="operator" value="Subtraction">Subtraction (-)</button>
    <button type="submit" name="operator" value="Multiplication">Multiplication (X)</button>
    <button type="submit" name="operator" value="Division">Division (/)</button>
</form>
<br>
<c:if test="${result != null}">
    <h3>Result ${operator}: ${result}</h3>
</c:if>
</body>
</html>

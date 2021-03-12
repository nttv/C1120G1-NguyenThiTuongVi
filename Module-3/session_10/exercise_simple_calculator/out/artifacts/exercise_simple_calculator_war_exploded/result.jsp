<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 11-Mar-21
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<c:if test="${not empty result}">
    <h1>Result:</h1><br>
    ${firstOperand} ${operator} ${secondOperand} = ${result}
</c:if>
<c:if test="${empty result}">
    <h1>Error: Divide by zero</h1>
</c:if>
</body>
</html>

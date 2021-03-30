<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 29-Mar-21
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<h2>
    <c:if test="${not empty meaning}">
        Meaning: ${meaning}
    </c:if>
    <c:if test="${empty meaning}">
        Word not found.
    </c:if>
</h2>
</body>
</html>

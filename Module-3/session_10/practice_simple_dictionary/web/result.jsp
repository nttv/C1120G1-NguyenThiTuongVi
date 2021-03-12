<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 11-Mar-21
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>

<%--<c:if test="${not empty result}">--%>
<%--    <h2>Word: ${search}</h2>--%>
<%--    <h2>Result: ${result}</h2>--%>
<%--</c:if>--%>
<%--<c:if test="${empty result}">--%>
<%--    <h2>Not found</h2>--%>
<%--</c:if>--%>

<c:choose>
    <c:when test="${empty result}">
        <h2>Not found</h2>
    </c:when>
    <c:otherwise>
        <h2>Word: ${search}</h2>
        <h2>Result: ${result}</h2>
    </c:otherwise>
</c:choose>

</body>
</html>

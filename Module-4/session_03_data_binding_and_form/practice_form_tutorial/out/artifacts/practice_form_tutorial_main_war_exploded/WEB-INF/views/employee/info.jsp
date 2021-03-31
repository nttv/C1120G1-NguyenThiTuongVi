<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 31-Mar-21
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>ID :</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Name :</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Contact Number :</td>
        <td>${employee.contactNumber}</td>
    </tr>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 15-Mar-21
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <style>
        .container {
            margin: auto;
        }
        h1, p {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>List of Users</h1>
    <p>
        <a href="user?action=create">Add new user</a>
    </p>
    <table class="table table-hover">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${users}' var="user">
            <tr>
                <td><a href="user?action=view&id=${user.id}">${user.id}</a></td>
                <td><a href="user?action=view&id=${user.id}">${user.name}</a></td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td><a href="user?action=edit&id=${user.id}">Edit</a></td>
                <td><a href="user?action=delete&id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

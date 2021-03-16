<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 15-Mar-21
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Management Application</title>
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
    <h1>Customer List</h1>
    <p>
        <a href="customer?action=create">Create new customer</a>
    </p>
    <table class="table table-hover">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${customers}' var="customer">
            <tr>
                <td><a href="customer?action=view&id=${customer.id}">${customer.id}</a></td>
                <td><a href="customer?action=view&id=${customer.id}">${customer.name}</a></td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td><a href="customer?action=edit&id=${customer.id}">Edit</a></td>
                <td><a href="customer?action=delete&id=${customer.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

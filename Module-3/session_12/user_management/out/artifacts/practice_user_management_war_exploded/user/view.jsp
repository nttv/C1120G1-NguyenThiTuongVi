<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 15-Mar-21
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <style>
        .container {
            margin: auto;
            width: fit-content;
        }

        h1, p {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>User details</h1>
    <p>
        <a href="../user">Back to user list</a>
    </p>
    <table class="table">
        <tr>
            <th>User ID:</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>User Name:</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>User Email:</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>${user.country}</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <a href="user?action=edit&id=${user.id}">
                    <button>Edit</button>
                </a>
                <a href="user?action=delete&id=${user.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

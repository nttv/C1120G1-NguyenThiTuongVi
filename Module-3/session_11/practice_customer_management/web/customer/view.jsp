<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 15-Mar-21
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Management Application</title>
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
    <h1>Customer details</h1>
    <p>
        <a href="../customer">Back to customer list</a>
    </p>
    <table class="table">
        <tr>
            <th>Customer ID:</th>
            <td>${customer.id}</td>
        </tr>
        <tr>
            <th>Customer Name:</th>
            <td>${customer.name}</td>
        </tr>
        <tr>
            <th>Customer Email:</th>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <th>Customer Address:</th>
            <td>${customer.address}</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <a href="customer?action=edit&id=${customer.id}">
                    <button>Edit</button>
                </a>
                <a href="customer?action=delete&id=${customer.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

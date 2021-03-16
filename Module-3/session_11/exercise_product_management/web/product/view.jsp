<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 16-Mar-21
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management Application</title>
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
    <h1>Product details</h1>
    <p>
        <a href="../product">Back to product list</a>
    </p>
    <table class="table">
        <tr>
            <th>Product ID:</th>
            <td>${product.id}</td>
        </tr>
        <tr>
            <th>Product Name:</th>
            <td>${product.name}</td>
        </tr>
        <tr>
            <th>Price:</th>
            <td>${product.price}</td>
        </tr>
        <tr>
            <th>Description:</th>
            <td>${product.description}</td>
        </tr>
        <tr>
            <th>Manufacturer:</th>
            <td>${product.manufacturer}</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <a href="product?action=edit&id=${product.id}">
                    <button>Edit</button>
                </a>
                <a href="product?action=delete&id=${product.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

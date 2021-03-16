<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 16-Mar-21
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        .table {
            width: auto;
        }

        h1, p {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Edit Product</h1>
    <p>
        <a href="../product">Back to product list</a>
    </p>
    <form method="post" action="../product">
        <table class="table">
            <c:if test="${not empty product}">
                <input type="hidden" name="id" value="${product.id}"/>
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td><input type="text" name="name" size="45" value="${product.name}"/></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="text" name="price" size="45" value="${product.price}"/></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><input type="text" name="description" size="45" value="${product.description}"/></td>
            </tr>
            <tr>
                <th>Manufacturer:</th>
                <td><input type="text" name="manufacturer" size="45" value="${product.manufacturer}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="action" value="edit">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

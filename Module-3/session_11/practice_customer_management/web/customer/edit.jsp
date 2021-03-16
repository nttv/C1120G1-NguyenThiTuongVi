<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 15-Mar-21
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h1>Edit Customer</h1>
    <p>
        <a href="../customer">Back to customer list</a>
    </p>
    <form method="post" action="../customer">
        <table class="table">
            <c:if test="${not empty customer}">
                <input type="hidden" name="id" value="${customer.id}"/>
            </c:if>
            <tr>
                <th>Customer Name:</th>
                <td><input type="text" name="name" size="45" value="${customer.name}"/></td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td><input type="text" name="email" size="45" value="${customer.email}"/></td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td><input type="text" name="country" size="15" value="${customer.address}"/></td>
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

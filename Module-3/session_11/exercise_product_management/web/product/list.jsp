<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 16-Mar-21
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <script src="../js/bootstrap.js"></script>
    <script src="../js/bootstrap.bundle.js"></script>
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
    <h1>Product List</h1>
    <p>
        <a href="product?action=create">Create new product</a>
    </p>
    <p>
        <a href="#searchModal" class="search" data-toggle="modal">Search for products</a>
    </p>
    <table class="table table-hover">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Manufacturer</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items='${products}' var="product">
            <tr>
                <td><a href="product?action=view&id=${product.id}">${product.id}</a></td>
                <td><a href="product?action=view&id=${product.id}">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.manufacturer}</td>
                <td><a href="product?action=edit&id=${product.id}">Edit</a></td>
                <td><a href="product?action=delete&id=${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="../product" method="post">
                <div class="modal-header text-center">
                    <h5 class="modal-title w-100 font-weight-bold" id="searchModalLabel">Search for products</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Enter product name:</label>
                        <input type="text" class="form-control" name="name">
                        <input type="hidden" name="action" value="search">
                    </div>
                </div>
                <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>--%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 11-Mar-21
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/calculate" method="post">
    <label>Product Description</label><br>
    <input type="text" name="product"><br><br>
    <label>List Price</label><br>
    <input type="text" name="price" value="0"><br><br>
    <label>Discount Percent</label><br>
    <input type="text" name="discount" value="0"><br><br>
    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>

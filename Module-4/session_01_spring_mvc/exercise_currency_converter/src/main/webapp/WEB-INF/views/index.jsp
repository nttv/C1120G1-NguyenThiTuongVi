<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 29-Mar-21
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <style>
        td {
            height: 40px;
        }
    </style>
</head>
<body>
<h1>Currency Converter</h1><br>
<form action="/convert">
    <table>
        <tr>
            <td><h4><label for="exchange-rate">Exchange Rate:</label></h4></td>
            <td><input type="number" name="rate" id="exchange-rate" value="${rate}"></td>
        </tr>
        <tr>
            <td><h4><label for="usd">USD:</label></h4></td>
            <td><input type="number" name="usd" id="usd" value="${usd}"></td>
        </tr>
        <tr>
            <th colspan="2"><input type="submit" value="Convert"></th>
        </tr>
        <tr>
            <td><h4>VND:</h4></td>
            <td><h4>${vnd}</h4></td>
        </tr>
    </table>
</form>
</body>
</html>

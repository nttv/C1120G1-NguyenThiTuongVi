<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 11-Mar-21
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        h2, h4 {
            text-align: center;
        }

        img {
            width: 50px;
            height: 50px;
            border: 1px solid lightgray;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Danh sách khách hàng</h2><br>
    <c:if test="${empty customerList}">
        <h4>Không có khách hàng nào trong danh sách</h4>
    </c:if>
    <c:if test="${not empty customerList}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Ảnh</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.name}</td>
                    <td>${customer.birthday}</td>
                    <td>${customer.address}</td>
                    <td><img src="/img/${customer.photo}" alt="${customer.photo}"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>

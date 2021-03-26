<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 18-Mar-21
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
<link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="../css/style.css">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="../img/favicon.png" type="image/x-icon"/>
    <title>Furama Resort Danang - A Culinary Beach Resort In Vietnam</title>
</head>
<body class="custom-background d-flex flex-column">

<jsp:include page="../component/header.jsp"/>

<div id="page-content" class="container">
    <div class="row justify-content-center py-3">
        <h1>Customer Detail</h1>
    </div>
    <table class="table">
        <tr>
            <th class="align-middle">Customer ID</th>
            <td>${customer.customerId}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Name</th>
            <td>${customer.customerName}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Type</th>
            <td>${customer.customerType.customerTypeName}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Birthday</th>
            <td>${customer.customerBirthday}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Gender</th>
            <td>
                <c:if test="${customer.customerGender}">
                    Male
                </c:if>
                <c:if test="${not customer.customerGender}">
                    Female
                </c:if>
            </td>
        </tr>
        <tr>
            <th class="align-middle">Customer ID Card</th>
            <td>${customer.customerIdCard}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Phone</th>
            <td>${customer.customerPhone}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Email</th>
            <td>${customer.customerEmail}</td>
        </tr>
        <tr>
            <th class="align-middle">Customer Address</th>
            <td>${customer.customerAddress}</td>
        </tr>
        <tr>
            <td colspan="2" class="text-center">
                <a href="../customer">
                    <button class="btn btn-info px-4">Back</button>
                </a>
                <a href="../customer?action=edit&id=${customer.customerId}">
                    <button class="btn btn-warning px-4">
                        <i class="fas fa-edit"></i> Edit
                    </button>
                </a>
                <a href="../customer?action=delete&id=${customer.customerId}">
                    <button class="btn btn-danger px-4">
                        <i class="fas fa-ban"></i> Delete
                    </button>
                </a>
            </td>
        </tr>
    </table>
</div>

<jsp:include page="../component/footer.jsp"/>
</body>
</html>

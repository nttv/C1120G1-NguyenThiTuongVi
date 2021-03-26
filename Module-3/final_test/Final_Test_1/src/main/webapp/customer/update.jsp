<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 18-Mar-21
  Time: 4:04 PM
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
        <h1>Edit Customer</h1>
    </div>
    <form class="form" action="../customer" method="post">
        <table class="table">
            <tr class="form-group">
                <th class="align-middle"><label for="id">Customer ID<span class="text-danger font-weight-bold">*</span></label>
                </th>
                <td><input class="form-control" type="text" name="id" id="id" value="${customer.customerId}" readonly>
                </td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="name">Customer Name<span
                        class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="text" name="name" id="name" value="${customer.customerName}"
                           required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="type">Customer Type<span
                        class="text-danger font-weight-bold">*</span></label></th>
                <td>
                    <select name="type" class="custom-select" id="type" required>
                        <option disabled>Select Customer Type</option>
                        <option value="1" <c:if test="${customer.customerType.customerTypeId==1}">selected</c:if>>
                            Diamond
                        </option>
                        <option value="2" <c:if test="${customer.customerType.customerTypeId==2}">selected</c:if>>
                            Platinum
                        </option>
                        <option value="3" <c:if test="${customer.customerType.customerTypeId==3}">selected</c:if>>Gold
                        </option>
                        <option value="4" <c:if test="${customer.customerType.customerTypeId==4}">selected</c:if>>
                            Silver
                        </option>
                        <option value="5" <c:if test="${customer.customerType.customerTypeId==5}">selected</c:if>>
                            Member
                        </option>
                    </select>
                </td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="birthday">Customer Birthday<span
                        class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="date" name="birthday" id="birthday"
                           value="${customer.customerBirthday}" required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle">Customer Gender<span class="text-danger font-weight-bold">*</span></th>
                <td>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="gender-1" name="gender" value="true"
                               <c:if test="${customer.customerGender}">checked</c:if>>
                        <label class="custom-control-label" for="gender-1">Male</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="gender-0" name="gender" value="false"
                               <c:if test="${not customer.customerGender}">checked</c:if>>
                        <label class="custom-control-label" for="gender-0">Female</label>
                    </div>
                </td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="idCard">Customer ID Card<span class="text-danger font-weight-bold">*</span></label>
                </th>
                <td><input class="form-control" type="text" name="idCard" id="idCard" value="${customer.customerIdCard}"
                           required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="phone">Customer Phone<span
                        class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="text" name="phone" id="phone" value="${customer.customerPhone}"
                           required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="email">Customer Email</label></th>
                <td><input class="form-control" type="text" name="email" id="email" value="${customer.customerEmail}">
                </td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="address">Customer Address</label></th>
                <td><input class="form-control" type="text" name="address" id="address"
                           value="${customer.customerAddress}"></td>
            </tr>
            <tr>
                <td colspan="2" class="text-center">
                    <button class="btn btn-info px-4" type="submit" name="action" value="view">Cancel</button>
                    <button class="btn btn-success px-4" type="submit" name="action" value="edit">Update</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="../component/footer.jsp"/>
</body>
</html>

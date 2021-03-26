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
    <title>Furama Resort Danang - A Culinary Beach Resort In Vietnam</title>
</head>

<body class="custom-background d-flex flex-column">

<div id="page-content" class="container">
    <div class="row justify-content-center py-3">
        <h1>Add New Customer</h1>
    </div>
    <form class="form" action="../customer" method="post">
        <table class="table">
            <tr class="form-group">
                <th class="align-middle"><label for="id">Customer ID<span class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="text" name="id" id="id" required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="name">Customer Name<span class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="text" name="name" id="name" required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="type">Customer Type<span class="text-danger font-weight-bold">*</span></label></th>
                <td>
                    <select name="type" class="custom-select" id="type" required>
                        <option disabled selected>Select Customer Type</option>
                        <option value="1">Diamond</option>
                        <option value="2">Platinum</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="birthday">Customer Birthday<span class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="date" name="birthday" id="birthday" required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle">Customer Gender<span class="text-danger font-weight-bold">*</span></th>
                <td>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="gender-1" name="gender" value="true"
                               checked>
                        <label class="custom-control-label" for="gender-1">Male</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="gender-0" name="gender" value="false">
                        <label class="custom-control-label" for="gender-0">Female</label>
                    </div>
                </td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="idCard">Customer ID Card<span class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="text" name="idCard" id="idCard" required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="phone">Customer Phone<span class="text-danger font-weight-bold">*</span></label></th>
                <td><input class="form-control" type="text" name="phone" id="phone" required></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="email">Customer Email</label></th>
                <td><input class="form-control" type="text" name="email" id="email"></td>
            </tr>
            <tr class="form-group">
                <th class="align-middle"><label for="address">Customer Address</label></th>
                <td><input class="form-control" type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td colspan="2" class="text-center">
                    <a href="../customer"><button class="btn btn-secondary px-4" type="button">Back</button></a>
                    <button class="btn btn-success px-4" type="submit" name="action" value="create">Add</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 18-Mar-21
  Time: 4:06 PM
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

<div id="page-content" class="container mb-4">
    <div class="row d-flex">
        <h1 class="col py-3">Customer List</h1>
        <div class="col text-right my-auto mr-3">
            <a href="customer?action=create">
                <button class="btn btn-success p-1"><i class="fas fa-plus fa-2x"></i>
                </button>
            </a>
        </div>
    </div>
    <table class="table table-hover" id="customerTable">
        <thead>
        <tr>
            <th>Id</th>
            <th>Type</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Id Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items='${customers}' var="customer">
            <tr>
                <td class="pl-0 pr-1 align-middle"><a
                        href="customer?action=view&id=${customer.customerId}">${customer.customerId}</a></td>
                <td class="pl-0 pr-1 align-middle">${customer.customerName}</td>
                <td class="pl-0 pr-1 align-middle">${customer.customerType.customerTypeName}</td>
                <td class="pl-0 pr-1 align-middle">${customer.customerBirthday}</td>
                <td class="pl-0 pr-1 align-middle">
                    <c:if test="${customer.customerGender}">
                        Male
                    </c:if>
                    <c:if test="${not customer.customerGender}">
                        Female
                    </c:if>
                </td>
                <td class="pl-0 pr-1 align-middle">${customer.customerIdCard}</td>
                <td class="pl-0 pr-1 align-middle">${customer.customerPhone}</td>
                <td class="pl-0 pr-1 align-middle">${customer.customerEmail}</td>
                <td class="pl-0 pr-1 align-middle">${customer.customerAddress}</td>
                <td class="pl-0 pr-1 align-middle">
                    <a href="customer?action=edit&id=${customer.customerId}">
                        <button class="btn btn-warning p-2">
                            <i class="fas fa-edit"></i></button>
                    </a>
                    <button class="btn btn-danger p-2" data-toggle="modal" data-target="#deleteModal"
                            onclick="customerSetId('${customer.customerId}')">
                        <i class="fas fa-ban"></i></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../component/footer.jsp"/>

<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../bootstrap413/js/bootstrap.bundle.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>

<jsp:include page="../modal/delete-confirm.jsp"/>

<script>
    $(document).ready(function () {
        $('#customerTable').dataTable({
            // "dom": 'lrtip',
            // "lengthChange": false,
            "pageLength": 5,
            "searching": false,
            "lengthChange": false
        })
    })

    // $(document).ready(function () {
    //     $("#searchValue").on("keyup", function () {
    //         var value = $(this).val().toLowerCase();
    //         $("#myTable tr").filter(function () {
    //             $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    //         });
    //     });
    // });
</script>
</body>
</html>

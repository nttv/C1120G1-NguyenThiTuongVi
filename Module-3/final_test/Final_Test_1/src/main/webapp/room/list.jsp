<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 24-Mar-21
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
<%--<link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">--%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Phòng trọ chuo thuê</title>
</head>
<body>
<div class="container text-center">
    <h1>Danh sách phòng trọ</h1>
    <button type="button" class="btn btn-primary"><a href="#searchModal" class="search"
                                                     data-toggle="modal">Search for users</a></button>
    <button type="button" class="btn btn-success"><a href="user?action=create">Add new user</a></button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã phòng trọ</th>
            <th>Tên người thuê trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["roomList"]}' var="room">
            <tr>
                <td class="align-middle"><a href="room?action=view&id=${user.id}">${user.id}</a></td>
                <td class="align-middle"><a href="user?action=view&id=${user.id}">${user.name}</a></td>
                <td class="align-middle">${user.email}</td>
                <td class="align-middle">${user.country}</td>
                <td>
                    <button type="button" class="btn btn-warning"><a href="user?action=edit&id=${user.id}">Edit</a>
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger"><a href="user?action=delete&id=${user.id}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="../user" method="post">
                <div class="modal-header text-center">
                    <h5 class="modal-title w-100 font-weight-bold" id="searchModalLabel">Search for users</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Enter a country:</label>
                        <input type="text" class="form-control" name="country">
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
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>--%>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>--%>
<script src="../js/bootstrap.bundle.js"></script>
</body>
</html>

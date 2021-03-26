<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 24-Mar-21
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<%--<link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">--%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Phòng trọ chuo thuê</title>
</head>
<body>

<div class="container">
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th colspan="8">
                <h3>Danh sách phòng trọ</h3>
            </th>
        </tr>
        <tr>
            <td colspan="8">
                <form class="form float-left" method="get" action="room">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-search"></i></span>
                        </div>
                        <input type="hidden" name="action" value="search">
                        <input type="text" class="form-control" id="searchValue" name="key" placeholder="Search">
                    </div>
                </form>
                <button type="button" class="btn btn-success float-right" data-toggle="modal"
                        data-target="#createModal">Thêm mới
                </button>
            </td>
        </tr>
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
        <c:forEach items='${roomList}' var="room">
            <tr>
                <td class="align-middle">${number=number+1}</td>
                <td class="align-middle">PT-${room.roomId}</td>
                <td class="align-middle">${room.tenantName}</td>
                <td class="align-middle">${room.phone}</td>
                <td class="align-middle">${room.startDate}</td>
                <td class="align-middle">${room.paymentType.paymentTypeName}</td>
                <td class="align-middle">${room.note}</td>
                <td>
                    <input type="checkbox" name="index" value="${number}">
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="8" class="text-right">
                <a href="room?action=delete&id=${room.roomId}">
                    <button type="button" class="btn btn-danger px-4">Xóa</button>
                </a>
            </td>
        </tr>
        </tfoot>
    </table>
</div>

<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="createModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title w-100 font-weight-bold" id="createModalLabel">Thêm mới phòng trọ</h5>
            </div>
            <div class="modal-body">
                <form class="form" action="room" method="post">--%>
                    <table class="table">
                        <tr class="form-group">
                            <th class="align-middle"><label for="id">Mã <span
                                    class="text-danger font-weight-bold">*</span></label>
                            </th>
                            <td>
                                <input class="form-control" type="text" name="id" id="id" required>
                                <p>
                                    <c:if test='${not empty message_customerId}'>
                                        <span class="text-danger">${message_customerId}</span>
                                    </c:if>
                                </p>
                            </td>
                        </tr>
                        <tr class="form-group">
                            <th class="align-middle"><label for="name">Tên người thuê<span
                                    class="text-danger font-weight-bold">*</span></label></th>
                            <td><input class="form-control" type="text" name="name" id="name" required></td>
                        </tr>
                        <tr class="form-group">
                            <th class="align-middle"><label for="type">Customer Type<span
                                    class="text-danger font-weight-bold">*</span></label></th>
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
                            <th class="align-middle"><label for="birthday">Customer Birthday<span
                                    class="text-danger font-weight-bold">*</span></label></th>
                            <td><input class="form-control" type="date" name="birthday" id="birthday" required></td>
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
                                <a href="room">
                                    <button type="button" class="btn btn-info px-4" data-dismiss="modal">Close</button>
                                </a>
                                <button type="submit" class="btn btn-success px-4" name="action" value="create">Create
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="room" method="post">
                <div class="modal-header text-center">
                    <h5 class="modal-title w-100 font-weight-bold" id="searchModalLabel">Tìm phòng trọ</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="key">Nhập từ khóa:</label>
                        <input type="text" class="form-control" name="key" id="key">
                        <input type="hidden" name="action" value="search">
                    </div>
                </div>
                <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="bootstrap413/js/bootstrap.bundle.js"></script>
<%--<script src="datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="datatables/js/dataTables.bootstrap4.min.js"></script>--%>

</body>
</html>

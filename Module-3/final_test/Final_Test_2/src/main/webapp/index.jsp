<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 25-Mar-21
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sàn TMĐT Codegym</title>
</head>
<body onload="reshowModal('${messageName}','${messagePrice}','${messageStock}')">

<div class="container">
    <h1>Danh sách sản phẩm</h1>
    <button type="button" class="btn btn-success my-2" data-toggle="modal" data-target="#createModal">Thêm mới</button>
    <br>
    <div class="row align-middle my-2 ml-0">
        <form action="product" method="get">
            <input type="hidden" name="action" value="view-top">
            <label for="top-list">Danh sách top: </label>
            <select name="top" id="top-list">
                <option value="3" <c:if test="${top == 3}">selected</c:if>>3</option>
                <option value="5" <c:if test="${top == 5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${top == 10}">selected</c:if>>10</option>
            </select>
            <span>Sản phẩm được đặt hàng nhiều nhất</span>
            <button type="submit" class="btn btn-primary">Xem</button>
        </form>
    </div>
    <div class="row align-middle my-2 ml-0">
        <form action="product" method="get">
            <input type="hidden" name="action" value="view-in-range">
            <label for="startDate">Danh sách sản phẩm được đặt từ: </label>
            <input type="date" name="startDate" id="startDate" value="${startDate}">
            <span><label for="endDate"> đến: </label>
            <input type="date" name="endDate" id="endDate" value="${endDate}"></span>
            <span><button type="submit" class="btn btn-primary mb-3">Xem</button></span>
        </form>
    </div>

    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Stock</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${products}' var="product">
            <tr>
                <td class="align-middle">${number=number+1}</td>
                <td class="align-middle">${product.name}</td>
                <td class="align-middle">${product.price}</td>
                <td class="align-middle">${product.discount}</td>
                <td class="align-middle">${product.stock}</td>
            </tr>
        </c:forEach>
        </tbody>
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
                <h5 class="modal-title w-100 font-weight-bold text-center" id="createModalLabel">Thêm mới sản phẩm</h5>
            </div>
            <div class="modal-body">
                <form class="form" action="product" method="post">
                    <table class="table">
                        <tr class="form-group">
                            <th class="align-middle">
                                <label for="name">Name:
                                    <span class="text-danger font-weight-bold"> (*)</span>
                                </label>
                            </th>
                            <td>
                                <input class="form-control" type="text" name="name" id="name"
                                       value="${product.name}">
                                <p>
                                    <c:if test='${messageName!= null}'>
                                        <span style="color: red" class="message">${messageName}</span>
                                    </c:if>
                                </p>
                            </td>
                        </tr>
                        <tr class="form-group">
                            <th class="align-middle">
                                <label for="price">Price:<span
                                        class="text-danger font-weight-bold"> (*)</span>
                                </label>
                            </th>
                            <td>
                                <input class="form-control" type="text" name="price" id="price"
                                       value="${product.price}">
                                <p>
                                    <c:if test='${messagePrice!= null}'>
                                        <span style="color: red" class="message">${messagePrice}</span>
                                    </c:if>
                                </p>
                            </td>
                        </tr>
                        <tr class="form-group">
                            <th class="align-middle">
                                <label for="discount">Discount:
                                    <span class="text-danger font-weight-bold"> (*)</span>
                                </label>
                            </th>
                            <td>
                                <select name="discount" class="custom-select" id="discount">
                                    <option value="5" <c:if test="${product.discount == 5}">selected</c:if>>5 (%)
                                    </option>
                                    <option value="10" <c:if test="${product.discount == 10}">selected</c:if>>10 (%)
                                    </option>
                                    <option value="15" <c:if test="${product.discount == 15}">selected</c:if>>15 (%)
                                    </option>
                                    <option value="20" <c:if test="${product.discount == 20}">selected</c:if>>20 (%)
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr class="form-group">
                            <th class="align-middle">
                                <label for="stock">Stock:<span
                                        class="text-danger font-weight-bold"> (*)</span>
                                </label>
                            </th>
                            <td>
                                <input class="form-control" type="text" name="stock" id="stock"
                                       value="${product.stock}">
                                <p>
                                    <c:if test='${messageStock!= null}'>
                                        <span style="color: red" class="message">${messageStock}</span>
                                    </c:if>
                                </p>
                            </td>
                        </tr>
                    </table>
                    <button type="submit" class="btn btn-success px-4 float-right" name="action" value="create">Thêm
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="bootstrap413/js/bootstrap.bundle.js"></script>

<script type="text/javascript">
    function reshowModal(messageName, messagePrice, messageStock) {
        console.log(messageName);
        console.log(messagePrice);
        console.log(messageStock);
        if (messageName || messagePrice || messageStock) {
            $('#createModal').modal('show');
        }
    }
</script>

</body>
</html>

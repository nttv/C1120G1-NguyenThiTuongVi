<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 21-Mar-21
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon"/>
    <title>Furama Resort Danang - A Culinary Beach Resort In Vietnam</title>
</head>
<body>
<header class="header">
    <div class="header-content">
        <div class="container">
            <div class="row py-3">
                <div class="col-2">
                    <a href="" class="header-logo"><img src="img/logo.png" alt="logo" class="img-fluid"></a>
                </div>
                <div class="col-5">
                    <div class="header-contact d-flex">
                        <div class="header-contact-icon pr-3 pt-3 mt-1"><i class="fas fa-map-marker-alt"></i>
                        </div>
                        <div class="header-contact-txt">
                            <p class="mb-1 pt-3">103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District,
                                Danang City, Vietnam</p>
                            <p class="mb-1">7,0 km from Danang Airport</p>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <div class="header-contact d-flex">
                        <div class="header-contact-icon pr-3 pt-3 mt-1"><i class="fas fa-phone fa-flip-horizontal"></i>
                        </div>
                        <div class="header-contact-txt">
                            <p class="mb-1 pt-3">84-236-3847 333/888</p>
                        </div>
                    </div>
                    <div class="header-contact d-flex">
                        <div class="header-contact-icon pr-3 mt-1"><i class="fas fa-envelope"></i>
                        </div>
                        <div class="header-contact-txt">
                            <a href="mailto:reservation@furamavietnam.com">
                                reservation@furamavietnam.com </a>
                        </div>
                    </div>
                </div>
                <div class="col-2 text-right">
                    <button type="button" class="btn bg-transparent border-0 shadow-none p-0 pt-3">
                        <i class="far fa-user-circle fa-2x"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</header>
<nav class="navbar navbar-expand-sm sticky-top text-uppercase font-weight-bold">
    <div class="container py-2">
        <a class="navbar-brand text-white" href=""><i class="fa fa-home"></i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="fa fa-bars"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link mx-2 text-white" href="employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2 text-white" href="customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2 text-white" href="service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2 text-white" href="contract">Contract</a>
                </li>
            </ul>
        </div>
        <form class="navbar-form navbar-right" method="post" action="">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search">
                <button class="btn" type="submit">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </form>
    </div>
</nav>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/1/2017
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Church Management Page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
    <!-- Datatables -->
    <link href="<c:url value="/resources/lib/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"/>"
          rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="page-title">
                <div class="title_left">
                    <h3>Users</h3>
                </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Quản lí nhà thờ</h2>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#createEvent">
                                    Thêm nhà thờ
                                </button>
                                <button type="button" class="btn btn-primary">Reject</button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên nhà thờ</th>
                                    <th>Kinh độ</th>
                                    <th>Vĩ độ</th>
                                    <th>Điện thoại</th>
                                    <th>Địa chỉ</th>
                                    <th>Email</th>
                                    <th>Giờ mở cửa</th>
                                    <th>Giờ đóng cửa</th>
                                    <th>Thông tin mô tả</th>
                                    <th>Người quản lí</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${churchList}">
                                    <tr>
                                        <td>${item.churchId}</td>
                                        <td>${item.churchName}</td>
                                        <td>${item.longitude}</td>
                                        <td>${item.latitude}</td>
                                        <td>${item.tel}</td>
                                        <td>${item.address}</td>
                                        <td>${item.mail}</td>
                                        <td>${item.startTime}</td>
                                        <td>${item.endTime}</td>
                                        <td>${item.description}</td>
                                        <td>${item.accountId}</td>
                                        <td>
                                            <button type="button" id="${item.churchId}btn"><c:choose>

                                                <c:when test="${not empty item.userId}">
                                                    Đổi người quản lí
                                                </c:when>
                                                <c:when test="${empty item.userId}">
                                                    Tạo người quản lí
                                                </c:when>
                                            </c:choose></button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>
<!-- Datatables -->
<script src="<c:url value="/resources/lib/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/registration.js"/>"></script>


</body>
</html>

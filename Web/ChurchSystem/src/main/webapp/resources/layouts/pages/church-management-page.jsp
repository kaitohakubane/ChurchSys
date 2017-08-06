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
    <link href="<c:url value="/resources/lib/src/js/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/edit-event-page.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="page-title">
                <div class="title_left">
                    <h3><strong>Administration</strong></h3>
                </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Quản lí nhà thờ</h2>
                            <div class="pull-right">
                                <button type="button" class="btn btn-success btn-lg" id="addChurch">
                                    Thêm nhà thờ
                                </button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên nhà thờ</th>
                                    <th>Điện thoại</th>
                                    <th>Địa chỉ</th>
                                    <th>Email</th>
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

                                        <td>${item.tel}</td>
                                        <td>${item.address}</td>
                                        <td>${item.mail}</td>
                                        <td>${item.description}</td>
                                        <td>${item.accountId}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${not empty item.userId}">
                                                    <button type="button"
                                                            class="btn btn-warning assign-manager"
                                                            data-id="${item.churchId}" data-toggle="modal"
                                                            data-target="#assignManagerPopup">Đổi người quản lí
                                                    </button>
                                                </c:when>
                                                <c:when test="${empty item.userId}">
                                                    <button type="button"
                                                            class="btn btn-success assign-manager"
                                                            data-id="${item.churchId}" data-toggle="modal"
                                                            data-target="#assignManagerPopup">Tạo người quản lí
                                                    </button>
                                                </c:when>
                                            </c:choose>
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

        <!-- popup -->
        <div id="assignManagerPopup" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
            <div class="modal-dialog">
                <!-- Modal content -->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Người quản lí</h4>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_content form-horizontal form-label-left">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên cha xứ:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" id="userName" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên đăng nhập:<span
                                                class="required">*</span></label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" required="required"
                                                   class="form-control col-md-7 col-xs-12"
                                                   id="accountId">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span
                                                class="required">*</span></label>
                                        <div class="col-md-9 col-sm-6 col-xs-12">
                                            <input required="required" class="form-control col-md-7 col-xs-12"
                                                   id="email"
                                                   type="text">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">SĐT:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" id="phone" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Chứng chỉ:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" id="cert" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                        <button type="button" class="btn btn-primary" id="btnOk">Xác nhận</button>
                    </div>
                </div>
                <!-- /Modal content -->
            </div>
        </div>
        <!-- /popup -->
        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>
<!-- Datatables -->
<script src="<c:url value="/resources/lib/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/js/church-management.js"/>"></script>


</body>
</html>

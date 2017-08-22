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
    <link href="<c:url value="/resources/lib/sematicDist/semantic.min.css"/>" rel="stylesheet">

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
                            <h2>Quản lí thành viên</h2>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#userPopup">
                                    Thêm thành viên
                                </button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên đăng nhập</th>
                                    <th>Tên linh mục</th>
                                    <th>SĐT</th>
                                    <th>Chứng chỉ</th>
                                    <th>Email</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${priestList}">
                                    <tr>
                                        <td>${item.userId}</td>
                                        <td>${item.accountId}</td>
                                        <td>${item.userName}</td>
                                        <td>${item.tel}</td>
                                        <td>${item.certificate}</td>
                                        <td>${item.email}</td>
                                        <td>
                                            <button type="button" id="btnEdit${item.roomId}"
                                                    data-id="${item.roomId}"
                                                    class="btn btn-warning event-approve">Sửa
                                            </button>
                                            <button type="button" id="btnRemove${item.roomId}"
                                                    data-id="${item.roomId}"
                                                    class="btn btn-danger event-reject">Xóa
                                            </button>
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

<!-- popup -->
<div id="userPopup" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Thêm linh mục</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content form-horizontal form-label-left">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên linh mục:</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" id="userName" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên đăng nhập:<span
                                        class="required">*</span></label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" required="required" class="form-control col-md-7 col-xs-12"
                                           id="accountId">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span
                                        class="required">*</span></label>
                                <div class="col-md-9 col-sm-6 col-xs-12">
                                    <input required="required" class="form-control col-md-7 col-xs-12" id="email"
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

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Chịu trách nhiệm:</label>
                                <div class="col-md-9 col-sm-3 col-xs-12">
                                    <select class="form-control" id="category">
                                        <c:forEach items="${categoryList}" var="item">
                                            <option value="${item.categoryId}">${item.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-9 col-sm-3 col-xs-12 col-md-offset-3">
                                    <select multiple="" class="ui fluid dropdown" id="subject">
                                        <c:forEach items="${subjectList}" var="item">
                                            <option class="subClass" id="${item.subId}" value="${item.subName}"
                                                    data-category="${item.categoryId}">${item.subName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="btnOk">OK</button>
            </div>
        </div>
        <!-- /Modal content -->
    </div>
</div>
<!-- /popup -->

<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/lib/sematicDist/semantic.min.js"/>"></script>

<!-- Datatables -->
<script src="<c:url value="/resources/lib/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/js/priest.js"/>"></script>


</body>
</html>

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
                            <h2>Quản lí phòng</h2>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#roomPopup">
                                    Thêm phòng
                                </button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên phòng</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${roomList}">
                                    <tr>
                                        <td>${item.roomId}</td>
                                        <td>${item.roomName}</td>
                                        <td>${item.roomStatus}</td>
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
<div id="roomPopup" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Thêm phòng</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content form-horizontal form-label-left">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên phòng:</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" class="form-control col-md-7 col-xs-12" id="roomName">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Có thể tổ chức:</label>
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
<script src="<c:url value="/resources/js/room.js"/>"></script>


</body>
</html>

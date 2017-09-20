<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 9/5/2017
  Time: 9:39 PM
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
    <title>Lesson Management Page</title>
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
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Quản lí bài học</h2>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#lessonPopup">
                                    Thêm bài học
                                </button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <%--<th>ID</th>--%>
                                    <th>Tên bài học</th>
                                    <th>Mô tả</th>
                                    <th>Môn</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${lessonlist}">
                                    <tr>
                                        <td>${item.title}</td>
                                        <td>${item.description}</td>
                                        <td>${item.subName}</td>

                                        <td>
                                            <button type="button" id="btnEdit${item.lessonId}"
                                                    data-id="${item.lessonId}"
                                                    class="btn btn-warning event-approve">Sửa
                                            </button>
                                            <button type="button" id="btnRemove${item.lessonId}"
                                                    data-id="${item.lessonId}"
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

<c:import url="/resources/layouts/common/footer.jsp"/>

        <!-- popup -->
        <div id="lessonPopup" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
            <div class="modal-dialog">
                <!-- Modal content -->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm bài học</h4>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_content form-horizontal form-label-left">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên bài học:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" class="form-control col-md-7 col-xs-12" id="title">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Mô tả:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <textarea class="form-control" rows="3" id="description"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Môn:</label>
                                        <div class="col-md-6 ">
                                        <div class="input-group has-success">
                                            <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                            <select class="form-control" id="category">
                                                <c:forEach items="${categoryList}" var="item">
                                                    <option value="${item.categoryId}">${item.categoryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-6 col-md-offset-3">
                                        <div class="input-group has-success">
                                            <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                            <select class="form-control" id="eventType">
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
                    </div>
                    <div class="clearfix"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                        <button type="button" class="btn btn-primary" id="btnOk">Ok</button>
                    </div>
                </div>
                <!-- /Modal content -->
            </div>
        </div>
        <!-- /popup -->

<!-- Datatables -->
<script src="<c:url value="/resources/lib/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/js/lesson.js"/>"></script>
</body>
</html>

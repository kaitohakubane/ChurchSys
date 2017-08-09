<%--
  Created by IntelliJ IDEA.
  User: Mr Kiet
  Date: 08/04/17
  Time: 11:10 PM
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
    <title>Registration Management Page</title>
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

            <div class="">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content">

                            <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                    <li role="presentation" class="active"><a href="#tab_content1" id="home-tab"
                                                                              role="tab" data-toggle="tab"
                                                                              aria-expanded="true">Đăng kí sự kiện</a>
                                    </li>
                                    <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab"
                                                                        data-toggle="tab" aria-expanded="false">Đăng kí
                                        lớp</a>
                                    </li>
                                </ul>
                                <div id="myTabContent" class="tab-content">
                                    <div role="tabpanel" class="tab-pane fade active in" id="tab_content1"
                                         aria-labelledby="home-tab">
                                        <table id="event_datatable" class="table table-striped table-bordered">
                                            <thead>
                                            <tr>
                                                <th>Tên sự kiện</th>
                                                <th>Loại sự kiện</th>
                                                <th>Nội dung</th>
                                                <th>Ngày đăng ký</th>
                                                <th>Thời gian diễn ra</th>
                                                <th>Tài khoản đăng ký</th>
                                                <th>Thông tin liên hệ</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${registrationEventDisplayList}">
                                                <tr>
                                                    <td>${item.eventName}</td>
                                                    <td>${item.subName}</td>
                                                    <td>${item.message}</td>
                                                    <td>${item.getDate()}</td>
                                                    <td>${item.getTime()}</td>
                                                    <td>${item.accountId}</td>
                                                    <td>${item.getContact()}</td>
                                                    <td>
                                                        <button type="button" id="btnApprove${item.regisId}"
                                                                data-id="${item.regisId}"
                                                                class="btn btn-success event-approve">Xác nhận
                                                        </button>
                                                        <button type="button" id="btnReject${item.regisId}"
                                                                data-id="${item.regisId}"
                                                                class="btn btn-danger event-reject">Từ chối
                                                        </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div role="tabpanel" class="tab-pane fade" id="tab_content2"
                                         aria-labelledby="profile-tab">
                                        <table id="class_datatable" class="table table-striped table-bordered">
                                            <thead>
                                            <tr>
                                                <th>Tên lớp</th>
                                                <th>Môn</th>
                                                <th>Ngày đăng ký</th>
                                                <th>Tài khoản đăng ký</th>
                                                <th>Thông tin liên hệ</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${registrationClassDisplayList}">
                                                <tr>
                                                    <td>${item.eventName}</td>
                                                    <td>${item.subName}</td>
                                                    <td>${item.getDate()}</td>
                                                    <td>${item.accountId}</td>
                                                    <td>${item.getContact()}</td>
                                                    <td>
                                                        <button type="button" id="btnApprove${item.regisId}"
                                                                data-id="${item.regisId}"
                                                                class="btn btn-success class-approve">Xác nhận
                                                        </button>
                                                        <button type="button" id="btnReject${item.regisId}"
                                                                data-id="${item.regisId}"
                                                                class="btn btn-danger class-reject">Từ chối
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
                </div>
                <!-- /page content -->
            </div>
        </div>
        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>
<!-- Datatables -->
<script src="<c:url value="/resources/lib/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/js/registration.js"/>"></script>



</body>
</html>

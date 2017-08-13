
<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/7/2017
  Time: 10:36 PM
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
    <title>Information Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>
    <!-- CSS -->
</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<%--<c:import url="/resources/layouts/user-common/vertical-navbar.jsp"/>--%>
<!-- church-info -->
<div class="container">
    <div class="row">
        <c:import url="/resources/layouts/user-common/church-info.jsp"/>
        <c:import url="/resources/layouts/user-common/navbar-private.jsp"/>
    </div>
</div>
<!-- end church info -->
<!-- page content -->
<div class="page-content">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#home">Sắp diễn ra</a></li>
                    <li><a data-toggle="tab" href="#menu1">Đang diễn ra</a></li>
                    <li style="margin-left: 780px;">
                        <button class="btn btn-success" data-toggle="modal" data-target="#add-new-class">Đăng ký lớp
                            mới
                        </button>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="home" class="tab-pane fade in active">
                        <div class="col-md-12">
                            <div class="row" style="margin-top: 10px;">
                                <div class="nav-class">
                                    <ul class="ul-class">
                                        <li><a href="#">Tất cả</a></li>
                                        <li><a href="#">Dự tòng</a></li>
                                        <li><a href="#">Hôn nhân</a></li>
                                        <li><a href="#">Dự ấu</a></li>
                                        <li><a href="#">Ấu nhi</a></li>
                                        <li><a href="#">Thiếu nhi</a></li>
                                        <li><a href="#">Nghĩa sĩ</a></li>
                                        <li><a href="#">Dự trưởng</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach var="item" items="${onPlanClassList}">
                                <div class="col-md-4">
                                    <div class="panel panel-success">
                                        <div class="panel-heading">
                                            <h4 class="text-center">${item.eventName}</h4>
                                        </div>
                                        <div class="panel-body" style="padding: 15px 0">
                                            <div class="form-horizontal">
                                                <label class="control-label col-md-4 col-sm-4 col-xs-12">Người
                                                    dạy</label>
                                            </div>
                                            <div class="col-md-8 form-group has-success">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" disabled="disabled"
                                                           value="${item.conductorName}"><br/>
                                                    <span class="input-group-addon"><i
                                                            class="fa fa-user fa-fw"></i></span>
                                                </div>
                                            </div>
                                            <div class="form-horizontal">
                                                <label class="control-label col-md-4 col-sm-4 col-xs-12">Phòng</label>
                                            </div>
                                            <div class="col-md-8 form-group has-success">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" disabled="disabled"
                                                           value="${item.roomName}"><br/>
                                                    <span class="input-group-addon"><i
                                                            class="fa fa-home fa-fw"></i></span>
                                                </div>
                                            </div>
                                            <div class="form-horizontal">
                                                <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                                            </div>
                                            <div class="col-md-8 form-group has-success">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" disabled="disabled"
                                                           value="${item.subName}"><br/>
                                                    <span class="input-group-addon"><i
                                                            class="fa fa-book fa-fw"></i></span>
                                                </div>
                                            </div>
                                            <div class="form-horizontal">
                                                <label class="control-label col-md-4 col-sm-4 col-xs-12">Khai
                                                    giảng</label>
                                            </div>
                                            <div class="col-md-8 form-group has-success">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" disabled="disabled"
                                                           value="${item.startDate}"><br/>
                                                    <span class="input-group-addon"><i
                                                            class="fa fa-calendar-check-o fa-fw"></i></span>
                                                </div>
                                            </div>
                                            <div class="form-horizontal">
                                                <label class="control-label col-md-4 col-sm-4 col-xs-12">Các
                                                    ngày</label>
                                            </div>
                                            <div class="col-md-8 form-group has-success">
                                                <div class="input-group">
                                                    <input type="text" class="form-control dayOfWeek"
                                                           value="${item.typeName}"
                                                           disabled="disabled"><br/>
                                                    <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                                                </div>
                                            </div>
                                            <div class="form-horizontal">
                                                <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời
                                                    gian</label>
                                            </div>
                                            <div class="col-md-8 form-group has-success">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" disabled="disabled"
                                                           value="${item.startTime} - ${item.endTime}"> <br/>
                                                    <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                                    <c:if test="${item.userStatus == 1}">
                                                        <button type="button" class="btn btn-success class-registration"
                                                                data-id="${item.eventId}" disabled>Đang chờ!
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${item.userStatus == 0}">
                                                        <button type="button" class="btn btn-success class-registration"
                                                                data-id="${item.eventId}">Đăng ký
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${item.userStatus ==2}">
                                                        <button type="button" class="btn btn-success class-registration"
                                                                data-id="${item.eventId}" disabled>Đã đăng ký!
                                                        </button>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div id="menu1" class="tab-pane fade">
                        <div class="row">
                            <div class="dangdienra" style="margin-top: 10px">
                                <div class="col-md-12">
                                    <div class="nav-class">
                                        <ul class="ul-class">
                                            <li><a href="#">Tất cả</a></li>
                                            <li><a href="#">Dự tòng</a></li>
                                            <li><a href="#">Hôn nhân</a></li>
                                            <li><a href="#">Dự ấu</a></li>
                                            <li><a href="#">Ấu nhi</a></li>
                                            <li><a href="#">Thiếu nhi</a></li>
                                            <li><a href="#">Nghĩa sĩ</a></li>
                                            <li><a href="#">Dự trưởng</a></li>
                                        </ul>
                                    </div>
                                    <div class="row">
                                        <c:forEach var="item" items="${onGoingClassList}">
                                            <div class="col-md-4">
                                                <div class="panel panel-success">
                                                    <div class="panel-heading">
                                                        <h4 class="text-center">${item.eventName}</h4>
                                                    </div>
                                                    <div class="panel-body" style="padding: 15px 0">
                                                        <div class="form-horizontal">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Người
                                                                dạy</label>
                                                        </div>
                                                        <div class="col-md-8 form-group has-success">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control"
                                                                       disabled="disabled"
                                                                       value="${item.conductorName}"><br/>
                                                                <span class="input-group-addon"><i
                                                                        class="fa fa-user fa-fw"></i></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-horizontal">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Phòng</label>
                                                        </div>
                                                        <div class="col-md-8 form-group has-success">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control"
                                                                       disabled="disabled"
                                                                       value="${item.roomName}"><br/>
                                                                <span class="input-group-addon"><i
                                                                        class="fa fa-home fa-fw"></i></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-horizontal">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                                                        </div>
                                                        <div class="col-md-8 form-group has-success">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control"
                                                                       disabled="disabled" value="${item.subName}"><br/>
                                                                <span class="input-group-addon"><i
                                                                        class="fa fa-book fa-fw"></i></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-horizontal">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Khai
                                                                giảng</label>
                                                        </div>
                                                        <div class="col-md-8 form-group has-success">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control"
                                                                       disabled="disabled"
                                                                       value="${item.startDate}"><br/>
                                                                <span class="input-group-addon"><i
                                                                        class="fa fa-calendar-check-o fa-fw"></i></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-horizontal">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các
                                                                ngày</label>
                                                        </div>
                                                        <div class="col-md-8 form-group has-success">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control dayOfWeek"
                                                                       value="${item.typeName}"
                                                                       disabled="disabled"><br/>
                                                                <span class="input-group-addon"><i
                                                                        class="fa fa-calendar fa-fw"></i></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-horizontal">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời
                                                                gian</label>
                                                        </div>
                                                        <div class="col-md-8 form-group has-success">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control"
                                                                       disabled="disabled"
                                                                       value="${item.startTime} - ${item.endTime}">
                                                                <br/>
                                                                <span class="input-group-addon"><i
                                                                        class="fa fa-clock-o fa-fw"></i></span>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                                                <c:if test="${item.userStatus == 1}">
                                                                    <button type="button"
                                                                            class="btn btn-success class-registration"
                                                                            data-id="${item.eventId}" disabled>Đang chờ!
                                                                    </button>
                                                                </c:if>
                                                                <c:if test="${item.userStatus == 0}">
                                                                    <button type="button"
                                                                            class="btn btn-success class-registration"
                                                                            data-id="${item.eventId}">Đăng ký
                                                                    </button>
                                                                </c:if>
                                                                <c:if test="${item.userStatus ==2}">
                                                                    <button type="button"
                                                                            class="btn btn-success class-registration"
                                                                            data-id="${item.eventId}" disabled>Đã đăng
                                                                        ký!
                                                                    </button>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- end page content -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- popup -->
<div id="add-new-class" class="modal fade" role="dialog">
    <div class="modal-dialog" style="width: 300px;">

        <div class="row">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 style="text-align: center;">Đăng ký lớp mới</h3>
                    <div class="clearfix"></div>
                </div>
                <div class="panel-body">

                    <div class="col-md-12 form-group left">
                        <div class="input-group has-success">
                            <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            <select class="form-control" id="category">
                                <c:forEach items="${categoryList}" var="item">
                                    <option value="${item.categoryId}">${item.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-12 form-group right">
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
                    <div class="form-group">
                        <!-- <label class="control-label col-md-2 col-sm-2 col-xs-12">Mô tả</label> -->
                        <div class="col-md-12 col-sm-10 col-xs-12">
                            <textarea class="form-control" id="messageTxt" rows="3" placeholder="Mô tả yêu cầu..."></textarea>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <br>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                            <button type="button" id="btnRegister" class="btn btn-success">Đăng ký</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /popup -->
<c:import url="/resources/layouts/user-common/user-footer.jsp"/>
<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script>
    var churchId =${param.churchId}</script>
<script src="<c:url value="/resources/js/church.js"/>"></script>
<%--<script src="<c:url value="/resources/js/common.js"/>"></script>--%>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/js/class-registration.js"/>"></script>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 10:23 PM
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

    <link href="<c:url value="/resources/lib/src/js/w2ui-1.5.rc1.min.css"/>" rel="stylesheet">
    <!-- FullCalendar -->
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.css"/>" rel="stylesheet">

    <!-- CSS -->
    <link href="<c:url value="/resources/css/church.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/event-page.css"/>" rel="stylesheet">
</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<%--<c:import url="/resources/layouts/user-common/vertical-navbar.jsp"/>--%>
<!-- church-info -->
<div class="container">
    <div class="row">
        <c:import url="/resources/layouts/user-common/church-info.jsp"/>
        <c:import url="/resources/layouts/user-common/navbar-private.jsp"/>
        <%--<div class="small-nav col-md-12">--%>
            <%--<div class="row">--%>
                <%--<div class="col-md-4">--%>
                    <%--<a href="${pageContext.request.contextPath}/church?churchId=${param.churchId}" class="col-md-12 btn btn-default">Tin--%>
                        <%--tức</a>--%>
                <%--</div>--%>
                <%--<div class="col-md-4">--%>
                    <%--<a href="${pageContext.request.contextPath}/church/schedule?churchId=${param.churchId}" class="col-md-12 btn btn-default active">Sự kiện</a>--%>
                <%--</div>--%>
                <%--<div class="col-md-4">--%>
                    <%--<a href="${pageContext.request.contextPath}/church/class?churchId=${param.churchId}" class="col-md-12 btn btn-default">Đăng ký lớp học</a>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="col-md-12">--%>
            <%--<div class="border-top"></div>--%>
        <%--</div>--%>
    </div>
</div>
<!-- end church info -->
<!-- page content -->
<div class="page-content">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id='calendar'></div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->
<div class="" style="width: 350px;" id="eventCreator">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h4>Đăng kí sự kiện</h4>
            <div class="clearfix"></div>
        </div>
        <div class="panel-body">
            <div class="form-horizontal form-label-left">
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Sự kiện</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <select id="subjectId" class="form-control">
                            <option>Choose option</option>
                            <option value="29">Đám ma</option>
                            <option value="28">Đám cưới</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Bắt đầu lúc</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <input type="eu-time" id="startTime" value="18:00" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Dự kiến khoảng</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <input type="text" id="estTime" class="form-control" placeholder="Số giờ">
                    </div>
                </div>
                <div class="clearfix"></div>
                <hr>
                <div class="form-group">
                    <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3">
                        <button type="button" class="btn btn-default">Cancel</button>
                        <button type="button" id="eventRegisteredBtn" class="btn btn-primary">Create</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


<div class="row eventDetailPopup" id="eventDetailPopup">
    <div class="" style="width: 300px;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4>Event Detail</h4>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body">
                <div class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" disabled="readonly" id="eventPopupTitle" class="form-control"
                                   placeholder="Event title">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Slot:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" id="eventPopupTime" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Subject:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" id="eventPopupSubject" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Assigned:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" id="eventPopupConductor" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Room:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" id="eventPopupRoom" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="clearfix"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-8 col-xs-12 col-md-offset-9">
                            <button id="eventDetailBtn" type="button" class="btn btn-default">OK</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<script src="<c:url value="/resources/lib/src/js/w2ui-1.5.rc1.min.js"/>"></script>
<!-- FullCalendar -->
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>
<script>
    var churchId =${param.churchId}
        $('input[type=eu-time]').w2field('time', { format: 'h24', start: '4:30 am', end: '9:00 pm' });
</script>
<script src="<c:url value="/resources/js/church.js"/>"></script>
<script src="<c:url value="/resources/js/church-event.js"/>"></script>
</body>
</html>

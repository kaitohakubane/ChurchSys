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

    <link href="<c:url value="/resources/lib/gridDist/jquery.timepicker.css"/>" rel="stylesheet">
    <!-- FullCalendar -->
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.css"/>" rel="stylesheet">

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
            <h4 class="text-center">Đăng kí sự kiện</h4>
            <div class="clearfix"></div>
        </div>
        <div class="panel-body">
            <div class="form-horizontal form-label-left">
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Sự kiện</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <select id="subjectId" class="form-control">
                            <option value="28">Đám cưới</option>
                            <option value="29">Đám ma</option>
                            <option value="27">Rửa tội</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Bắt đầu lúc</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <input name="startTime" id="startTime" value="18:00" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Dự kiến</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <select id="estTime" class="form-control">
                            <option value="1">1 giờ</option>
                            <option value="2">2 giờ</option>
                            <option value="3">3 giờ</option>
                            <option value="4">4 giờ</option>
                            <option value="5">5 giờ</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Mô tả</label>
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <textarea class="form-control" id="messageTxt" rows="3"></textarea>
                    </div>
                </div>

                <div class="clearfix"></div>
                <div class="form-group">
                    <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                        <button type="button" class="col-md-5 btn btn-default" id="cancelBtn">Hủy</button>
                        <button type="button" id="eventRegisteredBtn" class="col-md-5 col-md-offset-2 btn btn-primary">Đăng kí</button>
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

<!-- popup -->
<div id="notifyPopup" class="modal fade" role="dialog">
    <div class="modal-dialog" style="width: 350px;">
        <div class="row">
            <div class="panel panel-success">
                <div class="panel-heading text-center">
                    <span style="font-size: 18px;" id="eventNameSpn">Tên Sự kiện</span>
                    <div class="clearfix"></div>
                </div>
                <div class="panel-body">
                    <div class="form-horizontal form-label-left">

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày</label>
                            <div class="col-md-8 col-sm-8 col-xs-12 has-success">
                                <input type="text" class="form-control" disabled="readonly" id="dateTxt">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Thời gian</label>
                            <div class="col-md-8 col-sm-8 col-xs-12 has-success">
                                <input type="text" class="form-control" disabled="readonly" id="timeTxt">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Mô tả</label>
                            <div class="col-md-8 col-sm-8 col-xs-12 has-success">
                                <textarea class="form-control" id="messageField" disabled="readonly" rows="3"></textarea>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <button type="button" data-dismiss="modal" class="col-md-2 col-md-offset-5  btn btn-primary">OK</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /popup -->

<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<script src="<c:url value="/resources/lib/gridDist/jquery.timepicker.js"/>"></script>
<!-- FullCalendar -->
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/lang/vi.js"/>"></script>
<script>
    var churchId =${param.churchId}
        $('#startTime').timepicker({'timeFormat': 'H:i',
            'minTime': '4:30',
            'maxTime': '19:00',});
</script>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/js/church.js"/>"></script>
<script src="<c:url value="/resources/js/church-event.js"/>"></script>
</body>
</html>

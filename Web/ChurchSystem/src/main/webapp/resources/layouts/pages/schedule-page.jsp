<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/6/2017
  Time: 11:26 PM
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
    <title>Calendar Page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>

    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">
    <!-- FullCalendar -->
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.print.css"/>" rel="stylesheet"
          media="print">
    <%--Switchery--%>
    <link href="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/schedule.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/lib/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-2">
                        <div id='external-events'>
                            <div id='external-events-listing'>
                                <h4>Lớp đang được đăng ký</h4>

                            </div>
                        </div>
                        <div class="color-description">
                            <h4>Color Description</h4>
                            <ul>
                                <li style="color: #01ff70">
                                    <i class="fa fa-square"></i>
                                    <span>Vừa tạo</span>
                                </li>
                                <li style="color: #3c8dbc">
                                    <i class="fa fa-square"></i>
                                    <span>Bình thường</span>
                                </li>
                                <li style="color: #dd4b39">
                                    <i class="fa fa-square"></i>
                                    <span>Có vấn đề</span>
                                </li>
                                <li style="color: #777">
                                    <i class="fa fa-square"></i>
                                    <span>Đã qua</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-10">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Calendar Events
                                </h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id='calendar'></div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<%--Event Register--%>
<div class="container">
    <div class="row block-center calendarPopup" id="calendarPopup">
        <div id="form-box">
            <%--<div action="#" method="#">--%>
            <div class="panel panel-success">
                <div class="panel-heading" id="panel-heading">
                    <h2 class="titre text-center">Event</h2>
                </div>
                <div class="panel-body">
                    <div class="form">
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                <input type="text" class="form-control" id="creatingEventName"
                                       placeholder="Please Input Name" required/><br/>
                            </div>
                        </div>
                        <div class="col-md-4 form-group">
                            <label class="control-label">Public</label>
                            <label class="">
                                <input type="checkbox" id="createEventPopupIsPublic" class="js-switch" checked/>
                            </label>
                        </div>
                        <div class="col-md-6 form-group left">
                            <div class="input-group has-success">
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                <select class="form-control" id="category">
                                    <c:forEach items="${categoryList}" var="item">
                                        <option value="${item.categoryId}">${item.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6 form-group right">
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

                        <div class="col-md-12 form-group has-success">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                                <select class="form-control" id="slotNum">
                                    <c:forEach items="${slotHourList}" var="item">
                                        <option id="${item.slotHourId}" value="${item.startTime} - ${item.endTime}">
                                                ${item.startTime} - ${item.endTime}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <button id="cancelEventbtn" class="btn btn-success col-sm-12">Cancel</button>
                        </div>
                        <div class="col-sm-6">
                            <button id="createEventbtn" class="btn btn-primary col-sm-12">Create</button>
                        </div>
                    </div>
                </div>
            </div>
            <%--</div>--%>
        </div>
    </div>
</div>

<div class="row eventDetailPopup" id="eventDetailPopup">
    <div class="" style="width: 400px;">
        <div class="x_panel">
            <div class="x_title">
                <h2>Event Detail</h2>
                <button type="button" class="btn btn-primary pull-right">Stream</button>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <div class="col-md-8">
                            <input type="text" id="eventPopupTitle" class="form-control" placeholder="Event title">
                        </div>
                        <div class="col-md-4 form-group pull-right">
                            <label class="control-label">Public</label>
                            <label class="">
                                <input type="checkbox" id="eventDetailIsPublic" class="js-switch" checked/>
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Slot:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" id="eventPopupTime" class="form-control" disabled="readonly" data-id = ${slotEntity.slotId}>
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
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3">
                            <button type="button" class="btn btn-default" id="btnRemove">Remove</button>
                            <button type="button" id="editSlotButton" class="btn btn-primary">Edit</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


<!-- popup -->
<div id="createClass" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create new class</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Class information</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br/>
                            <form class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Number of student:</label>
                                    <div class="col-md-8 col-sm-8 col-xs-12">
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Number of slot:</label>
                                    <div class="col-md-8 col-sm-8 col-xs-12">
                                        <div>
                                            <input type="number" id="numberOfSlot" class="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-4 col-sm-4 col-xs-12">Exam date:</label>
                                    <div class="col-md-8 col-sm-8 col-xs-12">
                                        <div>
                                            <input type="text" class="form-control" id="datepicker"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 form-group">
                                    <label class="control-label col-md-2 col-sm-2 col-xs-12">Schedule:</label>
                                    <label class="control-label">
                                        <input type="checkbox" id="2" class="flat day-checkbox"> Mon
                                    </label>
                                    <label>
                                        <input type="checkbox" id="3" class="flat day-checkbox"> Tue
                                    </label>
                                    <label>
                                        <input type="checkbox" id="4" class="flat day-checkbox"> Wed
                                    </label>
                                    <label>
                                        <input type="checkbox" id="5" class="flat day-checkbox"> Thus
                                    </label>
                                    <label>
                                        <input type="checkbox" id="6" class="flat day-checkbox"> Fri
                                    </label>
                                    <label>
                                        <input type="checkbox" id="7" class="flat day-checkbox"> Sat
                                    </label>
                                    <label>
                                        <input type="checkbox" id="8" class="flat day-checkbox"> Sun
                                    </label>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" id="createClassbtn" class="btn btn-primary">Create</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->


<%--====================================================--%>
<%--====================================================--%>


<c:import url="/resources/layouts/common/footer.jsp"/>
<!-- FullCalendar -->
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>

<!-- iCheck -->
<script src="<c:url value="/resources/lib/vendors/iCheck/icheck.min.js"/>"></script>

<!-- Switchery -->
<script src="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.js"/>"></script>

<script>
    //    Class List
    var classList = [];
    <c:forEach items="${registeredClass}" var="item">
    var arr = [];

    arr.push("<c:out value="${item.subId}" />");
    arr.push("<c:out value="${item.subName}" />");
    arr.push("<c:out value="${item.numOfRegistration}" />");

    classList.push(arr);
    </c:forEach>


</script>
<script src="<c:url value="/resources/js/schedule-calendar.js"/>"></script>
<script src="<c:url value="/resources/js/schedule-general.js"/>"></script>

</body>
</html>

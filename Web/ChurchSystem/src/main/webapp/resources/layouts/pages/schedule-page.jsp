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
    <!-- FullCalendar -->
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.print.css"/>" rel="stylesheet"
          media="print">
    <%--Switchery--%>
    <link href="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<link href="<c:url value="/resources/css/schedule.css"/>" rel="stylesheet">
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
                                <h4>Ongoing Class</h4>

                            </div>
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
            <form action="#" method="#">
                <div class="panel panel-success">
                    <div class="panel-heading" id="panel-heading">
                        <h2 class="titre text-center">Event</h2>
                    </div>
                    <div class="panel-body">
                        <form class="form" method="post">
                            <div class="col-md-8 form-group has-success">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                    <input type="text" class="form-control" id="creatingEventName"
                                           name="creatingEventName"
                                           placeholder="Please Input Name" required/><br/>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <label class="control-label">Public</label>
                                <label class="">
                                    <input type="checkbox" class="js-switch" checked/>
                                </label>
                            </div>
                            <div class="col-md-6 form-group left">
                                <div class="input-group has-success">
                                    <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                    <select class="form-control" id="category">
                                        <c:forEach items="${categoryList}" var="item">
                                            <option  value="${item.categoryId}">${item.categoryName}</option>
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
                                    <select class="form-control">
                                        <option>Slot</option>
                                        <option>1 (04:30 - 06:00)</option>
                                        <option>2 (06:00 - 07:30)</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <button class="btn btn-success col-sm-12">Auto event</button>
                            </div>
                            <div class="col-sm-6">
                                <button id="createEventbtn" class="btn btn-primary col-sm-12">Create</button>
                            </div>
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--Event Detail--%>
<div class="row eventDetailPopup" id="eventDetailPopup">
    <div class="" style="width: 300px;">
        <div class="x_panel">
            <div class="x_title">
                <h2>Event Detail</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" class="form-control" placeholder="Event title">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Slot:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12 col-md-offset-1">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Subject:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Assigned:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Room:</label>
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="clearfix"></div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3">
                            <button type="button" class="btn btn-default">Back</button>
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>
<!-- FullCalendar -->
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>

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
<script src="<c:url value="/resources/js/schedule.js"/>"></script>

</body>
</html>

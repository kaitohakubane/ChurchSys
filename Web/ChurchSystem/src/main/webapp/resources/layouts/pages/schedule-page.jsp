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
                                <div class='fc-event'>My Event 1</div>
                                <div class='fc-event'>My Event 2</div>
                                <div class='fc-event'>My Event 3</div>
                                <div class='fc-event'>My Event 4</div>
                                <div class='fc-event'>My Event 5</div>
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
                            <div class="form-group has-success">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                    <input type="email" class="form-control" id="email" name="email"
                                           placeholder="Please Input Name" required/><br/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group has-success">
                                    <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                    <select class="form-control">
                                        <option></option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                                    <input type="time" class="form-control" id="time" name="time" placeholder=""
                                           required/><br/>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <button type="submit" class="btn btn-success col-sm-12">Edit event</button>
                            </div>
                            <div class="col-sm-6">
                                <button type="submit" class="btn btn-primary col-sm-12">Create</button>
                            </div>
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<c:import url="/resources/layouts/common/footer.jsp"/>
<!-- FullCalendar -->
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>
<script src="<c:url value="/resources/js/schedule.js"/>"></script>
</body>
</html>

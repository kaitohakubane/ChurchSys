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
                <%--<div class="page-title">--%>
                    <%--<div class="title_left">--%>
                        <%--<h3>Calendar--%>
                            <%--<small>Click to add/edit events</small>--%>
                        <%--</h3>--%>
                    <%--</div>--%>

                    <%--<div class="title_right">--%>
                        <%--<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">--%>
                            <%--<div class="input-group">--%>
                                <%--<input type="text" class="form-control" placeholder="Search for...">--%>
                                <%--<span class="input-group-btn">--%>
                      <%--<button class="btn btn-default" type="button">Go!</button>--%>
                    <%--</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
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

        <!-- calendar modal -->
        <div id="CalenderModalNew" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">New Calendar Entry</h4>
                    </div>
                    <div class="modal-body">
                        <div id="testmodal" style="padding: 5px 20px;">
                            <form id="antoform" class="form-horizontal calender" role="form">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Title</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="title" name="title">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Description</label>
                                    <div class="col-sm-9">
                                        <textarea class="form-control" style="height:55px;" id="descr"
                                                  name="descr"></textarea>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default antoclose" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary antosubmit">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="CalenderModalEdit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel2">Edit Calendar Entry</h4>
                    </div>
                    <div class="modal-body">

                        <div id="testmodal2" style="padding: 5px 20px;">
                            <form id="antoform2" class="form-horizontal calender" role="form">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Title</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="title2" name="title2">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Description</label>
                                    <div class="col-sm-9">
                                        <textarea class="form-control" style="height:55px;" id="descr2"
                                                  name="descr"></textarea>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default antoclose2" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary antosubmit2">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="fc_create" data-toggle="modal" data-target="#CalenderModalNew"></div>
        <div id="fc_edit" data-toggle="modal" data-target="#CalenderModalEdit"></div>
        <!-- /calendar modal -->

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
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Please Input Name" required/><br/>
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
                                    <input type="time" class="form-control" id="time" name="time" placeholder="" required/><br/>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <button type="submit" class="btn btn-success col-sm-12" >Edit event</button>
                            </div>
                            <div class="col-sm-6">
                                <button type="submit" class="btn btn-primary col-sm-12" >Create</button>
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
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>
<script src="<c:url value="/resources/js/schedule.js"/>"></script>
</body>
</html>

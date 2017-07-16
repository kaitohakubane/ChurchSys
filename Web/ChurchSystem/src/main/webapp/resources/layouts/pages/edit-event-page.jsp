<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 8:55 PM
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
    <title>Edit Event</title>
    <c:import url="/resources/layouts/common/header.jsp"/>

    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/lib/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
    <!-- Switchery -->
    <link href="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Edit Event Page</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-6 col-xs-12 col-md-offset-3">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Event Detail</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <div class="form-horizontal form-label-left input_mask">

                                    <div class="col-md-6 form-group">
                                        <input id="txtTitle" type="text" class="form-control" data-id = "${slotEntity.slotId}"
                                               value="${slotEntity.eventName}" placeholder="Event title" readonly >
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" id="subject" value="${slotEntity.subName}"
                                               class="form-control has-feedback-left" disabled="readonly">
                                        <span class="fa fa-calendar form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6slotHour col-sm-6 col-xs-12 form-group has-feedback">
                                        <select id="startTime" class="form-control has-feedback-left">
                                            <c:forEach items="${slotHourList}" var="item">
                                                <option id="${item.slotHourId}" data-id="${item.startTime}">
                                                        ${item.startTime}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <span class="fa fa-clock-o form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6slotHour col-sm-6 col-xs-12 form-group has-feedback">
                                        <select id="endTime" class="form-control has-feedback-left">
                                            <c:forEach items="${slotHourList}" var="item">
                                                <option id="${item.slotHourId}" data-id="${item.endTime}">
                                                        ${item.endTime}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <span class="fa fa-clock-o form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Assigned:</label>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <select class="form-control" id="assigned">

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Room:</label>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <select class="form-control" id="room">
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Date:</label>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <input type="text"  class="form-control" id="slotDate">
                                    </div>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Public</label>
                                        <label class="control-label">
                                            <input type="checkbox" id="editEventIsChecked" class="js-switch"
                                                   checked/>
                                        </label>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                                            <button type="button" id="btnBack" class="btn btn-default btn-lg">Back
                                            </button>
                                            <button type="button" id="btnSave" class="btn btn-success btn-lg">Save
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<%--Confirm Modal--%>
<div class="modal fade confirm-modal" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true"
     data-keyboard="false" style="margin-top: 220px;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-body ">
                <label>Bạn muốn áp dụng cho:</label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info col-md-5" id="oneSlot" style="margin-left: 6px">Giờ này</button>
                <button type="button" class="btn btn-primary col-md-6" id="manySlot">Các giờ liên quan</button>
            </div>
        </div>
    </div>
</div>
<c:import url="/resources/layouts/common/footer.jsp"/>

<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<!-- iCheck -->
<script src="<c:url value="/resources/lib/vendors/iCheck/icheck.min.js"/>"></script>
<!-- Switchery -->
<script src="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.js"/>"></script>
<script>
    var startTime = "<c:out value="${slotEntity.startTime}" />"
    var endTime = "<c:out value="${slotEntity.endTime}" />"
    var slotDate = "<c:out value="${slotEntity.slotDate}"/>"
    var privacy= "<c:out value="${slotEntity.privacy}" />"
</script>
<script src="<c:url value="/resources/js/edit-event.js"/>"></script>


</body>
</html>

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
    <style>
        #editForm label.error {
            margin-left: 10px;
            width: auto;
            display: inline;
        }
    </style>

    <link href="<c:url value="/resources/lib/src/js/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/edit-event-page.css"/>" rel="stylesheet">

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
                        <h3>Chỉnh sửa thông tin sự kiện</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-6 col-xs-12 col-md-offset-3">
                        <form class="x_panel" id="editForm">
                            <div class="x_title">
                                <h2>Chi tiết sự kiện</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <div class="form-horizontal form-label-left input_mask">

                                    <div class="col-md-6 form-group">
                                        <input id="txtTitle" type="text" class="form-control"
                                               data-id="${slotEntity.slotId}"
                                               value="${slotEntity.eventName}" placeholder="Event title">
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" id="subject" data-id="${slotEntity.subId}"
                                               value="${slotEntity.subName}"
                                               class="form-control has-feedback-left" disabled="readonly">
                                        <span class="fa fa-calendar form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 slotHour col-sm-6 col-xs-12 form-group has-feedback">
                                        <%--<label for="startTime"></label>--%>
                                        <select id="startTime" class="form-control has-feedback-left" name="startTime">
                                            <c:forEach items="${slotHourList}" var="item">
                                                <option id="${item.slotHourId}" data-id="${item.startTime}">
                                                        ${item.startTime}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <span class="fa fa-clock-o form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 slotHour col-sm-6 col-xs-12 form-group has-feedback">
                                        <%--<label for="endTime"></label>--%>
                                        <select id="endTime" class="form-control has-feedback-left" name="endTime">
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
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Người phụ
                                            trách:</label>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <select class="form-control" id="assigned">

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Phòng:</label>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <select class="form-control" id="room">
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Ngày:</label>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <input type="text" class="form-control" id="slotDate" name="slotDate">
                                            <%--<label for="slotDate">Ngày không được trước ngày hiện tại</label>--%>
                                        </div>
                                    </div>

                                    <div class="col-md-6 form-group">
                                        <label class="control-label col-md-4 col-sm-2 col-xs-12">Công khai</label>
                                        <label class="control-label">
                                            <input type="checkbox" id="editEventIsChecked" class="js-switch" checked/>
                                        </label>
                                    </div>
                                    <div class="col-md-6 checkbox" style="display: none" id="divCheckbox">
                                        <label>
                                            <input type="checkbox" class="flat" id="manySlotCheck">Áp dụng tất cả các
                                            giờ liên quan
                                        </label>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                                            <button type="button" id="btnBack" class="btn btn-default btn-lg">Quay lại
                                            </button>
                                            <button type="button" id="btnSave" class="btn btn-success btn-lg"
                                                    value="Validate!">Lưu
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
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
                <label>Không tìm được phòng hoặc người chịu trách nhiệm cho tất cả các buổi. Bạn có muốn tiếp tục
                    ?</label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary col-md-5" id="btnContinous" style="margin-left: 6px">Tiếp
                    tục
                </button>
                <button type="button" class="btn btn-default col-md-6" data-dismiss="modal">Hủy</button>
            </div>
        </div>
    </div>
</div>
<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/validateDist/jquery.validate.js"/>"></script>
<script src="<c:url value="/resources/lib/validateDist/additional-methods.min.js"/>"></script>

<!-- iCheck -->
<script src="<c:url value="/resources/lib/vendors/iCheck/icheck.min.js"/>"></script>
<!-- Switchery -->
<script src="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.js"/>"></script>
<script>
    var startTime = "<c:out value="${slotEntity.startTime}" />"
    var endTime = "<c:out value="${slotEntity.endTime}" />"
    var slotDate = "<c:out value="${slotEntity.slotDate}"/>"
    var privacy = "<c:out value="${slotEntity.privacy}" />"

</script>
<script src="<c:url value="/resources/js/edit-event.js"/>"></script>


</body>
</html>

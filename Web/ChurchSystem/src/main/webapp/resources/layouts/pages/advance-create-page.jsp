<%--
  Created by IntelliJ IDEA.
  User: Mr Kiet
  Date: 8/9/2017
  Time: 11:18 PM
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
    <title>Advance Create Event</title>
    <c:import url="/resources/layouts/common/header.jsp"/>


    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/lib/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
    <!-- Switchery -->
    <link href="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Sự kiện nâng cao</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-6 col-xs-12 col-md-offset-3">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Chi tiết sự kiện</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <form class="form-horizontal form-label-left input_mask">

                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <input type="text" class="form-control" placeholder="Tên sự kiện">
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <select class="form-control has-feedback-left" id="category">
                                            <c:forEach items="${categoryList}" var="item">
                                                <option value="${item.categoryId}">${item.categoryName}</option>
                                            </c:forEach>
                                        </select>
                                        <span class="fa fa-calendar form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <select class="form-control has-feedback-left" id="eventType">
                                            <c:forEach items="${subjectList}" var="item">
                                                <option class="subClass" id="${item.subId}" value="${item.subName}"
                                                        data-category="${item.categoryId}">${item.subName}</option>
                                            </c:forEach>
                                        </select>
                                        <span class="fa fa-calendar-check-o form-control-feedback left"
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
                                    <div class="col-md-12 form-group">
                                        <label class="col-md-3">
                                            <input value="hideForm" type="radio" class="flat" checked name="repeat">
                                            Không lặp
                                        </label>
                                        <label class="col-md-3">
                                            <input value="showForm" type="radio" class="flat" name="repeat"> Lặp
                                        </label>
                                    </div>

                                    <!-- Hide Repeat Oncheck -->
                                    <div id="hiding-form">
                                        <div class="clearfix"></div>
                                        <div class="ln_solid"></div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Lặp:</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <select class="form-control" id="option-select">
                                                    <option value="">Chọn</option>
                                                    <option data-id="ngày" value="1">Hàng ngày</option>
                                                    <option data-id="tuần" value="2">Hàng tuần</option>
                                                    <option data-id="tháng" value="3">Hàng tháng</option>
                                                    <option data-id="năm" value="4">Hàng năm</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Mỗi:</label>
                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                <select class="form-control" id="kind">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                    <option value="7">7</option>
                                                    <option value="8">8</option>
                                                    <option value="9">9</option>
                                                    <option value="10">10</option>
                                                    <option value="11">11</option>
                                                    <option value="12">12</option>
                                                    <option value="13">13</option>
                                                    <option value="14">14</option>
                                                    <option value="15">15</option>
                                                    <option value="16">16</option>
                                                    <option value="17">17</option>
                                                    <option value="18">18</option>
                                                    <option value="19">19</option>
                                                    <option value="20">20</option>
                                                    <option value="21">21</option>
                                                    <option value="22">22</option>
                                                    <option value="23">23</option>
                                                    <option value="24">24</option>
                                                    <option value="25">25</option>
                                                    <option value="26">26</option>
                                                    <option value="27">27</option>
                                                    <option value="28">28</option>
                                                    <option value="29">29</option>
                                                    <option value="30">30</option>
                                                </select>
                                            </div>
                                            <label class="control-label" id="option-result"></label>
                                        </div>

                                        <div class="col-md-12 form-group" id="week-selected">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Vào:</label>
                                            <label class="control-label">
                                                <input type="checkbox" id="2" class="flat day-checkbox"> Hai
                                            </label>
                                            <label>
                                                <input type="checkbox" id="3" class="flat day-checkbox"> Ba
                                            </label>
                                            <label>
                                                <input type="checkbox" id="4" class="flat day-checkbox"> Tư
                                            </label>
                                            <label>
                                                <input type="checkbox" id="5" class="flat day-checkbox"> Năm
                                            </label>
                                            <label>
                                                <input type="checkbox" id="6" class="flat day-checkbox"> Sáu
                                            </label>
                                            <label>
                                                <input type="checkbox" id="7" class="flat day-checkbox"> Bảy
                                            </label>
                                            <label>
                                                <input type="checkbox" id="1" class="flat day-checkbox"> CN
                                            </label>
                                        </div>

                                        <div class="col-md-12 form-group" id="month-selected">
                                            <label class="control-label col-md-4 col-md-offset-2">
                                                <input type="radio" value="1" class="flat" checked name="month"> Ngày
                                                của tháng
                                            </label>
                                            <label class="control-label col-md-4">
                                                <input type="radio" class="flat" name="month" value="2"> Ngày của tuần
                                            </label>
                                        </div>
                                        <div class="clearfix"></div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Bắt đầu:</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <input type="text" class="form-control" id="advance-startDate" readonly>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Kết thúc
                                                sau:</label>

                                            <div class="col-md-4">
                                                <label class="control-label">
                                                    <input type="number" min="1" max="30"
                                                           id="numOfRepeat" value="1" style="text-align: center"> buổi
                                                </label>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="ln_solid"></div>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               style="text-align: left">Công khai</label>
                                        <label class="control-label" style="margin-left: -30px;margin-top: -7px">
                                            <input type="checkbox" id="createEventPopupIsPublic" class="js-switch"
                                                   checked/>
                                        </label>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                                            <button type="button" class="btn btn-default btn-lg" id="btnBack">Quay lại
                                            </button>
                                            <button type="button" class="btn btn-success btn-lg" id="btnSave">Lưu
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<%--Confirm Modal--%>
<div class="modal fade confirm-modal" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true"
     data-keyboard="false" style="margin-top: 220px;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-body " id="confirmInfor">
                <label>Không tìm được phòng hoặc người chịu trách nhiệm cho sự kiện (lớp) này. Bạn có muốn tiếp tục
                    ?</label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info col-md-5" id="cancel" data-dismiss="modal"
                        style="margin-left: 6px">Hủy
                </button>
                <button type="button" class="btn btn-primary col-md-6" id="process">Tiếp tục</button>
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

<script src="<c:url value="/resources/js/advance-create.js"/>"></script>

<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>

<script>
    var slotDate = "<c:out value="${slotDate}" />"
</script>

</body>
</html>

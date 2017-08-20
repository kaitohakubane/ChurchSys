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
                                    <%--<div class="col-md-6 form-group left">--%>
                                    <%--<div class="input-group has-success">--%>
                                    <%--<span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>--%>
                                    <%--<select class="form-control" id="category">--%>
                                    <%--<c:forEach items="${categoryList}" var="item">--%>
                                    <%--<option value="${item.categoryId}">${item.categoryName}</option>--%>
                                    <%--</c:forEach>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-md-6 form-group right">--%>
                                    <%--<div class="input-group has-success">--%>
                                    <%--<span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>--%>
                                    <%--<select class="form-control" id="eventType">--%>
                                    <%--<c:forEach items="${subjectList}" var="item">--%>
                                    <%--<option class="subClass" id="${item.subId}" value="${item.subName}"--%>
                                    <%--data-category="${item.categoryId}">${item.subName}</option>--%>
                                    <%--</c:forEach>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<div class="col-md-12 form-group has-success">--%>
                                    <%--<div class="input-group">--%>
                                    <%--<span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>--%>
                                    <%--<select class="form-control" id="slotNum">--%>
                                    <%--<c:forEach items="${slotHourList}" var="item">--%>
                                    <%--<option id="${item.slotHourId}" value="${item.startTime} - ${item.endTime}">--%>
                                    <%--${item.startTime} - ${item.endTime}--%>
                                    <%--</option>--%>
                                    <%--</c:forEach>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
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

                                    <%--<div class="form-group">--%>
                                    <%--<div class="col-md-6">--%>
                                    <%--<select class="form-control has-feedback-left" id="startTime">--%>
                                    <%--<c:forEach items="${slotHourList}" var="item">--%>
                                    <%--<option id="${item.slotHourId}"--%>
                                    <%--value="${item.startTime}">                                                            ${item.startTime}--%>
                                    <%--</option>--%>
                                    <%--</c:forEach>--%>
                                    <%--</select>--%>
                                    <%--<span class="fa fa-clock-o form-control-feedback left"--%>
                                    <%--aria-hidden="true"></span>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<div class="form-group">--%>
                                    <%--<div class="col-md-6">--%>
                                    <%--<select class="form-control has-feedback-left" id="endTime">--%>
                                    <%--<c:forEach items="${slotHourList}" var="item">--%>
                                    <%--<option id="${item.slotHourId}"                                                            value="${item.endTime}">--%>
                                    <%--${item.endTime}--%>
                                    <%--</option>--%>
                                    <%--</c:forEach>--%>
                                    <%--</select>--%>
                                    <%--<span class="fa fa-clock-o form-control-feedback left"--%>
                                    <%--aria-hidden="true"></span>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
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
                                                    <option value="ngày">Hàng ngày</option>
                                                    <option value="tuần">Hàng tuần</option>
                                                    <option value="tháng">Hàng tháng</option>
                                                    <option value="năm">Hàng năm</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Mỗi:</label>
                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                <select class="form-control">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                    <option>7</option>
                                                    <option>8</option>
                                                    <option>9</option>
                                                    <option>10</option>
                                                    <option>11</option>
                                                    <option>12</option>
                                                    <option>13</option>
                                                    <option>14</option>
                                                    <option>15</option>
                                                    <option>16</option>
                                                    <option>17</option>
                                                    <option>18</option>
                                                    <option>19</option>
                                                    <option>20</option>
                                                    <option>21</option>
                                                    <option>22</option>
                                                    <option>23</option>
                                                    <option>24</option>
                                                    <option>25</option>
                                                    <option>26</option>
                                                    <option>27</option>
                                                    <option>28</option>
                                                    <option>29</option>
                                                    <option>30</option>
                                                </select>
                                            </div>
                                            <label class="control-label" id="option-result"></label>
                                        </div>

                                        <div class="col-md-12 form-group" id="week-selected">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Vào:</label>
                                            <label class="control-label">
                                                <input type="checkbox" class="flat"> Hai
                                            </label>
                                            <label>
                                                <input type="checkbox" class="flat"> Ba
                                            </label>
                                            <label>
                                                <input type="checkbox" class="flat"> Tư
                                                <label>
                                                    <input type="checkbox" class="flat"> Năm
                                                </label>
                                                <label>
                                                    <input type="checkbox" class="flat"> Sáu
                                                </label>
                                                <label>
                                                    <input type="checkbox" class="flat"> Bảy
                                                </label>
                                                <label>
                                                    <input type="checkbox" class="flat"> CN
                                                </label>
                                            </label>
                                        </div>

                                        <div class="col-md-12 form-group" id="month-selected">
                                            <label class="control-label col-md-4 col-md-offset-2">
                                                <input type="radio" class="flat" checked name="month"> Ngày của tháng
                                            </label>
                                            <label class="control-label col-md-4">
                                                <input type="radio" class="flat" name="month"> Ngày của tuần
                                            </label>
                                        </div>
                                        <div class="clearfix"></div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Bắt đầu:</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <input type="text" class="form-control" id="advance-starDay">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Kết thúc
                                                sau:</label>
                                            <%--<label class="control-label col-md-2">--%>
                                            <%--<input type="radio" class="flat" checked name="end"> Never--%>
                                            <%--</label>--%>
                                            <div class="col-md-4">
                                                <%--<input type="radio" class="flat" name="end"> After--%>
                                                <label class="control-label">
                                                    <input type="number" min="1" max="30"
                                                           id="numOfRepeat" value="1"> buổi
                                                </label>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="ln_solid"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <!-- End Hide Repeat Oncheck -->

                                    <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-2 col-sm-2 col-xs-12">Assigned:</label>--%>
                                    <%--<div class="col-md-10 col-sm-10 col-xs-12">--%>
                                    <%--<select class="form-control">--%>
                                    <%--<option>Choose option</option>--%>
                                    <%--<option>Option one</option>--%>
                                    <%--<option>Option two</option>--%>
                                    <%--<option>Option three</option>--%>
                                    <%--<option>Option four</option>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-2 col-sm-2 col-xs-12">Room:</label>--%>
                                    <%--<div class="col-md-10 col-sm-10 col-xs-12">--%>
                                    <%--<select class="form-control">--%>
                                    <%--<option>Choose option</option>--%>
                                    <%--<option>Option one</option>--%>
                                    <%--<option>Option two</option>--%>
                                    <%--<option>Option three</option>--%>
                                    <%--<option>Option four</option>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-2 col-sm-2 col-xs-12">Status:</label>--%>
                                    <%--<div class="col-md-10 col-sm-10 col-xs-12">--%>
                                    <%--<input type="text" class="form-control" disabled="readonly">--%>
                                    <%--</div>--%>
                                    <%--</div>--%>

                                    <div class="col-md-12 form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               style="text-align: left">Công khai</label>
                                        <label class="control-label" style="margin-left: -30px;margin-top: -7px">
                                            <input type="checkbox" class="js-switch" checked/>
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

</body>
</html>

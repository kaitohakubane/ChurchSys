<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/16/2017
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Phòng hài cốt</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/lib/gridDist/gridstack.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/grave.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/lib/sematicDist/semantic.min.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <ul class="nav nav-tabs">
                    <li id="li-1" class="active"><a data-toggle="tab" href="#step1">Bố trí phòng</a></li>
                    <li id="li-2"><a data-toggle="tab" href="#step2">Sơ đồ</a></li>
                    <li>
                        <select class="ui fluid dropdown search" id="graveSearch">
                            <%--<c:forEach items="" var="item">--%>
                            <option class="subClass" value="">Tìm vị trí</option>
                        </select>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="step1" class="tab-pane fade in active">
                        <div class="col-md-2">
                            <div class="color-description">
                                <h4>Chú thích</h4>
                                <ul>
                                    <li style="color: #ae60f2">
                                        <i class="fa fa-square"></i>
                                        <span>Cửa</span>
                                    </li>
                                    <li style="color: #ef0b0b">
                                        <i class="fa fa-square"></i>
                                        <span>Bàn thờ</span>
                                    </li>
                                    <li style="color: #777">
                                        <i class="fa fa-square"></i>
                                        <span>Chưa được xét</span>
                                    </li>
                                    <li style="color: #01ff70">
                                        <i class="fa fa-square"></i>
                                        <span>Đã khởi tạo</span>
                                    </li>
                                    <li style="color: #3c8dbc">
                                        <i class="fa fa-square"></i>
                                        <span>Hết vị trí</span>
                                    </li>
                                    <li style="color: #ff8514">
                                        <i class="fa fa-square"></i>
                                        <span>Vị trí đang tìm</span>
                                    </li>
                                </ul>
                            </div>
                            <div class="clearfix"></div>
                            <div class="btn-group" style="margin-top: 10px; margin-left: 30px">
                                <button type="button" class="btn btn-info btn-lg dropdown-toggle" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false">
                                    Thêm mới <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" style="font-size: 15px;">
                                    <li id="createGrave"><a>Tủ hài cốt</a></li>
                                    <li id="createGate"><a>Cửa ra vào</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-10" style="margin-top: 10px;">
                            <div class="grid-stack graveYard" id="graveYard">

                            </div>
                        </div>

                    </div>

                    <div id="step2" class="tab-pane fade">
                        <div class="col-md-2">
                            <div class="color-description">
                                <h4>Chú thích</h4>
                                <ul>
                                    <li style="color: #777">
                                        <i class="fa fa-square"></i>
                                        <span>Chưa được xét</span>
                                    </li>
                                    <li style="color: #4288f1">
                                        <i class="fa fa-square"></i>
                                        <span>Đã xem xét</span>
                                    </li>
                                    <li style="color: #f243b5">
                                        <i class="fa fa-square"></i>
                                        <span>Chờ xét duyệt</span>
                                    </li>
                                    <li style="color: #ff8514">
                                        <i class="fa fa-square"></i>
                                        <span>Vị trí đang tìm</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-10" style="margin-top: 10px;">
                            <div class="grid-stack" id="grave">
                                    <h1 class="default-text">Xin hãy chọn tủ</h1>
                            </div>
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


<!-- popup -->
<div id="prototype" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog" style="width: 400px;">

        <div class="row">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 style="text-align: center;">Tạo tủ hài cốt</h3>
                    <div class="clearfix"></div>
                </div>
                <div class="panel-body">
                    <div class="form-horizontal form-label-left input_mask">

                        <div class="form-group  text-center">
                            <label class="control-label">Hãy chọn dạng bố trí tủ</label>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6">
                                <img src="<c:url value="/resources/img/grave2.PNG" />" class="style-grave"
                                     style="width: 100%"
                                     data-id="type1">
                            </div>

                            <div class="col-md-6">
                                <img src="<c:url value="/resources/img/grave1.PNG" />" class="style-grave"
                                     style="width: 100%"
                                     data-id="type2">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-5 col-sm-5 col-xs-12">Số tủ ngang và dọc</label>
                            <span class="col-md-3 col-sm-3 col-xs-12 col-md-offset-1">
                      <input type="text" class="form-control" id="prototypeWidth">
                    </span>
                            <span class="col-md-3 col-sm-3 col-xs-12">
                      <input type="text" class="form-control" id="prototypeHeight">
                    </span>
                        </div>

                        <div class="ln_solid"></div>
                        <button type="button" class="btn btn-success pull-right" id="protoypePopupBtn">Khởi tạo</button>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<%--Context menu--%>
<%--===================--%>
<div class="row graveContextMenu" id="graveYardInformation">
    <div class="" style="width: 300px;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 style="text-align: center;">Thông tin tủ</h3>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body">
                <div class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Tên</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 input-group has-success">
                            <input type="text" class="form-control" id="contextName" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Số vị
                            trí</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 input-group has-success">
                            <input type="text" class="form-control" id="contextSlot" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Còn
                            trống</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 input-group has-success">
                            <input type="text" class="form-control" id="contextFree" disabled="readonly">
                        </div>
                    </div>


                    <div class="clearfix"></div>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                            <button type="button" id="contextBtn" class="btn btn-success">Xem</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<%--=======================--%>
<!-- popup -->
<div id="graveYardPopup" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog" style="width: 300px;">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Thiết lập</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content">
                            <div class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" style="text-align: left">Tên</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" id="graveYardName" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-7 col-sm-7 col-xs-12" style="text-align: left">Số
                                        ô tủ ngang</label>
                                    <div class="col-md-5 col-sm-5 col-xs-12">
                                        <input type="text" id="graveYardWidth" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-7 col-sm-7 col-xs-12" style="text-align: left">Số
                                        ô tủ dọc</label>
                                    <div class="col-md-5 col-sm-5 col-xs-12">
                                        <input type="text" id="graveYardHeight" class="form-control">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                <button type="button" id="intialGraveYard" class="btn btn-primary">Khởi tạo</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>

<%--/////////////////////////////////////////////////////////////////////////////////--%>

<div class="row graveContextMenu" id="regisContext">
    <div class="" style="width: 580px;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 style="text-align: center;">Đăng ký hài cốt</h3>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body">
                <div class="form-horizontal form-label-left input_mask">
                    <form id="grave-form" role="form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">Họ tên</label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="text" name="graveName" class="form-control">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">Ngày sinh</label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="text" name="graveBirth" class="form-control" id="graveBirthDay">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">Nơi sinh</label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="text" name="graveHomeTown" class="form-control">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">Ngày mất</label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="text" name="graveDeathDay" class="form-control" id="graveDeathDay">
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">Giáo xứ</label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="text" name="graveParish" class="form-control">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">Liên lạc </label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="number" name="phoneNum" class="form-control">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-3 col-xs-12" style="text-align: left;">CMND</label>
                                <div class="col-md-8 col-sm-9 col-xs-12 input-group has-success">
                                    <input type="text" name="userIdentity" class="form-control">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-11 col-sm-9 col-xs-12 col-md-offset-1 input-group has-success">
                                    <input type="file" name="graveImage" class="form-control-file">
                                </div>
                            </div>

                        </div>
                    </form>
                    <div class="clearfix"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
                            <button type="button" id="regisBtn" class="btn btn-success">Thêm</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<%--/////////////////////////////////////////////////////////////////////////////////--%>

<div class="row graveContextMenu" id="detailContext">
    <div class="" style="width: 300px;">
        <div class="panel panel-success">
            <div class="panel-body">
                <div class="form-horizontal form-label-left input_mask">

                    <div class="col-md-4 col-md-offset-4"
                         style="margin-bottom: 10px">
                        <img id="image" src="<c:url value="/resources/img/noimagefound.jpg"/>" style="width: 100%">
                    </div>

                    <div class="col-md-4 col-md-offset-1">
                        <p><b>Họ tên</b></p>
                        <p><b>Ngày sinh</b></p>
                        <p><b>Noi sinh</b></p>
                        <p><b>Ngày mất</b></p>
                        <p><b>Giáo xứ</b></p>
                        <p><b>Người đặt</b></p>
                        <p><b>Điện thoại</b></p>
                        <p><b>CMND</b></p>
                    </div>

                    <div class="col-md-7">
                        <p id="detailName">Tran Anh Kiet</p>
                        <p id="detailBirthday">1 - 1 - 1995</p>
                        <p id="detailHomeTown">TP HCM</p>
                        <p id="detailDeathDay">1 -1 - 2111</p>
                        <p id="detailParish">Da Nang</p>
                        <div class="clearfix"></div>
                        <p id="detailRegisName">Da Nang</p>
                        <p id="detailRegisPhone">Da Nang</p>
                        <div id="identityContainer"><p id="detailRegisIdentity">123123</p></div>
                    </div>
                    <div class="clearfix"></div>
                    <br>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3">
                            <button type="button" id="detailProcess" class="btn btn-success">Rút</button>
                            <button type="button" id="detailReject" class="btn btn-default">Xong</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>

<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/lodash.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.jQueryUI.js"/>"></script>
<script src="<c:url value="/resources/lib/sematicDist/semantic.js"/>"></script>
<script src="<c:url value="/resources/js/grave.js"/>"></script>
</body>
</html>

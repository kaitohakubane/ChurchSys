<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 8/12/2017
  Time: 2:41 AM
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
    <title>User Grave Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>
    <!-- CSS -->
    <link href="<c:url value="/resources/lib/gridDist/gridstack.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/grave.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/lib/sematicDist/semantic.min.css"/>" rel="stylesheet">
</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<!-- church-info -->
<div class="container">
    <div class="row">
        <c:import url="/resources/layouts/user-common/church-info.jsp"/>
        <c:import url="/resources/layouts/user-common/navbar-private.jsp"/>
    </div>
</div>
<!-- end church info -->
<!-- page content -->
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="nav nav-tabs">
                <li id="li-1" class="active"><a data-toggle="tab" href="#step1">Bố trí phòng</a></li>
                <li id="li-2"><a data-toggle="tab" href="#step2">Sơ đồ</a></li>
                <li>
                    <select class="ui fluid dropdown search" id="graveSearch">
                        <%--<c:forEach items="" var="item">--%>
                        <option class="subClass" value="">Tìm hài cốt</option>
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
                                    <span>Tượng chúa</span>
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
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-10" style="margin-top: 10px; height: 1000px">
                        <div class="grid-stack" id="grave">

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- end page content -->
<%--===================--%>
<div class="row graveContextMenu" id="graveYardInformation">
    <div class="" style="width: 300px;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div style="text-align: center;font-size: 140%;font-weight: bold">Thông tin tủ</div>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body" style="padding-bottom: 0px">
                <div class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Tên</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 has-success">
                            <input type="text" class="form-control" id="contextName" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Số vị
                            trí</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 has-success">
                            <input type="text" class="form-control" id="contextSlot" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Còn
                            trống</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 has-success">
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

<%--/////////////////////////////////////////////////////////////////////////////////--%>

<div class="row graveContextMenu" id="regisContext">
    <div class="" style="width: 370px;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div style="text-align: center;font-size: 140%;font-weight: bold">Đăng ký hài cốt</div>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body" style="padding-bottom: 0px">
                <div class="form-horizontal form-label-left input_mask">
                    <form id="grave-form" role="form">
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Họ tên</label>
                            <div class="col-md-9 col-sm-9 col-xs-12 has-success">
                                <input type="text" name="graveName" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày sinh</label>
                            <div class="col-md-9 col-sm-9 col-xs-12 has-success">
                                <input type="text" name="graveBirth" class="form-control" id="graveBirthDay">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Nơi sinh</label>
                            <div class="col-md-9 col-sm-9 col-xs-12 has-success">
                                <input type="text" name="graveHomeTown" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày mất</label>
                            <div class="col-md-9 col-sm-9 col-xs-12 has-success">
                                <input type="text" name="graveDeathDay" class="form-control" id="graveDeathDay">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Giáo xứ</label>
                            <div class="col-md-9 col-sm-9 col-xs-12 has-success">
                                <input type="text" name="graveParish" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3 input-group has-success">
                                <input type="file" name="graveImage" class="form-control-file">
                            </div>
                        </div>
                    </form>
                    <div class="clearfix"></div>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                            <button type="button" id="regisBtn" class="col-md-5 btn btn-success">Đăng Ký</button>
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
            <div class="panel-body" style="padding: 0px;">
                <div class="form-horizontal form-label-left input_mask">
                    <div class="col-md-4 col-md-offset-4"
                         style="margin-bottom: 10px; margin-top: 10px">
                        <img id="image" src="<c:url value="/resources/img/noimagefound.jpg"/>" style="width: 100%">
                    </div>

                    <div class="col-md-4 col-md-offset-1">
                        <p><b>Họ tên</b></p>
                        <p><b>Ngày sinh</b></p>
                        <p><b>Noi sinh</b></p>
                        <p><b>Ngày mất</b></p>
                        <p><b>Giáo xứ</b></p>
                    </div>

                    <div class="col-md-7">
                        <p id="detailName">Tran Anh Kiet</p>
                        <p id="detailBirthday">1 - 1 - 1995</p>
                        <p id="detailHomeTown">TP HCM</p>
                        <p id="detailDeathDay">1 -1 - 2111</p>
                        <p id="detailParish">Da Nang</p>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                            <button type="button" id="detailReject" class="col-md-4 btn btn-success">Hủy</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script>
    var churchId =${param.churchId};
</script>
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/lodash.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.jQueryUI.js"/>"></script>
<script src="<c:url value="/resources/lib/sematicDist/semantic.js"/>"></script>
<script src="<c:url value="/resources/js/user-grave.js"/>"></script>
</body>
</html>


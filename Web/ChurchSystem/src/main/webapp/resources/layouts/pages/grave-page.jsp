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

    <title>Mộ phần</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/lib/gridDist/gridstack.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/grave.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#step1">Bố trí phòng</a></li>
                    <li><a data-toggle="tab" href="#step2">Sơ đồ mộ</a></li>

                </ul>

                <div class="tab-content">
                    <div id="step1" class="tab-pane fade in active">
                        <div>
                            <a class="btn btn-default" id="load-grid" href="#">Load Grid</a>
                            <a class="btn btn-default" id="add-cabinet" href="#">Add Cabinet</a>
                        </div>
                        <div class="grid-stack graveYard" id="graveYard">

                        </div>
                    </div>
                    <div id="step2" class="tab-pane fade">
                        <div class="grid-stack cabinet">

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
<div id="prototype" class="modal fade" role="dialog">
    <div class="modal-dialog" style="width: 400px;">

        <div class="row">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 style="text-align: center;">Popup</h3>
                    <div class="clearfix"></div>
                </div>
                <div class="panel-body">
                    <div class="form-horizontal form-label-left input_mask">

                        <div class="form-group  text-center">
                            <label class="control-label">Hãy chọn dạng bố trí tủ</label>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6">
                                <img src="<c:url value="/resources/img/noimagefound.jpg" />" class="style-grave" style="width: 100%"
                                data-id="type1">
                            </div>

                            <div class="col-md-6">
                                <img src="<c:url value="/resources/img/noimagefound.jpg" />" class="style-grave" style="width: 100%"
                                data-id="type2">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-5 col-sm-5 col-xs-12">Số tủ ngang và dọc</label>
                            <span class="col-md-3 col-sm-3 col-xs-12 col-md-offset-1">
                      <input type="text" class="form-control">
                    </span>
                            <span class="col-md-3 col-sm-3 col-xs-12">
                      <input type="text" class="form-control">
                    </span>
                        </div>

                        <div class="ln_solid"></div>
                        <button type="button" class="btn btn-success pull-right" id="protoypePopupBtn">Create</button>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

Context menu
===================
<div class="row">
    <div class="" style="width: 300px;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 style="text-align: center;">Context</h3>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body">
                <div class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Tên</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 input-group has-success">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">S? v?
                            trí</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 input-group has-success">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" style="text-align: left;">Còn
                            tr?ng</label>
                        <div class="col-md-8 col-sm-8 col-xs-12 input-group has-success">
                            <input type="text" class="form-control" disabled="readonly">
                        </div>
                    </div>


                    <div class="clearfix"></div>
                    <div class="form-group">
                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                            <button type="submit" class="btn btn-success">Xem</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
=======================
<!-- /popup -->
<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/lodash.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.jQueryUI.js"/>"></script>
<script src="<c:url value="/resources/js/grave.js"/>"></script>
</body>
</html>

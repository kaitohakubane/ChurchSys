<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 7/2/2017
  Time: 9:27 PM
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

    <title>Add Church Page</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/stream.css"/>" rel="stylesheet">
    <style>
        .pac-container {
            z-index: 99999;
        }
    </style>

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">

                <div class="row">
                    <div class="col-md-6 col-xs-12 col-md-offset-3">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Thêm nhà thờ</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <div class="form-horizontal form-label-left input_mask">

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên nhà thờ:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Ðịa chỉ:</label>
                                        <div class="col-md-7 col-sm-7 col-xs-10">
                                            <input type="text" class="form-control" >
                                        </div>
                                        <button type="button" id="btnGetLocation" data-target="#locationModal"
                                                data-toggle="modal" class="btn btn-success btn-lg">Chọn
                                        </button>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Quản lí:</label>
                                        <div class="col-md-7 col-sm-7 col-xs-10">
                                            <input type="text" class="form-control">
                                        </div>
                                        <button type="button" id="btnAssign" class="btn btn-success btn-lg">Tạo
                                        </button>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Giờ hoạt động:</label>
                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <input type="eu-time" id="startTime" value="06:00" class="form-control">
                                        </div>

                                        <label class="control-label col-sm-1">Đến</label>

                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <input type="eu-time" id="endTime" value="22:00" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Mô tả:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <textarea class="form-control" rows="5"></textarea>
                                        </div>
                                    </div>

                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                                            <button type="button" id="btnBack" class="btn btn-default btn-lg">Quay lại
                                            </button>
                                            <button type="button" id="btnSave" class="btn btn-success btn-lg">Thêm
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
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<div id="locationModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Tìm địa chỉ</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal" style="width: 550px">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Location:</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="us3-address" />
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label class="col-sm-2 control-label">Radius:</label>--%>

                        <%--<div class="col-sm-5">--%>
                            <%--<input type="text" class="form-control" id="us3-radius" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div id="us3" style="width: 100%; height: 400px;"></div>
                    <div class="clearfix">&nbsp;</div>
                    <div class="m-t-small">
                        <label class="p-r-small col-sm-1 control-label">Lat.:</label>

                        <div class="col-sm-3">
                            <input type="text" class="form-control" style="width: 110px" id="us3-lat" />
                        </div>
                        <label class="p-r-small col-sm-2 control-label">Long.:</label>

                        <div class="col-sm-3">
                            <input type="text" class="form-control" style="width: 110px" id="us3-lon" />
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<!-- jQuery -->
<c:import url="/resources/layouts/common/footer.jsp"/>
<script type="text/javascript" src='<c:url value="https://maps.google.com/maps/api/js?sensor=false&libraries=places&key=AIzaSyCxiXCdE2EE0GU3VB00yLdGWEZQteUx0C0"/>'></script>
<script src="<c:url value="/resources/lib/locationDist/locationpicker.jquery.js"/>"></script>

<script src="<c:url value="/resources/js/add-church.js"/>"></script>
</body>
</html>

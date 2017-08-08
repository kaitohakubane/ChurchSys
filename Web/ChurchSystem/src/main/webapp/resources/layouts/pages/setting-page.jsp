<%--
Created by IntelliJ IDEA.
User: Mr Kiet
Date: 07/28/17
Time: 1:38 AM
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
    <title>Setting</title>
    <c:import url="/resources/layouts/common/header.jsp"/>

    <link href="<c:url value="/resources/lib/src/js/animate.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/lib/src/js/w2ui-1.5.rc1.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/lib/src/js/jquery-ui.min.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/lib/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">

    <!-- Dropzone.js -->
    <link href="<c:url value="/resources/lib/vendors/dropzone/dist/min/dropzone.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/edit-event-page.css"/>" rel="stylesheet">

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
                                <h2>Thiết lập</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <div class="form-horizontal form-label-left input_mask">

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên nhà thờ:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" id="churchName" class="form-control"
                                                   value="${churchObj.churchName}" data-id=""${churchObj.churchId}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Ðịa chỉ:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" class="form-control" value="${churchObj.address}"
                                                   id="churchAddress">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" class="form-control" value="${churchObj.tel}"
                                                   id="churchTel">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Email:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text" class="form-control" value="${churchObj.mail}"
                                                   id="churchEmail">
                                        </div>
                                    </div>

                                    <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-3 col-sm-3 col-xs-12">Giờ hoạt động:</label>--%>
                                    <%--<div class="col-md-4 col-sm-4 col-xs-12">--%>
                                    <%--<input type="eu-time" id="startTime" value="06:00" class="form-control">--%>
                                    <%--</div>--%>

                                    <%--<label class="control-label col-sm-1">đến</label>--%>

                                    <%--<div class="col-md-4 col-sm-4 col-xs-12">--%>
                                    <%--<input type="eu-time" id="endTime" value="22:00" class="form-control">--%>
                                    <%--</div>--%>
                                    <%--</div>--%>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <form action="form_upload.html" class="dropzone"></form>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Mô tả:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <textarea class="form-control" rows="5"
                                                      id="churchDescription">${churchObj.description}</textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Giao diện:</label>
                                        <button class="col-md-3"
                                                style="background-color: #7ab33e; border: 2px solid #7ab33e; height: 30px; margin-left: 10px;"
                                                id="theme" data-color="${setting.theme}"
                                                data-toggle="modal" data-target="#theme-modal"></button>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-offset-3 checkbox">
                                            <label>
                                                <c:if test="${setting.isSync == 0}">
                                                    <input type="checkbox" class="flat" id="isSync"
                                                           selected="false"> Đồng bộ với Google
                                                    Calendar
                                                </c:if>
                                                <c:if test="${setting.isSync == 1}">
                                                    <input type="checkbox" class="flat" id="isSync"
                                                           checked> Đồng bộ với Google
                                                    Calendar
                                                </c:if>
                                            </label>
                                        </div>
                                    </div>

                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-5 col-sm-5 col-xs-12 col-md-offset-5">
                                            <button type="button" id="btnSave" class="btn btn-success btn-lg">Cập nhật
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

        <!-- popup -->
        <div id="theme-modal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <div class="row">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 style="text-align: center;">Theme</h3>
                            <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                            <div class="form-horizontal form-label-left input_mask">

                                <div class="form-group">
                                    <div class="col-md-8 col-md-offset-2">
                                        <c:if test="${setting.theme == 0}">
                                            <img src=""
                                                 id="theme-picture" style="width: 100%">
                                        </c:if>
                                        <c:if test="${setting.theme == 1}">
                                            <img src=""
                                                 id="theme-picture" style="width: 100%">
                                        </c:if>
                                    </div>
                                </div>

                                <div class="form-group text-center">
                                    <label>
                                        <input type="radio" class="flat" name="theme-color" value="0" id="green-theme"
                                               checked> <i
                                            class="fa fa-square"
                                            style="font-size: 35px; color: #7ab33e ; vertical-align: middle;"></i>
                                    </label>

                                    <label style="margin-left: 10px">
                                        <input type="radio" class="flat" name="theme-color" value="1"
                                               id="purple-theme"/>
                                        <i
                                                class="fa fa-square"
                                                style="font-size: 35px; color: #400f67 ; vertical-align: middle;"></i>
                                    </label>

                                    <label style="margin-left: 10px">
                                        <input type="radio" class="flat" name="theme-color" value="2" id="pink-theme">
                                        <i
                                                class="fa fa-square"
                                                style="font-size: 35px; color: #ff1744 ; vertical-align: middle;"></i>
                                    </label>
                                </div>

                                <div class="ln_solid"></div>
                                <button type="button" id="processBtn" class="btn btn-success pull-right">Lưu</button>
                                <button type="button" class="btn pull-right" data-dismiss="modal">Hủy</button>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- /popup -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/src/js/w2ui-1.5.rc1.min.js"/>"></script>
<!-- iCheck -->
<script src="<c:url value="/resources/lib/vendors/iCheck/icheck.min.js"/>"></script>

<!-- Dropzone.js -->
<script src="<c:url value="/resources/lib/vendors/dropzone/dist/min/dropzone.min.js"/>"></script>

<script src="<c:url value="/resources/lib/src/js/bootstrap-notify.min.js"/>"></script>

<script src="<c:url value="/resources/js/setting.js"/>"></script>

<script>
    $('input[type=eu-time]').w2field('time', {format: 'h24'});
</script>

</body>
</html>


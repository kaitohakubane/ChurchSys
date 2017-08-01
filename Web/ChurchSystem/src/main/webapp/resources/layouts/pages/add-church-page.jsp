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

    <title>Stream Page</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/stream.css"/>" rel="stylesheet">

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
                                            <input type="text"  class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Ðịa chỉ:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text"  class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text"  class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Phân công:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <input type="text"  class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Gi? ho?t d?ng:</label>
                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <input type="eu-time" id="startTime" value="06:00" class="form-control">
                                        </div>

                                        <label class="control-label col-sm-1">d?n</label>

                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <input type="eu-time" id="endTime" value="22:00" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Mô t?:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <textarea class="form-control" rows="5"></textarea>
                                        </div>
                                    </div>

                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                                            <button type="button" id="btnBack" class="btn btn-default btn-lg">H?y
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

<!-- jQuery -->
<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/js/stream.js"/>"></script>
</body>
</html>

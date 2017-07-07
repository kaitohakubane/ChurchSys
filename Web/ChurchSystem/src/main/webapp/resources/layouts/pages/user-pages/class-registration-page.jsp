<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/7/2017
  Time: 10:36 PM
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
    <title>Information Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>
    <!-- CSS -->
    <link href="<c:url value="/resources/css/church.css"/>" rel="stylesheet">
</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<c:import url="/resources/layouts/user-common/vertical-navbar.jsp"/>
<!-- church-info -->
<div class="container">
    <div class="row">
        <div class="church-info col-md-12">

        </div>
        <div class="small-nav col-md-12">
            <div class="row">
                <div class="col-md-4">
                    <a href="#" class="col-md-12 btn btn-default">Tin tức</a>
                </div>
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/church/schedule?churchId=${churchId}" class="col-md-12 btn btn-default">Sự kiện</a>
                </div>
                <div class="col-md-4">
                    <a href="#" class="col-md-12 btn btn-default">Đăng ký lớp học</a>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="border-top"></div>
        </div>
    </div>
</div>
<!-- end church info -->
<!-- page content -->
<div class="page-content">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">Lớp</h4>
                    </div>
                    <div class="panel-body" style="padding: 15px 0">
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Tên lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-id-card fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Lớp</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-book fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Ngày bắt đầu</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Các ngày</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Thời gian</label>
                        </div>
                        <div class="col-md-8 form-group has-success">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled="disabled"><br/>
                                <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-2 col-sm-2 col-xs-12 col-md-offset-4">
                                <button type="submit" class="btn btn-success">Đăng kí</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->

<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script src="<c:url value="/resources/js/church.js"/>"></script>
</body>
</html>

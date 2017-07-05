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
                <!-- step 1 -->
                <div class="row" id="step-1">
                    <div class="col-md-10 col-md-offset-1">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="false">

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <img src="<c:url value="/resources/img/stream-tutorial-1.PNG"/>">
                                    <div class="carousel-caption">
                                        <h3>Bước 1</h3>
                                        <p>Chọn mục Settings trong phần mềm OBS</p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="<c:url value="/resources/img/stream-tutorial-2.PNG"/>">
                                    <div class="carousel-caption">
                                        <h3>Bước 2</h3>
                                        <p>Chọn mục Stream và điều chỉnh Service thành Youtube / Youtube Gaming</p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="<c:url value="/resources/img/stream-tutorial-3.PNG"/>">
                                    <div class="carousel-caption">
                                        <h3>Bước 3</h3>
                                        <p>Nhập mục Stream key bằng "Mã xác nhận" bên dưới</p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="<c:url value="/resources/img/stream-tutorial-4.PNG"/>">
                                    <div class="carousel-caption">
                                        <h3>Bước 4</h3>
                                        <p>Nhấn nút "Start streaming" ở góc phải bên dưới và bắt đầu stream</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Controls -->
                            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <br>
                    <div class="col-md-4 col-md-offset-2" style="margin-top: 10px">
                        <label class="col-md-3 col-sm-3 col-xs-12">Mã xác nhận :</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" disabled="disabled" id="streamCode" style="border: 2px solid red;">
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-3">
                        <button class="col-md-12 btn btn-default" id="next">Tiếp tục</button>
                    </div>
                </div>

                <!-- step 2 -->
                <div class="row" id="step-2">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="videoWrapper">
                            <iframe id="youtubeVideo" width="480" height="360" src="https://www.youtube.com/embed/t9qNS6aHMw8"
                                    frameborder="0" allowfullscreen></iframe>
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-9" style="margin-top: 20px">
                        <button class="col-md-12 btn btn-default" id="end">Kết thúc</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<!-- popup -->
<div id="registration" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Đặt tên sự kiện Stream</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content">
                            <form class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Stream :</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" id="streamTitle" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Độ phân giải :</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <select class="form-control" id="resolution">
                                            <option>240p</option>
                                            <option>360p</option>
                                            <option>480p</option>
                                            <option>720p</option>
                                            <option>1080p</option>
                                        </select>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" id="createStreambtn" class="btn btn-primary" >OK</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->
<!-- /popup -->
<!-- jQuery -->
<c:import url="/resources/layouts/common/footer.jsp"/>
<script>
    var streamLink="<c:out value="${streamLink}"></c:out>"
    var streamCode="<c:out value="${streamCode}"></c:out>"
</script>

<script src="<c:url value="/resources/js/stream.js"/>"></script>
</body>
</html>

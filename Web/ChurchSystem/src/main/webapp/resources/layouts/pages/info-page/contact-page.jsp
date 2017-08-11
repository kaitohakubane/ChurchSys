<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/30/2017
  Time: 10:24 PM
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
    <title>Contact Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>


    <style>
        body{
            height: 100vh;
        }
        .rowcn {
            height: calc(100vh - 326px);
        }
        .office {
            margin-top: 30px;
        }
        .office:first-child{
            margin-top: 0px;
        }
    </style>
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
    <div class="row rowcn">
        <div class="col-md-6">
            <h2 class="form-group col-md-6 col-md-offset-5" >Liên hệ Cha xứ</h2>
            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Ngày gặp:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Thời gian:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-clock-o" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Tiêu đề:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-file-text-o" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Nội dung:</label>
                    <div class="col-md-9">
                        <textarea class="form-control" rows="7"></textarea>
                    </div>
                </div>
            </form>

            <div class="form-group">
                <button type="button" class="btn btn-default col-md-5 col-md-offset-5">Gửi</button>
            </div>
        </div>
        <div class="col-md-6">
            <div class="office">
                <h2 class="form-group col-md-9 col-md-offset-3" >Văn phòng giáo xứ</h2>
                <div class="clearfix"></div>
                <div class="col-md-offset-3" style="font-size: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0907 120 203</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        <span>giaoxuchanhtoa@gmail.com</span>
                    </div>
                </div>
            </div>

            <div class="office">
                <h2 class="form-group col-md-9 col-md-offset-3" >Văn phòng giáo lý</h2>
                <div class="clearfix"></div>
                <div class="col-md-offset-3" style="font-size: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0128 908 1762</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        <span>giaolychanhtoa@gmail.com</span>
                    </div>
                </div>
            </div>

            <div class="office">
                <h2 class="form-group col-md-9 col-md-offset-3" >Văn phòng mục vụ</h2>
                <div class="clearfix"></div>
                <div class="col-md-offset-3" style="font-size: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0128 610 4818</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        <span>mucvuchanhtoa@gmail.com</span>
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
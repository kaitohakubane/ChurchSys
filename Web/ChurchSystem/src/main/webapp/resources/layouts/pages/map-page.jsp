<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 6/12/2017
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>
    <link href="<c:url value="/resources/css/map.css"/>" rel="stylesheet">

</head>
<body>

<%--<c:import url="/resources/layouts/user-common/user-header.jsp"/>--%>
<nav class="navbar navbar-default navbar-fixed-top mega-nav">
    <div class="container">
        <div class="collapse navbar-collapse" id="MainMenu">
            <ul class="nav navbar-nav menu-list" style="margin-left: 100px">
                <li><a href="${pageContext.request.contextPath}/" class="icon-top"><img alt="Church Icon"
                                                                                        src="<c:url value="/resources/img/icon.png"/>"
                                                                                        class="icon-img"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/dashboard">Bảng điều khiển</a></li>
                <li><a href="#">Tin giáo hội</a></li>
                <li><a href="${pageContext.request.contextPath}/calendar/august">Lịch công giáo</a></li>
                <li class="dropdown list-category">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">
                        <i class="fa fa-navicon"></i> Thư viện <i class="fa fa-caret-down" aria-hidden="true"></i>
                    </a>
                    <ul class="dropdown-menu mega-dropdown-menu drop-hover">
                        <li><a href="${pageContext.request.contextPath}/bible">Kinh thánh</a></li>
                        <li><a href="#">Sách kinh</a></li>
                        <li><a href="#">Truyện các thánh</a></li>
                        <li><a href="#">Bài giảng</a></li>
                        <li><a href="#">Phim &#38; Audio</a></li>
                        <li><a href="#">Trắc nghiệm giáo lý</a></li>
                        <li><a href="#">Khác</a></li>
                    </ul>
                </li>
                <li><a href="#">Phản hồi</a></li>
            </ul>
            <div class="pull-right">


                <sec:authentication var="principal" property="principal"/>
                <c:choose>

                    <c:when test="${principal ne 'anonymousUser'}">
                        <ul class="nav navbar-nav menu-list">
                            <li style="font-size: 20px"><a href="#" class="dropdown-toggle" id="noti-user"
                                                           data-toggle="dropdown"><i class="fa fa-bell"
                                                                                     aria-hidden="true"></i>
                                <span id="numberOfNoti">1</span></a>
                                <ul class="dropdown-menu space" aria-labelledby="noti-user" style="width: 300px"
                                    id="notification">
                                    <li>
                                        <a>
                                            <span>Chính tòa Đà Nẵng</span><br/>
                                            <span>Film festivals used to be do-or-die moments for movie makers. They were where...</span>
                                        </a>
                                    </li>

                                    <li><a href="${pageContext.request.contextPath}/user/notifications"
                                           class="text-center"><strong>Xem tất cả </strong><i
                                            class="fa fa-angle-double-right"></i></a></li>
                                </ul>
                            </li>
                            <li class="dropdown list-category" style="border-left: none">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">
                                    <strong>${principal.username} </strong><i
                                        class="fa fa-caret-down" aria-hidden="true"></i>
                                </a>
                                <ul class="dropdown-menu mega-dropdown-menu">
                                    <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i> Thông tin tài
                                        khoản</a></li>
                                    <li><a href="#"><i class="fa fa-heart" aria-hidden="true"></i> Nhà thờ đang theo dõi</a>
                                    </li>
                                    <li><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i> Sự kiện tham
                                        gia</a></li>
                                    <li><a href="#"><i class="fa fa-credit-card-alt" aria-hidden="true"></i> Lịch sử
                                        đóng góp</a></li>
                                    <li><a href="#"><i class="fa fa-question-circle" aria-hidden="true"></i> Lịch sử câu
                                        hỏi</a></li>
                                    <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"
                                                                                               aria-hidden="true"></i>
                                        Đăng xuất</a></li>
                                </ul>
                            </li>
                        </ul>
                    </c:when>
                    <c:when test="${principal eq 'anonymousUser'}">
                        <ul class="nav-right">
                            <li><a class="button" data-toggle="modal" data-target="#registration">Đăng ký</a></li>
                            <li><a href="${pageContext.request.contextPath}/index" class="button">Đăng nhập</a></li>
                        </ul>
                    </c:when>
                </c:choose>


            </div>
        </div>
    </div>
</nav>
<!-- end navbar -->
<div id="registration" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="main">
            <div class="main-login main-center">
                <h3 class="text-center">Đăng kí tài khoản</h3>
                <form class="form-horizontal" method="post" action="#">
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"
                                       placeholder="Tên người dùng"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="username" id="username"
                                       placeholder="Tên tài khoản"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                   aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="Mật khẩu"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                   aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="confirm" id="confirm"
                                       placeholder="Nhập lại mật khẩu"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa"
                                                                   aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="email" id="email"
                                       placeholder="Địa chỉ email"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-mobile fa-lg"
                                                                   aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="phone" id="phone"
                                       placeholder="Số điện thoại"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <div class="col-md-12">
                            <a href="#" type="button" class="btn btn-success col-md-5">Đăng kí</a>
                            <a href="#" type="button" class="btn btn-default col-md-5 col-md-offset-2">Hủy</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->


<!-- navbar left -->
<div id="wrapper">
    <div id="sidebar-wrapper">
        <ul id="sidebar_menu" class="sidebar-nav">
            <li class="sidebar-brand"><a id="menu-toggle" href="#">Nhà thờ Online<span id="main_icon"
                                                                                       class="glyphicon glyphicon-align-justify"></span></a>
            </li>
        </ul>
        <ul class="sidebar-nav" id="sidebar">

        </ul>
    </div>
</div>

<input id="pac-input" class="controls" type="text" placeholder="Tìm kiếm">
<div id="map" class="col-md-12"></div>
<div id="geocontainer" class="geolocation">
    <div id="geolocationBtn" class="icon"></div>
</div>
<!-- popup -->
<div id="stream" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Stream</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="videoWrapper">
                        <iframe id="youtubeVideo" width="480" height="360"
                                src="https://www.youtube.com/embed/ddFvjfvPnqk" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" id="closeBtn" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->

<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxrUsPf9t6b1RbI04YsBQnC-FqJmMATZk&libraries=places"
/>"></script>

<script>
    var icon = "<c:url value="/resources/img/icons8-Church-48.png"/>"
    var streaming_icon = "<c:url value="/resources/img/streamming-icon.png"/>"
    var choosing_icon = "<c:url value="/resources/img/choosing-icon.png"/>"
</script>
<script src="<c:url value="/resources/js/map.js"/>"></script>
</body>


</html>

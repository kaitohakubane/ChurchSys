<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/20/2017
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dashboard Page</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/user-dashboard.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <ul class="nav navbar-nav navbar-left" style="margin-left: 207px;">
                <li><a href="${pageContext.request.contextPath}/" class="icon-top"><img alt="Church Icon"
                                                                                        src="<c:url value="/resources/img/icon.png"/>"
                                                                                        class="icon-img"></a>
                </li>

                <li class="">
                    <a href="${pageContext.request.contextPath}/user/dashboard">Bảng thông tin</a>
                </li>

                <li class="">
                    <a>Tin giáo hội</a>
                </li>

                <li class="">
                    <a>Lịch công giáo</a>
                </li>

                <li class="">
                    <a><i class="fa fa-navicon"></i> Thư viện <i class="fa fa-caret-down"></i></a>
                </li>

                <li class="">
                    <a>Phản hồi</a>
                </li>
            </ul>

            <sec:authentication var="principal" property="principal"/>
            <ul class="nav navbar-nav navbar-right" style="margin-right: 207px;">

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
            </ul>

        </nav>
    </div>
</div>
<!-- /top navigation -->
<div class="container body">
    <div class="main_container">


        <!-- top navigation -->


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">

                <div class="col-md-3" style="border: 1px solid #E6E9ED">

                    <!-- menu profile quick info -->
                    <div class="profile clearfix">
                        <div class="profile_pic">
                            <img src="<c:url value="/resources/img/user.png"/>" alt="..."
                                 class="img-circle profile_img dbimg">
                        </div>
                        <div class="profile_info">
                        </div>
                    </div>
                    <!-- /menu profile quick info -->

                    <br/>

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <ul class="nav side-menu" ${currentUser}>

                            <li class="col-md-12">
                                <div class="row">
                                    <p class="col-md-5"><b>Tên:</b></p>
                                    <p class="col-md-7">${currentUser.userName}</p>
                                </div>
                            </li>

                            <li class="col-md-12">
                                <div class="row">
                                    <p class="col-md-5"><b>Ngày sinh:</b></p>
                                    <p class="col-md-7">24-07-1994</p>
                                </div>
                            </li>

                            <li class="col-md-12">
                                <div class="row">
                                    <p class="col-md-5"><b>Điện thoại:</b></p>
                                    <p class="col-md-7">${currentUser.tel}</p>
                                </div>
                            </li>

                            <li class="col-md-12">
                                <div class="row">
                                    <p class="col-md-5"><b>Email:</b></p>
                                    <p class="col-md-7">${currentUser.email}</p>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!-- /sidebar menu -->
                </div>

                <div class="col-md-4">
                    <div class="row">

                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Nhà thờ đang theo dõi</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li style="font-size: 21px;margin-left: 40px;"><i class="fa fa-heart"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content bs-example-popovers">
                                    <c:forEach items="${churchList}" var="item" varStatus="status">
                                        <div class="fl-church alert alert-dismissible fade in" id="${status.count}" role="alert">
                                            <a style="color: #fff"
                                               href="${pageContext.request.contextPath}/church?churchId=${item.churchId}">
                                                <button type="button" class="close" data-dismiss="alert"
                                                        id="${item.churchId}"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">×</span>
                                                </button>
                                                <strong>${item.churchName}</strong>
                                                <p>${item.address}</p>
                                            </a>
                                        </div>
                                    </c:forEach>
                                    <button class="col-md-12 btn btn-default" id="loadMore">Xem thêm</button>
                                </div>
                            </div>
                        </div>


                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Lớp học</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li style="font-size: 21px;margin-left: 40px;"><i class="fa fa-book"></i></li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <ul class="list-unstyled timeline">
                                        <li>
                                            <div class="block dbclass-block">
                                                <div class="tags dbclass">
                                                    <a href="" class="tag">
                                                        <span>Đang tham gia</span>
                                                    </a>
                                                </div>
                                                <div class="block_content">
                                                    <h2 class="title">
                                                        <a>Lớp giáo lý hôn nhân</a>
                                                    </h2>
                                                    <p class="excerpt">Nhà thờ hòa khánh</p>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="block dbclass-block">
                                                <div class="tags dbclass">
                                                    <a href="" class="tag done">
                                                        <span>Đã hoàn thành</span>
                                                    </a>
                                                </div>
                                                <div class="block_content">
                                                    <h2 class="title">
                                                        <a>Lớp giáo dự tòng</a>
                                                    </h2>
                                                    <p class="excerpt">Nhà thờ hòa khánh</p>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>

                                </div>
                            </div>
                        </div>


                    </div>
                </div>


                <div class="col-md-5 col-sm-5 col-xs-12">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Sự kiện sắp diễn ra</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li>
                                        <button type="button" class="btn btn-round btn-success">Ngày</button>
                                    </li>
                                    <li>
                                        <button type="button" class="btn btn-round btn-success">Tuần</button>
                                    </li>
                                    <li>
                                        <button type="button" class="btn btn-round btn-success">Tháng</button>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <ul class="list-unstyled timeline">
                                    <c:forEach items="${listIncomingEvent}" var="item">
                                        <li class="ev-church">
                                            <div class="block dbevent-block">
                                                <div class="tags dbevent">
                                                    <a class="tag">
                                                        <span>${item.subName}</span>
                                                    </a>
                                                </div>
                                                <div class="block_content">
                                                    <h2 class="title">
                                                        <a>${item.eventName}</a>
                                                    </h2>
                                                    <div class="byline">
                                                        <span>${item.getTime()}</span>
                                                    </div>
                                                    <p class="excerpt">${item.churchName}</p>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <button class="col-md-12 btn btn-default" id="loadMore1">Load More</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>
<!-- jQuery -->
<c:import url="/resources/layouts/common/footer.jsp"/>
<script>
    var streamLink = "<c:out value="${streamLink}"></c:out>"
    var streamCode = "<c:out value="${streamCode}"></c:out>"
</script>

<script src="<c:url value="/resources/js/user-dashboard.js"/>"></script>
</body>
</html>


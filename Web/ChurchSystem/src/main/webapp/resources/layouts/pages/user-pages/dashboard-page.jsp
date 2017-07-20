<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/20/2017
  Time: 9:55 PM
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

    <title>Dashboard Page</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/stream.css"/>" rel="stylesheet">

    <style>
        .timeline .tags.dbclass {
            width: 110px;
        }
        .timeline .block.dbclass-block {
            margin: 0 0 0 140px;
        }

        .timeline .tags.dbevent {
            width: 150px;
        }
        .timeline .block.dbevent-block {
            margin: 0 0 0 180px;
        }
        .img-circle.profile_img.dbimg {
            width: 180%;
            margin-left: 50%;
        }
        .nav.side-menu>li {
            line-height: 50px;
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

                <div class="col-md-5 col-md-offset-1">
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

                                    <div class="alert alert-success alert-dismissible fade in" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                                        </button>
                                        <strong>Holy guacamole!</strong> Best check yo self, you're not looking too good.
                                    </div>
                                    <div class="alert alert-info alert-dismissible fade in" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                                        </button>
                                        <strong>Holy guacamole!</strong> Best check yo self, you're not looking too good.
                                    </div>
                                    <div class="alert alert-warning alert-dismissible fade in" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                                        </button>
                                        <strong>Holy guacamole!</strong> Best check yo self, you're not looking too good.
                                    </div>
                                    <div class="alert alert-danger alert-dismissible fade in" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                                        </button>
                                        <strong>Holy guacamole!</strong> Best check yo self, you're not looking too good.
                                    </div>

                                </div>
                            </div>
                        </div>


                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Lớp học</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li style="font-size: 21px;margin-left: 40px;"><i class="fa fa-book"></i></a>
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
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Sự kiện sắp diễn ra</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><button type="button" class="btn btn-round btn-success">Ngày</button></li>
                                <li><button type="button" class="btn btn-round btn-success">Tuần</button></li>
                                <li><button type="button" class="btn btn-round btn-success">Tháng</button></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <ul class="list-unstyled timeline">
                                <li>
                                    <div class="block dbevent-block">
                                        <div class="tags dbevent">
                                            <a href="" class="tag">
                                                <span>Hiến máu nhân đạo</span>
                                            </a>
                                        </div>
                                        <div class="block_content">
                                            <h2 class="title">
                                                <a>Nhà thờ hòa khánh</a>
                                            </h2>
                                            <div class="byline">
                                                <span>10 phút nữa</span>
                                            </div>
                                            <p class="excerpt">Hãy tham gia ngay đi các con giời.</p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="block dbevent-block">
                                        <div class="tags dbevent">
                                            <a href="" class="tag">
                                                <span>Tiếp sức mùa thi</span>
                                            </a>
                                        </div>
                                        <div class="block_content">
                                            <h2 class="title">
                                                <a>Nhà thờ hòa khánh</a>
                                            </h2>
                                            <div class="byline">
                                                <span>10 phút nữa</span>
                                            </div>
                                            <p class="excerpt">Hãy tham gia ngay đi các con giời.</p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="block dbevent-block">
                                        <div class="tags dbevent">
                                            <a href="" class="tag">
                                                <span>Khám chữa bệnh</span>
                                            </a>
                                        </div>
                                        <div class="block_content">
                                            <h2 class="title">
                                                <a>Nhà thờ hòa khánh</a>
                                            </h2>
                                            <div class="byline">
                                                <span>10 phút nữa</span>
                                            </div>
                                            <p class="excerpt">Hãy tham gia ngay đi các con giời.</p>
                                        </div>
                                    </div>
                                </li>
                            </ul>

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
    var streamLink="<c:out value="${streamLink}"></c:out>"
    var streamCode="<c:out value="${streamCode}"></c:out>"
</script>

<script src="<c:url value="/resources/js/stream.js"/>"></script>
</body>
</html>


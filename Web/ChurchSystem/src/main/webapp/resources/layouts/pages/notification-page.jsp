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

    <title>Notification</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/notification.css"/>" rel="stylesheet">


</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="col-md-8 col-md-offset-2">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Thông báo của bạn</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="list-unstyled noti">
                                <div class="block col-md-12">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="img-size"><img src="<c:url value="/resources/img/ava.jpg"/>"
                                                                       class="full-size"/></div>
                                        </div>
                                        <div class="col-md-9">
                                            <div>
                                                <div class="col-md-9 name">Nhà thờ Chánh Tòa</div>
                                                <div class="col-md-3 time">4 tháng 7 lúc 22:20</div>
                                            </div>
                                            <div class="col-md-12 message">
                                                Nhà thờ đang có sự kiện cho lễ phục sinh. Bạn có muốn xem live
                                                stream sự kiện ?
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <button class="col-md-12 btn btn-primary">Go</button>
                                            <button class="col-md-12 btn btn-default">Cancel</button>
                                        </div>
                                    </div>
                                </div>
                                <c:forEach items="${notificationList}" var="item">
                                    <div class="block col-md-12">
                                        <div class="row">
                                            <div class="col-md-1">
                                                <div class="img-size">
                                                    <c:choose>
                                                        <c:when test="${item.avatar eq null}">
                                                            <img src="<c:url value="/resources/img/noimagefound.jpg"/>"
                                                                 class="full-size"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="${pageContext.request.contextPath}/product-images/${item.avatar}"
                                                                 class="full-size"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="col-md-11">
                                                <div>
                                                    <div class="col-md-9 name">${item.sender}</div>
                                                    <div class="col-md-3 time">${item.time}</div>
                                                </div>
                                                <div class="col-md-12 message">
                                                        ${item.information}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
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

<c:import url="/resources/layouts/common/footer.jsp"/>

</body>
</html>
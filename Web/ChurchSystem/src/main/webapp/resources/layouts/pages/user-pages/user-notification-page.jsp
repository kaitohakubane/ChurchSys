<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 9:45 PM
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
    <link href="<c:url value="/resources/css/user-notification.css"/>" rel="stylesheet">
</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<%--<c:import url="/resources/layouts/user-common/vertical-navbar.jsp"/>--%>
<!-- church-info -->

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2" style="margin-top: 50px;">
            <div class="row">
                <div class="col-md-12">
                    <h3>Thông báo của bạn</h3>
                    <hr>
                </div>
                <c:forEach items="${notificationList}" var="item">
                <div class="block">
                    <a href="${pageContext.request.contextPath}${item.link}">
                    <div class="col-md-12" >
                        <div class="col-md-1">
                            <div class="img-size"><c:choose>
                                <c:when test="${item.avatar eq null}">
                                    <img src="<c:url value="/resources/img/noimagefound.jpg"/>"
                                         class="img-full"/>
                                </c:when>
                                <c:otherwise>
                                    <img src="${pageContext.request.contextPath}/product-images/${item.avatar}"
                                         class="img-full"/>
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </div>
                        <div class="col-md-11">
                            <p style="font-size: 95%;"><strong>${item.sender}</strong>${item.information}. Hãy tham gia ngay</p>
                            <p style="font-size: 80%;color: #b8b8b8">${item.time}</p>
                        </div>
                        <div class="col-md-12 divice"></div>
                    </div>
                    </a>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<!-- end church info -->
<!-- page content -->

<!-- end page content -->
<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script src="<c:url value="/resources/js/church.js"/>"></script>
</body>
</html>

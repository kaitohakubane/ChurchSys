<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 9/1/2017
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Manager contact page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/manager-contact-page.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <%--Content    --%>

        <div class="right_col" role="main">
            <div class="">
                <div class="clearfix"></div>

                <div class="container">
                    <div class="row">

                        <div class="col-md-3">
                            <div class="list-heading">
                                <p>Danh sách liên lạc</p>
                            </div>
                            <div class="conversationsList">

                                <ul class="list-chatter">
                                    <c:if test="${ not empty chatter}">
                                        <li class="chatter" id="${chatter.accountId}" data-name="${chatter.userName}"><a
                                                href="#">
                                            <div class="user-photo"><img src="${pageContext.request.contextPath}/resources/img/user.png"></div>
                                            <div class="name"><span>${chatter.userName}</span></div>
                                        </a></li>
                                    </c:if>
                                </ul>
                            </div>

                            <div class="list-bottom">
                            </div>
                        </div>

                        <div class="col-md-6">

                            <div class="chatter-info">
                                <div class="chatter-image">
                                    <img src="${pageContext.request.contextPath}/resources/img/user.png">
                                </div>

                                <div class="chatter-name">
                                    <span id="chattingUser"></span>
                                </div>
                            </div>

                            <div class="chatbox">
                                <div class="chatlogs">

                                </div>
                            </div>

                            <div class="chat-form">
                                <textarea name="" id="chatInput"></textarea>
                                <button id="sendBtn"><i class="fa fa-paper-plane" aria-hidden="true">
                                    <div>Gửi</div>
                                </i></button>
                            </div>

                        </div>

                        <div class="col-md-3">

                            <div class="list-heading">
                                <p>Thông tin người liên lạc</p>
                            </div>

                            <div class="quick-info">
                                <!-- menu profile quick info -->
                                <div class="profile clearfix">
                                    <div class="profile_pic">
                                        <img src="${pageContext.request.contextPath}/resources/img/user.png" class="img-circle profile_img dbimg">
                                    </div>
                                </div>
                                <!-- /menu profile quick info -->

                                <br/>

                                <div id="sidebar-user" class="main_menu_side hidden-print main_menu">
                                    <ul class="nav side-user">

                                        <li class="col-md-12">
                                            <div class="row">
                                                <p class="col-md-4 col-md-offset-1"><b>Tên:</b></p>
                                                <p class="col-md-7" id="informationName"></p>
                                            </div>
                                        </li>

                                        <li class="col-md-12">
                                            <div class="row">
                                                <p class="col-md-4 col-md-offset-1"><b>Điện thoại:</b></p>
                                                <p class="col-md-7" id="informationPhone"></p>
                                            </div>
                                        </li>

                                        <li class="col-md-12">
                                            <div class="row">
                                                <p class="col-md-4 col-md-offset-1"><b>Email:</b></p>
                                                <p class="col-md-7" id="informationMail"></p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="list-bottom">
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>

        <%--Content end--%>
        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>
<script>
    var managerId =${userId};
    var isChat = true;
</script>
<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/js/manager-contact-page.js"/>"></script>

</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 9/5/2017
  Time: 10:41 AM
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
    <title>Lecture Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>

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
    <div class="row">
        <div class="col-md-4">
            <div class="list-heading-lecture">
                <p>Danh sách bài giảng</p>
            </div>
            <div class="lecture-list">
                <ul class="list-lecture-name">
                        <c:forEach items="${lecturelist}" var="temp">
                            <ul class="nav nav-list tree">
                                <li style="font-size: 20px;"><a href="#" class="lectureId" data-id="${temp.lectureId}" data-title="${temp.title}"
                                       data-link="${temp.linkvideo}">
                                    <i class="fa fa-book" aria-hidden="true"></i> ${temp.title}
                                </a></li>
                            </ul>
                        </c:forEach>
                </ul>
            </div>

            <div class="list-bottom">
            </div>
        </div>

        <div class="col-md-8">
            <div class="lecture">
                <div class="lecture-name">
                    <p id="contentTitle">Vui lòng chọn bài giảng</p>
                </div>
                <div class="lecture-content">
                    <div class="videoWrapper-lecture">
                        <iframe id="youtubeVideo" width="480" height="360"
                                frameborder="0" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="list-bottom">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->
<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<script src="<c:url value="/resources/js/church.js"/>"></script>

<script src="<c:url value="/resources/js/lecture.js"/>"></script>
</body>
</html>

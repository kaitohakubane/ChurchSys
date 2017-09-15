<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 9/5/2017
  Time: 10:36 AM
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
    <title>Lesson Page</title>
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
                <div class="list-heading-lesson">
                    <p>Danh sách bài học</p>
                </div>

                <div class="lesson-list">
                    <c:forEach items="${categoryList}" var="item">
                        <ul class="nav nav-list">
                            <li class="subject-name"><label class="tree-toggle nav-header">
                                <i class="fa fa-th-list" aria-hidden="true"></i> ${item.categoryName}
                            </label>
                                <c:forEach items="${lesson}" var="temp">
                                    <c:if test="${item.categoryId == temp.categoryId}">
                                        <ul class="nav nav-list tree">
                                            <li><a href="#" class="lessonId"  data-id="${temp.lessonId}" data-title="${temp.title}" data-content="${temp.description}">
                                                <i class="fa fa-book" aria-hidden="true"></i> ${temp.title}
                                            </a></li>
                                        </ul>
                                    </c:if>
                                </c:forEach>
                            </li>
                        </ul>
                    </c:forEach>

                </div>

                <div class="list-bottom">
                </div>
            </div>
            <div class="col-md-8">
                <div class="lesson" id="lessonId">
                        <div class="lesson-name" >
                            <p id="contentTitle">Vui lòng chọn bài học</p>
                        </div>
                        <div class="lesson-content">
                            <span id="contentDesciption"></span>
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

<script src="<c:url value="/resources/js/lesson.js"/>"></script>
</body>
</html>

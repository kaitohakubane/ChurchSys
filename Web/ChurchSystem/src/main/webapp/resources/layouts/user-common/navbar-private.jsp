<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/11/2017
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<div class="col-md-12">
    <div class="nav-private">
        <ul class="ul-private">
            <li><a href="${pageContext.request.contextPath}/church/info?churchId=${param.churchId}">Giới thiệu</a></li>
            <li><a href="${pageContext.request.contextPath}/church?churchId=${param.churchId}">Tin tức</a></li>
            <li><a href="${pageContext.request.contextPath}/church/schedule?churchId=${param.churchId}">Sự kiện</a></li>
            <li><a href="${pageContext.request.contextPath}/church/class?churchId=${param.churchId}">Lớp giáo lý</a></li>
            <li class="dropdown list-category">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    </i>Học giáo lý <i class="fa fa-caret-down" aria-hidden="true"></i>
                </a>
                <ul class="dropdown-menu mega-dropdown-menu online" style="min-width: 128px">
                    <li><a href="#">Bài học</a></li>
                    <li><a href="#">Bài giảng</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/church/pray?churchId=${param.churchId}">Cầu nguyện</a></li>
            <li><a href="${pageContext.request.contextPath}/church/contact?churchId=${param.churchId}">Liên hệ</a></li>
            <li><a href="${pageContext.request.contextPath}/church/donation?churchId=${param.churchId}">Đóng góp</a></li>
            <li><a href="${pageContext.request.contextPath}/church/grave?churchId=${param.churchId}">Phòng tro cốt</a></li>
        </ul>
    </div>
</div>
<div class="col-md-12"><div class="border-top"></div></div>
</html>

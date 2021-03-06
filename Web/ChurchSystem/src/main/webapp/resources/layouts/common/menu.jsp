<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 5/31/2017
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${pageContext.request.contextPath}/index" class="site_title"><span>Church Online System</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_info">
                <span>Welcome</span>
                <%--<h2>Hung Mai</h2>--%>
            </div>
            <div class="clearfix"></div>
        </div>
        <!-- /menu profile quick info -->

        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <sec:authentication property="principal.authorities" var="authorities"/>
                    <c:if test="${fn:contains(authorities, 'ROLE_MANAGER')}">
                        <li><a href="${pageContext.request.contextPath}/index"><i class="fa fa-university"></i>Trang chủ</a>
                        </li>

                        <li><a href="${pageContext.request.contextPath}/manager/schedule"><i class="fa fa-calendar"></i>
                            Lịch sự kiện</a></li>
                        <li><a href="${pageContext.request.contextPath}/manager/priest-management"><i
                                class="fa fa-users"></i> Quản lí thành viên nhà thờ</a></li>
                        <li><a href="${pageContext.request.contextPath}/manager/room-management"><i
                                class="fa fa-cube"></i> Quản lí phòng</a></li>
                        <li><a href="${pageContext.request.contextPath}/manager/grave"><i class="fa fa-braille"></i>Quản
                            lý phòng tro cốt</a></li>
                        <li><a href="${pageContext.request.contextPath}/manager/registration-management"><i
                                class="fa fa-newspaper-o"></i>Quản lý đơn đăng ký</a></li>
                        <li><a id="streamOption"><i class="fa fa-video-camera"></i> Stream</a></li>
                        <li><a href="${pageContext.request.contextPath}/manager/lesson-management"><i class="fa fa-book"></i> Quản lý bài học</a></li>
                        <li><a href ="${pageContext.request.contextPath}/manager/lecture-management"><i class="fa fa-file-video-o"></i> Quản lý bài giảng</a></li>
                        <li><a href ="${pageContext.request.contextPath}/manager/contact"><i class="fa fa-commenting"></i> Liên hệ giáo dân</a></li>
                    </c:if>
                    <c:if test="${!fn:contains(authorities, 'ROLE_MANAGER')}">
                        <li><a href="${pageContext.request.contextPath}/admin/church-management"><i
                                class="fa fa-home"></i>
                            Quản lí nhà thờ</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout"
               href="${pageContext.request.contextPath}/logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                       aria-expanded="false">
                        <sec:authentication var="principal" property="principal"/>
                        <c:choose>
                            <c:when test="${principal ne 'anonymousUser'}">
                                ${principal.username}
                            </c:when></c:choose>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="javascript:;"> Thông Tin</a></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/church/setting">
                                <span>Cài Đặt</span>
                            </a>
                        </li>
                        <li><a href="javascript:;">Giúp đỡ</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout"><i
                                class="fa fa-sign-out pull-right"></i>Thoát</a></li>
                    </ul>
                </li>

                <li role="presentation" class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown"
                       aria-expanded="false">
                        <i class="fa fa-envelope-o"></i>
                        <span id="numberOfNoti" class="badge bg-green"></span>
                    </a>
                    <ul id="notification" class="dropdown-menu list-unstyled msg_list" role="menu"
                        style="max-height: 350px;overflow: auto">
                        <li>
                            <div class="text-center">
                                <a href="${pageContext.request.contextPath}/manager/notifications">
                                    <strong>Xem tất cả</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>

                <li role="presentation" class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown"
                       aria-expanded="false">
                        <i class="fa fa-commenting-o"></i>
                        <span id="numberOfMessage" class="badge bg-green"></span>
                    </a>
                    <ul id="message" class="dropdown-menu list-unstyled msg_list" role="menu"
                        style="max-height: 350px;overflow: auto">
                    </ul>
                </li>

            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->


</html>

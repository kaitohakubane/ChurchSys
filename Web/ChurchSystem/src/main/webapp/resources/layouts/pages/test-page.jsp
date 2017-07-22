<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 5/31/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>

    <link href="<c:url value="/resources/lib/gridDist/gridstack.css"/>" rel="stylesheet">
    <style type="text/css">
        .grid-stack {
            background: lightgoldenrodyellow;
        }

        .sonic {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            -webkit-transform: translate(-50%, -50%);
        }

        .grid-stack-item-content {
            color: #2c3e50;
            text-align: center;
            background-color: #18bc9c;
        }

        .grid-stack .grid-stack {
            /*margin: 0 -10px;*/
            background: rgba(255, 255, 255, 0.3);
        }

        .grid-stack .grid-stack .grid-stack-item-content {
            background: lightpink;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%--Content    --%>

        <%--<div>--%>
            <%--<a class="btn btn-default" id="save-grid" href="#">Save Grid</a>--%>
            <%--<a class="btn btn-default" id="clear-grid" href="#">Clear Grid</a>--%>
            <%--<a class="btn btn-default" id="add-room" href="#">Add Room</a>--%>
            <%--<a class="btn btn-default" id="add-cabinet" href="#">Add Cabinet</a>--%>
        <%--</div>--%>
        <%--<div class="grid-stack room">--%>
            <%--<div class="grid-stack-item" data-gs-x="4" data-gs-y="0" data-gs-width="4" data-gs-height="4">--%>
                <%--<div class="grid-stack-item-content">--%>

                    <%--<div class="grid-stack cabinet">--%>
                        <%--<div class="grid-stack-item" data-gs-x="0" data-gs-y="0" data-gs-width="3" data-gs-height="1">--%>
                            <%--<div class="grid-stack-item-content">1</div>--%>
                        <%--</div>--%>
                        <%--<div class="grid-stack-item" data-gs-x="3" data-gs-y="0" data-gs-width="3" data-gs-height="1">--%>
                            <%--<div class="grid-stack-item-content">2</div>--%>
                        <%--</div>--%>
                        <%--<div class="grid-stack-item" data-gs-x="6" data-gs-y="0" data-gs-width="3" data-gs-height="1">--%>
                            <%--<div class="grid-stack-item-content">3</div>--%>
                        <%--</div>--%>
                        <%--<div class="grid-stack-item" data-gs-x="9" data-gs-y="0" data-gs-width="3" data-gs-height="1">--%>
                            <%--<div class="grid-stack-item-content">4</div>--%>
                        <%--</div>--%>

                        <%--<div class="grid-stack-item" data-gs-x="0" data-gs-y="1" data-gs-width="3" data-gs-height="1">--%>
                            <%--<div class="grid-stack-item-content">5</div>--%>
                        <%--</div>--%>
                        <%--<div class="grid-stack-item" data-gs-x="3" data-gs-y="1" data-gs-width="3" data-gs-height="1">--%>
                            <%--<div class="grid-stack-item-content">6</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<textarea id="saved-data" cols="100" rows="20" readonly="readonly"></textarea>--%>

        <%--Content end--%>
        <button id="dm"> DMM SSSSSSSSSSSSSSSSSS</button>
    </div>
</div>


<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/lodash.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.jQueryUI.js"/>"></script>
<script src="<c:url value="/resources/js/test.js"/>"></script>


</body>
</html>

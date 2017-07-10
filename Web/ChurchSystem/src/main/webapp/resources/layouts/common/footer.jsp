<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 5/31/2017
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jQuery -->
<script src="<c:url value="/resources/lib/vendors/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap -->
<script src="<c:url value="/resources/lib/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value="/resources/lib/vendors/fastclick/lib/fastclick.js"/>"></script>
<!-- NProgress -->
<script src="<c:url value="/resources/lib/vendors/nprogress/nprogress.js"/>"></script>
<!-- Custom Theme Scripts -->
<script src="<c:url value="/resources/lib/build/js/custom.min.js"/>"></script>
<script src="<c:url value="/resources/lib/external/stomp.min.js"/>"></script>
<script src="<c:url value="/resources/lib/external/sockjs-0.3.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/common.js"/>"></script>
<script>
    function connect() {

        // Create and init the SockJS object
        var socket = new SockJS('<c:url value='/ws'/>');

        var stompClient = Stomp.over(socket);

        // Subscribe the '/notify' channell
        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/user/queue/notify', function (notification) {
                console.log(notification);
                // Call the notify function when receive a notification
                notify(JSON.parse(notification.body).content, JSON.parse(notification.body).type,
                        JSON.parse(notification.body).link);

            });
        });

        return;
    } // function connect
    connect();
</script>



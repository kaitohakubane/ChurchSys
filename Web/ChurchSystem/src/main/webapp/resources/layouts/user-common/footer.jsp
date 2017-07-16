<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jQuery -->
<script src="<c:url value="/resources/lib/vendors/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap -->
<script src="<c:url value="/resources/lib/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
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
                notify(JSON.parse(notification.body).information, JSON.parse(notification.body).link
                        ,JSON.parse(notification.body).time,JSON.parse(notification.body).sender);

            });
        });

        return;
    } // function connect
    connect();
</script>

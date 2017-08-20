/**
 * Created by hungmcse61561-admin on 6/20/2017.
 */

var LOAD_PUBLIC_EVENT_REGISTER_URL = "/church/" + churchId + "/schedule/load-event/";
var ADD_REGISTRATION = "/user/registration/Add";
var eventList = [];
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;
var eventList = [];
var defaultMovePlus = 10;
var defaultStartTime = "15:00";
$(document).ready(function(){
    terminateEventMenu()
    generalIntial();

})
loadEvent();
calendarInitial();
var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');


function calendarInitial() {
    $('#calendar').fullCalendar({
        locale: 'vi',
        header: {
            right: 'today,agendaDay,month',
            left: 'prev,next',
            center: 'title'
        },
        views: {
            agendaDay: {
                minTime: '04:30:00',
                maxTime: '21:00:00',
                slotDuration: '01:30:00',
                snapDuration: '01:30:00',
                allDaySlot: false,
                selectable: true,
            }
        },
        select: function (start, end, jsEvent, view) {
            var popup = $('#eventCreator')
            var startTime = start.format("HH:mm");
            clearEventCreatorMenu(startTime);
            eventRegisterPopup(jsEvent, popup);
        },
        dayClick: function (date, jsEvent, view) {
            clearEventCreatorMenu(defaultStartTime)
            if (view.name == 'month') {
                if (lastClickedDay != null) {
                    lastClickedDay.css('background-color', '#ffffff')
                }

                var popup = $('#eventCreator')
                eventRegisterPopup(jsEvent, popup);
                if (date.format() != today) {
                    $(this).css('background-color', '#fcf2b3');
                    lastClickedDay = $(this);
                }
            } else {

            }

            creatingEvent = {
                start: date.format() + 'T04:30',
                privacy: 1
            }
        },
        eventClick: function (event, jsEvent, view) {
            if (lastClickedEvent != null) {
                lastClickedEvent.css('background-color', lastEventColor);
            }

            console.log($(this));
            if ($(this) != lastClickedEvent) {
                lastEventColor = $(this).css('background-color');
                $(this).css('background-color', '#f9a004');
                lastClickedEvent = $(this);
            }
            var popup = $('#eventDetailPopup');
            inputEventPopupInformation(event);
            eventRegisterPopup(jsEvent, popup);
        }
        ,
        dayRender: function (date, element, view) {
            element.bind('dblclick', function () {

                $('#calendar').fullCalendar('changeView', 'agendaDay');
                $('#calendar').fullCalendar('gotoDate', date);
            });
        },

        eventLimit: true,
        slotLabelFormat: 'HH:mm',
        timeFormat: 'HH:mm'
    });

    $("#calendar").fullCalendar('addEventSource', {
        events: eventList,
        color: '#43abc9'
    })
}


function generalIntial() {
    $("#estTime").val("1");
    $("#eventRegisteredBtn").on("click", function () {
        var estTime = $("#estTime").val();
        var startTime = $('#startTime').val();
        var subId = $("#subjectId").val();
        var message = $("#messageTxt").val();
        registerEvent(creatingEvent, churchId, startTime, estTime, subId, message)
    })
}

function loadEvent() {

    var requestURL = contextPath + LOAD_PUBLIC_EVENT_REGISTER_URL;
    var requestMethod = "POST";

    $.ajax({
        url: requestURL,
        type: requestMethod,
        async: false,
        processData: false,
        dataType: 'json',
        success: function (res) {
            eventList = res;
            console.log(res)
            eventList.forEach(function (e) {
                if (e.status == 3) {
                    e.color = "#777"
                }
            })
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function registerEvent(event, churchId, startTime, estTime, subId, message) {
    var requestURL = contextPath + ADD_REGISTRATION;
    var requestMethod = "POST";
    var requestData = {
        "churchId": churchId,
        "regisStartTime": startTime,
        "estTime": estTime,
        "slotDate": event.start.split("T")[0],
        "subId": subId,
        "message": message
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        dataType: 'json',
        success: function (res) {
            $("#eventCreator").fadeOut();
            $("#notifyPopup").modal('show');
            $("#eventNameSpn").html(res.title);
            var startTime = res.start.split("T")[1];
            var endTime = res.end.split("T")[1];
            var date = res.start.split("T")[0];
            $("#timeTxt").val(startTime + " - " + endTime);
            $("#dateTxt").val(date);
            $("#messageField").val(res.description);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}


function inputEventPopupInformation(event) {
    $('#eventPopupTitle').val(event.title);
    $('#eventPopupTime').val(event.start.format('HH:mm') + " - " + event.end.format('HH:mm'));
    $('#eventPopupSubject').val(event.subName);
    $('#eventPopupConductor').val(event.conductorName);
    $('#eventPopupRoom').val(event.roomName);
    $('#eventDetailBtn').on("click", function () {
        $('#eventDetailPopup').fadeOut()
    })
}

function terminateEventMenu() {

    $(document).bind('click', function (e) {
        if ($(e.target).prop("tagName").toUpperCase() == "SMALL") {
            return;
        }

        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String)) {
            $("#eventDetailPopup").fadeOut();
            $("#eventCreator").fadeOut();
            return;
        }
        console.log(!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ))
        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#eventCreator').has(e.target).length > 0 || $('ul.ui-timepicker-list').has(e.target).length > 0)) {
            $("#eventCreator").fadeOut();
        }

        if (!(($(e.target).attr('class').toString().indexOf('fc-content') >= 0) ||
            ($('div#eventDetailPopup').has(e.target).length > 0) || ($(e.target).attr('class').toString()
                .indexOf('fc-title') >= 0) || ($(e.target).attr('class').toString().indexOf('fc-time') >= 0) || ($(e.target)
                .attr('class').toString()
                .indexOf('fc-bg') >= 0))) {
            $("#eventDetailPopup").fadeOut();

        }
    })

    $("#cancelBtn").on("click", function () {
        $("#eventCreator").fadeOut();
    })
}

function clearEventCreatorMenu(startTime) {
    $("#startTime").val(startTime);
    $("#messageTxt").val("");
}
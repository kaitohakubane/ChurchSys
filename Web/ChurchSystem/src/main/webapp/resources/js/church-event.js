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
var defaultMovePlus = 2;

terminateEventMenu()
loadEvent();
calendarInitial();
generalIntial();

var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');

function calendarInitial() {
    $('#calendar').fullCalendar({
        header: {
            right: 'today,agendaDay,month,testTimeLine',
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
        dayClick: function (date, jsEvent, view) {
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
        var startTime = "18:00:00"
        var subId = $("#subjectId").val();
        registerEvent(creatingEvent, churchId, startTime, estTime, subId)
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
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function registerEvent(event, churchId, startTime, estTime, subId) {
    var requestURL = contextPath + ADD_REGISTRATION;
    var requestMethod = "POST";
    var requestData = {
        "churchId": churchId,
        "regisStartTime": startTime,
        "estTime": estTime,
        "slotDate": event.start.split("T")[0],
        "subId": subId
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,

        success: function (res) {
            if(res==1){
                alert("SUCCESS")
            }else{
                alert("FAIL")
            }
            window.location.reload();
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
        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String ||
            $(e.target).prop("tagName") == "small")) {
            $("#eventDetailPopup").fadeOut();
            $("#eventCreator").fadeOut();
            return;
        }


        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#eventCreator').has(e.target).length > 0 || !($(e.target).attr('class').toString()
                .indexOf('fc-widget-content')))) {
            $("#eventCreator").fadeOut();
            console.log('close');
        }

        if (!(($(e.target).attr('class').toString().indexOf('fc-content') >= 0) ||
            ($('div#eventDetailPopup').has(e.target).length > 0) || ($(e.target).attr('class').toString()
                .indexOf('fc-title') >= 0) || ($(e.target).attr('class').toString().indexOf('fc-time') >= 0) || ($(e.target)
                .attr('class').toString()
                .indexOf('fc-bg') >= 0))) {
            $("#eventDetailPopup").fadeOut();

        }
    })
}


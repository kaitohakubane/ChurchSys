/**
 * Created by hungmcse61561-admin on 6/20/2017.
 */

var LOAD_PUBLIC_EVENT_REGISTER_URL = "/church/" + churchId + "/schedule/load-event/";
var eventList = [];
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;
var eventList = [];
var defaultMovePlus = 2;

loadEvent();
calendarInitial();
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
                maxTime: '22:00:00',
                slotDuration: '01:30:00',
                snapDuration: '01:30:00',
                allDaySlot: false,
                selectable: true,
            }
        },
        dayClick: function (date, jsEvent, view){

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


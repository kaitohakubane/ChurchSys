/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */

calendarInitialize();
registerClassList();

//URL
var CREATE_EVENT_URL = "/manager/eventManagement/Add";
var UPDATE_EVENT_URL = "/manager/eventManagement/Update";
var DELETE_EVENT_URL = "manager/eventManagement/Delete";

//local variable
var creatingEvent;
var calEventStatus = [];
var defaultMovePlus = 10;
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;

var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');
$(document).ready(function () {
    terminateEventCreateMenu();
    $('#createEventbtn').on('click', function () {
        $("#calendarPopup").fadeOut();
        $('#calendar').fullCalendar('renderEvent', creatingEvent);

    })


})
var isEventOverDiv = function (x, y) {

    var external_events = $('#external-events');
    var offset = external_events.offset();
    offset.right = external_events.width() + offset.left;
    offset.bottom = external_events.height() + offset.top;

    // Compare
    if (x >= offset.left
        && y >= offset.top
        && x <= offset.right
        && y <= offset.bottom) {
        return true;
    }
    return false;

}


function terminateEventCreateMenu() {

    $(document).bind('click', function (e) {
        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String)) {
            $("#calendarPopup").fadeOut();
            $("#eventDetailPopup").fadeOut();
            return;
        }

        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#calendarPopup').has(e.target).length > 0)) {
            $("#calendarPopup").fadeOut();
        }

        if (!(($(e.target).attr('class').toString().indexOf('fc-content') >= 0) ||
            ($('div#eventDetailPopup').has(e.target).length > 0)||($(e.target).attr('class').toString()
                .indexOf('fc-title')>=0)||($(e.target).attr('class').toString().indexOf('fc-time')>=0))) {
            $("#eventDetailPopup").fadeOut();
            console.log('close');
        }
    })
}


function eventRegisterPopup(e, popup) {
    var windowHeight = $(window).height() / 2;
    var windowWidth = $(window).width() / 2;
    if (e.clientY > windowHeight && e.clientX <= windowWidth) {
        popup.css("left", e.clientX + defaultMovePlus);
        popup.css("bottom", $(window).height() - e.clientY + defaultMovePlus);
        popup.css("right", "auto");
        popup.css("top", "auto");
        popup.fadeIn();
    } else if (e.clientY > windowHeight && e.clientX > windowWidth) {
        popup.css("right", $(window).width() - e.clientX + defaultMovePlus);
        popup.css("bottom", $(window).height() - e.clientY + defaultMovePlus);
        popup.css("left", "auto");
        popup.css("top", "auto");
        popup.fadeIn();
    } else if (e.clientY <= windowHeight && e.clientX <= windowWidth) {
        popup.css("left", e.clientX + defaultMovePlus);
        popup.css("top", e.clientY + defaultMovePlus);
        popup.css("right", "auto");
        popup.css("bottom", "auto");
        popup.fadeIn();
    } else {
        popup.css("right", $(window).width() - e.clientX + defaultMovePlus);
        popup.css("top", e.clientY + defaultMovePlus);
        popup.css("left", "auto");
        popup.css("bottom", "auto");
        popup.fadeIn();
    }
    console.log("show");
}

function calendarInitialize() {

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

        select: function (start, end, allDay, jsEvent, view) {
            // alert('you have clicked on this slot' + start.format());
        },

        dayClick: function (date, jsEvent, view) {

            if (view.name == 'month') {
                if (lastClickedDay != null) {
                    lastClickedDay.css('background-color', '#ffffff')
                }

                var popup = $('#calendarPopup')
                eventRegisterPopup(jsEvent, popup);
                if (date.format() != today) {
                    $(this).css('background-color', '#fcf2b3');
                    lastClickedDay = $(this);
                }
            }

            var eventName = $('#creatingEventName').val();
            var eventType = $('#eventType').val();
            if (eventName == '') {
                eventName = 'UnnamedEvent';
            }
            if (eventType == '') {
                eventType = "UndefinedType"
            }

            creatingEvent = {
                title: eventName + "  -  " + eventType,
                start: date.format() + 'T04:30',
                color: '#24ea12',
                duration: '01:30',
                subjectId: $('#eventType').data('id'),
                privacy: 1
            }

        },

        dayRender: function (date, element, view) {
            element.bind('dblclick', function () {
                $('#calendar').fullCalendar('changeView', 'agendaDay');
                $('#calendar').fullCalendar('gotoDate', date);
                $("#calendarPopup").fadeOut();
            });
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
            eventRegisterPopup(jsEvent, popup);
        },

        eventRender: function (event, element) {

        },


        drop: function (date) {
            $(this).remove();
            console.log('drop');
        },

        eventReceive: function (event) {
            console.log('event Receive')

            $('#calendar').fullCalendar('updateEvent', event);
        },

        eventDragStart: function (event, jsEvent, ui, view) {
            // Add dragging event in global var
            calEventStatus['calendar'] = '#calendar';
            calEventStatus['event_id'] = event._id;
        },
        eventDragStop: function (event, jsEvent, ui, view, revertFunc) {
            console.log('calendar 1 eventDragStop');
            if (isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
                $('#calendar').fullCalendar('removeEvents', event._id);
                var el = $("<div class='fc-event'>").appendTo('#external-events-listing').text(event.title);
                el.draggable({
                    zIndex: 999,
                    revert: true,
                    revertDuration: 0
                });
                el.data('event', {title: event.title, id: event.id, stick: true});
                registerClassList();
            }

            calEventStatus = []; // Empty
            // makeEventsDraggable();


        },
        eventDrop: function (event, delta, revertFunc, jsEvent, ui, view) {
            console.log('eventDrop')
            if (typeof event.end === 'undefined' || !event.end) {
                return;
            }
            var start = event.start.format('HH:mm');
            var end = event.end.format('HH:mm');
            if (start < '04:30' || end > '21:00' || start > end) {
                revertFunc();
                console.log('revert');
            }
        },

        events: [
            {
                title: 'event3',
                start: '2017-06-21T12:00:00',
                allDay: false // will make the time show
            },
            {
                title: 'event4',
                start: '2017-06-21T12:30:00',
                allDay: false // will make the time show
            }
        ],
        eventStartEditable: true,
        eventDurationEditable: true,
        droppable: true,
        dragRevertDuration: 0,
        eventLimit: true,
        slotLabelFormat: 'HH:mm',
        timeFormat: 'HH:mm'
    })

}


// Event drop and Drag
// function makeEventsDraggable () {
//
//     $('.fc-draggable').each(function() {
//
//         // store data so the calendar knows to render an event upon drop
//         $(this).data('event', {
//             title: $.trim($(this).text()), // use the element's text as the event title
//             stick: true, // maintain when user navigates (see docs on the renderEvent method)
//             start: "06:00",
//             duration:"01:30",
//             color: '#24ea12'
//         });
//
//         // make the event draggable using jQuery UI
//         $(this).draggable({
//             zIndex: 999,
//             revert: true,      // will cause the event to go back to its
//             revertDuration: 0  //  original position after the drag
//         });
//     });
//
// }


/* initialize the external events
 -----------------------------------------------------------------*/
function registerClassList() {
    $('#external-events .fc-event').each(function () {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
            title: $.trim($(this).text()), // use the element's text as the event title
            stick: true, // maintain when user navigates (see docs on the renderEvent method)
            start: "06:00",
            duration: "01:30",
            color: '#24ea12',
            privacy: 1
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    });
}
// -------------------------------------------


function updateEvent(event) {

    var requestURL = contextPath + CREATE_EVENT_URL;
    var requestMethod = "POST";
    var requestData = normalizeEventObject(event);
    var result = null;

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function (res) {
            console.log('success');
            result = res;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
    console.log(result);
    return result;
}

//Normaliza data for event object
function normalizeEventObject(event) {
    var normalizedEvent = {
        eventName: event.title,
        subjectId: event.subjectId,
        typeId: '',
        startDate: event.start,
        privacy: 1
    }
    return normalizedEvent;
}


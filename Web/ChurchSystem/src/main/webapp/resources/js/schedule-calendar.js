/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */
//URL

var LOAD_EVENT_REGISTER_URL = "/manager/event/load-event";

//local variable
var creatingEvent;
var calEventStatus = [];
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;
var eventList = [];
var defaultMovePlus = 2;

// Initial call -------------------------------------------------------
generalInitial();
calendarInitialize();

//---------------------------------------------------------------------


var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');
$(document).ready(function () {
    $('#createEventbtn').on('click', function () {
        $("#calendarPopup").fadeOut();
        var startTime=$("#slotNum").children(":selected").attr("id");
        var isPublic=$("#createEventPopupIsPublic").prop('checked');
        createEvent(creatingEvent,startTime,isPublic);
        // $('#calendar').fullCalendar('renderEvent', creatingEvent);
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
            var popup = $('#calendarPopup')
            popup.fadeOut();
            eventRegisterPopup(jsEvent, popup);
            console.log("show");
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
                title: eventName,
                start: date.format() + 'T04:30',
                color: '#24ea12',
                duration: '01:30',
                subjectId: $('#eventType').children(":selected").attr("id"),
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
            inputEventPopupInformation(event);
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

        eventStartEditable: true,
        eventDurationEditable: true,
        droppable: true,
        dragRevertDuration: 0,
        eventLimit: true,
        slotLabelFormat: 'HH:mm',
        timeFormat: 'HH:mm'
    })


    $("#calendar").fullCalendar('addEventSource', {
        events: eventList,
        color: '#43abc9'
    })
}


// General Initial set up for view
function generalInitial() {
    loadEvent();
    subjectDropdownEvent($('#category'));
    $('#category').change(function () {
        var firstVal = null;
        var categoryValue = $(this).val();
        $('#eventType option').each(function () {
            var item = $(this);
            if (!(item.data("category") == categoryValue)) {
                item.hide();
            } else {
                if (firstVal == null) {
                    firstVal = item.val();
                }
                item.show();
            }
        })
        $('#eventType').val(firstVal);
    })
}

function loadEvent() {

    var requestURL = contextPath + LOAD_EVENT_REGISTER_URL;
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

function subjectDropdownEvent(category) {
    var firstVal = null;
    var categoryValue = category.val();
    $('#eventType option').each(function () {
        var item = $(this);
        if (!(item.data("category") == categoryValue)) {
            item.hide();
        } else {
            if (firstVal == null) {
                firstVal = item.val();
            }
            item.show();
        }
    })
    $('#eventType').val(firstVal);
}


function createEvent(event,slotId,isPublic) {

    var requestURL = contextPath + CREATE_EVENT_URL;
    var requestMethod = "POST";
    var requestData = {
        eventTitle: event.title,
        eventDate: event.start.split("T")[0],
        subId: event.subjectId,
        slotHour: slotId,
        isPublic: isPublic
    }
    console.log(requestData)
    var result = null;

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async:false,
        processData: false,
        dataType: 'json',
        success: function (res) {
            creatingEvent = res;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}








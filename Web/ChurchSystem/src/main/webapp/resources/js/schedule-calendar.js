/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */
//URL

var LOAD_EVENT_REGISTER_URL = "/manager/event/load-event";
var CREATE_EVENT_URL = "/manager/event/Add";
var CREATE_CLASS_URL = "/manager/class/Add";

//local variable
var creatingEvent;
var calEventStatus = [];
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;
var eventList = [];
var defaultMovePlus = 2;
var listOfCreatingEvent = []
var ClassCategoryNum = 4;
var defaultTimeSlot = "04:30:00 - 06:00:00"
// Initial call -------------------------------------------------------
generalInitial();
calendarInitialize();

//---------------------------------------------------------------------


var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');
$(document).ready(function () {
    $('#createEventbtn').on('click', function () {

        var startTime = $("#slotNum").children(":selected").attr("id");
        var isPublic = $("#createEventPopupIsPublic").prop('checked');
        var policy = 0;
        if (isPublic) {
            policy = 1;
        }

        if ($("#category").children(":selected").val() == ClassCategoryNum) {
            $("#createClass").modal("show");
        } else {
            createEvent(creatingEvent, startTime, policy);
            $("#calendarPopup").fadeOut();
            listOfCreatingEvent.forEach(function (e) {
                console.log(e.status)
                if (e.status == 0) {
                    e.color = '#ef0909'
                } else {
                    e.color = '#24ea12'
                }
            })

            $('#calendar').fullCalendar('renderEvents', listOfCreatingEvent);
        }


    })

    $('#createClassbtn').on('click', function () {
        var startTime = $("#slotNum").children(":selected").attr("id");
        var isPublic = $("#createEventPopupIsPublic").prop('checked');
        var policy = 0;
        if (isPublic) {
            policy = 1;
        }
        var subId = $('#eventType').children(":selected").attr("id");
        createClass(creatingEvent, startTime, policy);
        if (listOfCreatingEvent != null) {
            $("#createClass").modal("hide");
            $("#calendarPopup").fadeOut();
            $('#external-events div').each(function () {
                if ($(this).attr('subId') == subId) {
                    $(this).remove();
                }
            })

            listOfCreatingEvent.forEach(function (e) {
                if (e.status == 0) {
                    e.color = '#ef0909'
                } else {
                    e.color = '#24ea12'
                }
            })

            $('#calendar').fullCalendar('renderEvents', listOfCreatingEvent);
        } else {

        }
    })


    $('#cancelEventbtn').on('click', function () {
        $('#calendarPopup').fadeOut(s);
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
                maxTime: '21:00:00',
                slotDuration: '01:30:00',
                snapDuration: '01:30:00',
                allDaySlot: false,
                selectable: true,
            }
        },

        select: function (start, end, jsEvent, view) {
            var popup = $('#calendarPopup')
            console.log('select')
            var startTime = start.format("HH:mm:ss");
            var endTime = end.format("HH:mm:ss")
            var timeSlot = startTime + " - " + endTime;
            clearCreatingEventPopup(timeSlot);
            eventRegisterPopup(jsEvent, popup);
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

            clearCreatingEventPopup(defaultTimeSlot);
            creatingEvent = {
                start: date.format() + 'T04:30',
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
            console.log($(this).attr("subId"))
        },

        eventReceive: function (event) {
            if (false) {
                $('#calendar').fullCalendar('updateEvent', event);
            } else {
                appendClassToList(event.subId)
            }


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

        eventResize: function (event, delta, revertFunc) {


            var start = event.start.format('HH:mm');
            var end = event.end.format('HH:mm');
            if (start < '04:30' || end > '21:00' || start > end) {
                revertFunc();
                console.log('revert');
            }

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
        eventOrder: "status",
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

function clearCreatingEventPopup(timeSlot) {
    $("#creatingEventName").val("");
    $("#category").prop("selectedIndex", 0);
    subjectDropdownEvent($("#category"))
    if (!$("#eventDetailIsPublic").prop('checked')) {
        $("#eventDetailIsPublic").click();
    }
    console.log(timeSlot);
    if (timeSlot == "") {
        timeSlot = defaultTimeSlot;
    }

    $("#slotNum").val(timeSlot);
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
            console.log(eventList);
            eventList.forEach(function (e) {

                if (e.status == 0) {
                    e.color = '#ef0909'
                }
            })

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


function createEvent(event, slotId, isPublic) {

    var requestURL = contextPath + CREATE_EVENT_URL;
    var requestMethod = "POST";
    console.log()
    var requestData = {
        eventName: $('#creatingEventName').val(),
        slotDate: event.start.split("T")[0],
        subId: $('#eventType').children(":selected").attr("id"),
        slotHour: slotId,
        privacy: isPublic
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            listOfCreatingEvent = res;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function createClass(event, slotId, isPublic) {

    var requestURL = contextPath + CREATE_CLASS_URL;
    var requestMethod = "POST";
    var requestData = {
        eventName: $('#creatingEventName').val(),
        slotDate: event.start.split("T")[0],
        subId: $('#eventType').children(":selected").attr("id"),
        slotHour: slotId,
        privacy: isPublic,
        numOfSlot: $("#numberOfSlot").val(),
        examDate: "2017-08-30",
        type: dayArray.toString()
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            listOfCreatingEvent = res;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}








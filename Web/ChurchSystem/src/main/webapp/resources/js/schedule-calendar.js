/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */
//URL
var CHECK_EVENT_URL = "/manager/event/Check";
var CHECK_CLASS_URL = "/manager/class/Check";
var LOAD_EVENT_REGISTER_URL = "/manager/event/load-event";
var CREATE_EVENT_URL = "/manager/event/Add";
var CREATE_CLASS_URL = "/manager/class/Add";
var UPDATE_DRAG_DROP_EVENT = "/manager/schedule/update-drag-drop-event"

//local variable
var creatingEvent;
var calEventStatus = [];
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;
var eventList = [];
var defaultMovePlus = 2;
var listOfCreatingEvent = []
var ClassCategoryNum = ['6', '7', '8', '9', '10', '11'];
var defaultTimeSlot = "04:30:00 - 06:00:00";

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
        if (ClassCategoryNum.includes($("#category").children(":selected").val())) {
            $("#createClass").modal("show");
        } else {
            console.log("OK");
            checkEvent(creatingEvent,startTime, policy);
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
                if (e.status == 2) {
                    e.color = '#ef0909'
                } else {
                    e.color = '#24ea12'
                }
            })

            $('#calendar').fullCalendar('addEventSource', listOfCreatingEvent);
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


        drop: function (date, jsEvent, ui, resourceId) {
            // $(this).remove();
            console.log($(this).attr("subId"));
            console.log(date.format("HH:mm:ss"));
            console.log(date.format("DD-MM-YYYY"));
        },

        eventDragStart: function (event, jsEvent, ui, view) {
            // Add dragging event in global var
            calEventStatus['calendar'] = '#calendar';
            calEventStatus['event_id'] = event._id;
        },

        eventDragStop: function (event, jsEvent, ui, view, revertFunc) {
            // console.log('calendar 1 eventDragStop');
            // if (isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
            //     $('#calendar').fullCalendar('removeEvents', event._id);
            //     var el = $("<div class='fc-event'>").appendTo('#external-events-listing').text(event.title);
            //     el.draggable({
            //         zIndex: 999,
            //         revert: true,
            //         revertDuration: 0
            //     });
            //     el.data('event', {title: event.title, id: event.id, stick: true});
            //     registerClassList();
            // }
            //
            // calEventStatus = []; // Empty
            // // makeEventsDraggable();

        },

        eventResize: function (event, delta, revertFunc) {


            var start = event.start.format('HH:mm');
            var end = event.end.format('HH:mm');
            if (start < '04:30' || end > '21:00' || start > end) {
                revertFunc();
                console.log('revert');
            } else {
                updateEventOnSchedule(event);
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
            } else {
                updateEventOnSchedule(event)
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
            console.log(res);
            eventList.forEach(function (e) {

                if (e.status == 2) {
                    e.color = '#ef0909'
                }

                if (e.eventStatus == 1) {
                    e.color = "#ff4fc1"
                }
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

function checkEvent(event,slotId, policy) {
    var requestURL = contextPath + CHECK_EVENT_URL;
    var requestMethod = "POST";
    var requestData = {
        slotDate: event.start.split("T")[0],
        subId: $('#eventType').children(":selected").attr("id"),
        slotHour: slotId,
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
            console.log(res);
            console.log(res==0);
            if (res != 0) {
                $("#confirmModal").modal("show");
                $("#process").unbind("click")
                $("#process").bind("click",function(){
                    $("#confirmModal").modal("hide");
                    createEvent(creatingEvent, slotId, policy);
                })
            }else{
                createEvent(creatingEvent, slotId, policy);
            }
            $("#calendarPopup").fadeOut();
            $('#calendar').fullCalendar('addEventSource', listOfCreatingEvent);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
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

            listOfCreatingEvent.forEach(function (e) {
                console.log(e.status)
                if (e.status == 2) {
                    e.color = '#ef0909'
                } else {
                    e.color = '#24ea12'
                }
            })
            $('#calendar').fullCalendar('addEventSource', listOfCreatingEvent);
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


function updateEventOnSchedule(event) {
    console.log(event.slotId);
    console.log(event.start.format("HH:mm:ss"))
    console.log(event.end.format("HH:mm:ss"))
    console.log(event.start.format("YYYY-MM-DD"))

    var requestURL = contextPath + UPDATE_DRAG_DROP_EVENT;
    var requestMethod = "POST";
    var requestData = {
        slotId: event.slotId,
        startTime: event.start.format("HH:mm:ss"),
        endTime: event.end.format("HH:mm:ss"),
        slotDate: event.start.format("YYYY-MM-DD")
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,

        success: function () {
            console.log("Update event on schedule success");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Update event on schedule fail!");
            console.error(textStatus);
        }
    });
}
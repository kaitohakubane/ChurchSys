/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */
//URL
var CHECK_EVENT_URL = "/manager/event/Check";
var CHECK_CLASS_URL = "/manager/class/Check";
var LOAD_EVENT_REGISTER_URL = "/manager/event/load-event";
var CREATE_EVENT_URL = "/manager/event/Add";
var CREATE_CLASS_URL = "/manager/class/Add";
var GET_EXAM_DATE = "/manager/event/Add/get-exam-date";
var UPDATE_DRAG_DROP_EVENT = "/manager/schedule/update-drag-drop-event"
var UPDATE_RESIZE_EVENT = "/manager/schedule/update-resize-event"
var CHECK_CONFLICT_FOR_DRAG_DROP_EVENT = "/manager/event/check-drag-drop-valid";
var CHECK_CONFLICT_FOR_RESIZE_EVENT = "/manager/event/check-resize-valid";
var GOOGLE_VALIDATE_URL = "/manager/google/Validate";
var CHECK_CLASS_URL = "/manager/class/Check";


var IS_AVAILABLE;

//local variable
var creatingEvent;
var token = null;
var calEventStatus = [];
var lastClickedDay = null;
var lastClickedEvent = null;
var lastEventColor = null;
var eventList = [];
var defaultMovePlus = 2;
var listOfCreatingEvent = []
var ClassCategoryNum = ['6', '7', '8', '9', '10', '11'];
var defaultTimeSlot = "04:30:00 - 06:00:00";
var eventSubId;
var currentDraggingEvent;
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
            $("#className").val($("#creatingEventName").val());
            $("#classSubject").val($("#eventType").val());
            $("#slotNumPopup").val($("#slotNum").val());
            $("#createClass").modal("show");
            eventSubId=$('#eventType').children(":selected").attr("id");

        } else {
            if (setting == "1") {
                eventSubId=$('#eventType').children(":selected").attr("id");
                validateGoogleAccount(creatingEvent, startTime, policy);
            } else {
                eventSubId=$('#eventType').children(":selected").attr("id");
                checkEvent(creatingEvent, startTime, policy,eventSubId);
            }


        }
    })

    $('#createClassbtn').on('click', function () {
        var startTime = $("#slotNum").children(":selected").attr("id");
        var isPublic = $("#createEventPopupIsPublic").prop('checked');
        var policy = 0;
        if (isPublic) {
            policy = 1;
        }
        checkClass(creatingEvent, startTime, policy,eventSubId);
    })


    $('#cancelEventbtn').on('click', function () {
        $('#calendarPopup').fadeOut();
    })
})

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
            var startTime = start.format("HH:mm:ss");
            var endTime = end.format("HH:mm:ss")
            var timeSlot = startTime + " - " + endTime;
            console.log(start>currentDateTime)
            if(start>currentDateTime){
                clearCreatingEventPopup(timeSlot);
                eventRegisterPopup(jsEvent, popup);
            }

        },

        dayClick: function (date, jsEvent, view) {
            var clickedDate=date.format();
            if(new Date(clickedDate)>=new Date(today)){
                clearCreatingEventPopup(defaultTimeSlot);
                creatingEvent = {
                    start: date.format() + 'T04:30',
                    privacy: 1
                }
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
            }

            $("#advance-create").attr("href",contextPath+"/manager/advance-create-page?date=")
            $("#advance-create").attr("href",$("#advance-create").attr("href")+date.format());

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

            if(event.eventStatus==1){
                var popup = $('#userRegister');
                inputUserEventPopup(event);
                eventRegisterPopup(jsEvent, popup);
            } else {
                var popup = $('#eventDetailPopup');
                inputEventPopupInformation(event);
                eventRegisterPopup(jsEvent, popup);
            }
        },

        drop: function (date, jsEvent, ui, resourceId) {
            creatingEvent = {
                start: date.format() + 'T04:30',
                privacy: 1
            }
            $("#className").val("");
            $("#classSubject").val($("#eventType option[id="+$(this).attr('subId')+"]").text());
            eventSubId= $(this).attr('subId');
            console.log(eventSubId);
            $("#createClass").modal('show');
        },

        eventDragStart: function (event, jsEvent, ui, view) {
            currentDraggingEvent=event.start.format();
        },

        eventResize: function (event, delta, revertFunc) {
            var start = event.start.format('HH:mm');
            var end = event.end.format('HH:mm');
            if (start < '04:30' || end > '21:00' || start > end) {
                revertFunc();
                console.log('revert');
            } else {
                checkValidResizeEvent(event)
                if (IS_AVAILABLE == 1) {
                    console.log("New time is available for whole class!")
                    updateEventOnSchedule(event)
                }
                else if (IS_AVAILABLE == 0) {
                    console.log("New time is not available for whole class!")
                    $("#confirmModal").modal("show");

                    $("#process").unbind("click")
                    $("#process").bind("click", function () {
                        $("#confirmModal").modal("hide");
                        updateEventOnSchedule(event);
                    })

                    $("#cancel").unbind("click")
                    $("#cancel").bind("click", function () {
                        $("#confirmModal").modal("hide");
                        revertFunc();
                        console.log('revert');
                    })
                }
                $('#calendar').fullCalendar('updateEvent', event);
            }

        },

        eventDrop: function (event, delta, revertFunc, jsEvent, ui, view) {
            if(new Date(currentDraggingEvent)<new Date(today)){
                revertFunc();
            }else{
                if (typeof event.end === 'undefined' || !event.end) {
                    return;
                }
                var start = event.start.format('HH:mm');
                var end = event.end.format('HH:mm');
                if (start < '04:30' || end > '21:00' || start > end) {
                    revertFunc();
                    console.log('revert');
                } else {
                    checkValidDragDropEvent(event);
                    if (IS_AVAILABLE == 1) {
                        console.log("New time is available for whole class!")
                        updateEventOnSchedule(event)
                    }
                    if (IS_AVAILABLE == 0) {
                        console.log("New time is not available for whole class!")
                        $("#confirmModal").modal("show");

                        $("#process").unbind("click")
                        $("#process").bind("click", function () {
                            $("#confirmModal").modal("hide");
                            updateEventOnSchedule(event);
                        })

                        $("#cancel").unbind("click")
                        $("#cancel").bind("click", function () {
                            $("#confirmModal").modal("hide");
                            revertFunc();
                            console.log('revert');
                        })
                    }
                    $('#calendar').fullCalendar('updateEvent', event);
                }
            }

        },
        eventConstraint: {
            start: moment().format('YYYY-MM-DD'),
            end: '2100-01-01' // hard coded goodness unfortunately
        },

        eventStartEditable: true,
        eventDurationEditable: true,
        droppable: true,
        dragRevertDuration: 0,
        eventLimit: true,
        eventOrder: "-slotId,-status",
        slotLabelFormat: 'HH:mm',
        timeFormat: 'HH:mm'
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
    $("#examDate").datepicker({changeMonth: true, changeYear: true, yearRange: "-100:+0"});
    $("#examDate").datepicker('option', 'dateFormat', 'yy-mm-dd');
    $("#numberOfSlot").on("change",function(){
        if(dayArray.length!=0&&$.isNumeric($("#numberOfSlot").val())){
            $("#examDate").val(calculateExamDate(creatingEvent,$("#numberOfSlot").val()));
        }
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
        processData: false,
        dataType: 'json',
        success: function (res) {

            eventList = res;
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

            $("#calendar").fullCalendar('addEventSource', {
                events: eventList,
                color: '#43abc9'
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

function checkEvent(event, slotId, policy,eventSub) {
    var requestURL = contextPath + CHECK_EVENT_URL;
    var requestMethod = "POST";
    var requestData = {
        slotDate: event.start.split("T")[0],
        subId: eventSub,
        slotHour: slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            var result=res;

            if (result[0] == 0 ||result[1]==0) {
                $("#confirmModal").modal("show");
                $("#process").unbind("click")
                $("#process").bind("click", function () {
                    $("#confirmModal").modal("hide");
                    createEvent(creatingEvent, slotId, policy,eventSub,result[0],result[1]);
                })
            } else {
                createEvent(creatingEvent, slotId, policy,eventSub,result[0],result[1]);
            }
            $("#calendarPopup").fadeOut();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}


function createEvent(event, slotId, isPublic,eventSub,conductorId,roomId) {
    var requestURL = contextPath + CREATE_EVENT_URL;
    var requestMethod = "POST";
    var requestData = {
        eventName: $('#creatingEventName').val(),
        slotDate: event.start.split("T")[0],
        subId: eventSub,
        slotHour: slotId,
        privacy: isPublic,
        roomId:roomId,
        conductorId:conductorId,
        token: token
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
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

function checkClass(event, slotHourId, isPublic,eventSub) {
    var examDate = $("#examDate").val();
    if (examDate == null || examDate == "") {
        examDate = "2017-09-30"
    }

    var requestURL = contextPath + CHECK_CLASS_URL;
    var requestMethod = "POST";
    var requestData = {
        slotDate: event.start.split("T")[0],
        subId: eventSub,
        slotHour: slotHourId,
        numOfSlot: $("#numberOfSlot").val(),
        examDate: examDate,
        type: dayArray.toString()
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            var result = res;
            console.log(result);
            if (result[0] != 0 && result[1] != 0) {
                $("#createClass").modal("hide");
                $("#calendarPopup").fadeOut();
                createClass(event, slotHourId, isPublic,result[0],result[1],eventSub);
            } else {
                $("#confirmModal").modal("show");
                $("#process").unbind("click")
                $("#process").bind("click", function () {
                    $("#confirmModal").modal("hide");
                    $("#createClass").modal("hide");
                    createClass(event, slotHourId, isPublic,result[0],result[1],eventSub);
                })

                $("#calendarPopup").fadeOut();
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function createClass(event, slotHourId, isPublic,conductorId,roomId,eventSub) {
    $("#loading").modal('show');
    var examDate = $("#examDate").val();
    if (examDate == null || examDate == "") {
        examDate = "2017-09-30"
    }
    var subId = eventSub;
    var requestURL = contextPath + CREATE_CLASS_URL;
    var requestMethod = "POST";
    var requestData = {
        eventName: $('#className').val(),
        slotDate: event.start.split("T")[0],
        subId: subId,
        slotHour: slotHourId,
        privacy: isPublic,
        numOfSlot: $("#numberOfSlot").val(),
        examDate: examDate,
        type: dayArray.toString(),
        conductorId:conductorId,
        roomId:roomId,
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            listOfCreatingEvent = res;
            if (listOfCreatingEvent != null) {
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
                console.log(listOfCreatingEvent);
                $('#calendar').fullCalendar('addEventSource', listOfCreatingEvent);

            }
            $("#loading").modal('hide');
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
        dataType: 'json',
        success: function (res) {
            console.log("Update event on schedule success");
            var result = res
            event.conductorName=result.conductorName;
            event.roomName=result.roomName;
            console.log(result.status);
            if(result.status == 2){
                event.color="#f44242";
            }if(result.status == 1){
                event.color="#43abc9";
            }
            $('#calendar').fullCalendar('updateEvent', event);
            console.log(event.color)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Update event on schedule fail!");
            console.error(textStatus);
        }
    });
}

function validateGoogleAccount(creatingEvent, startTime, policy) {
    var requestData = {
        "token": token
    }
    var requestMethod = "POST"
    var requestURL = contextPath + GOOGLE_VALIDATE_URL;
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            token = res;
            console.log('token');
            if (token == "-1" || token == "") {
                alert("Tài khoản google của bạn không phù hợp với setting. Vui lòng thử lại !!!");
            } else {
                    checkEvent(creatingEvent, startTime, policy,eventSubId);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}


function checkValidDragDropEvent(event) {
    var requestMethod = "POST"
    var requestURL = contextPath + CHECK_CONFLICT_FOR_DRAG_DROP_EVENT;

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
        dataType: 'json',
        success: function (res) {
            IS_AVAILABLE = res;
            console.log("Checked valid for whole class success!")
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error(textStatus);
        }
    })
}

function checkValidResizeEvent(event) {
    var requestMethod = "POST"
    var requestURL = contextPath + CHECK_CONFLICT_FOR_RESIZE_EVENT;

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
        dataType: 'json',
        success: function (res) {
            IS_AVAILABLE = res;
            console.log("Checked valid for whole class success!")

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error(textStatus);
        }
    })
}

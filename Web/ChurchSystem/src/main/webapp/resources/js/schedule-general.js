/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */

var UPDATE_EVENT_URL = "/manager/event/Update";
var DELETE_EVENT_URL = "/manager/event/Delete";
var REGISTER_STREAM_URL = "/manager/stream/Register"
var GET_USER_REGISTRATION = "/manager/registration/GetInformation";
var STREAM_URL = "/manager/stream";
var CHECK_IS_MANY_SLOT = "/manager/event/check-is-many-slot";
var SCHEDULE_URL = "/manager/schedule";
// var REMOVE_EVENT = "/manager/schedule/remove-event";
var REMOVE_SINGLE_SLOT = "/manager/schedule/remove-single-slot";
var ACCEPT_REGISTRATION_URL = "/manager/registration/Accept";
var REJECT_REGISTRATION_URL = "/manager/registration/Reject";
var REMOVE_MULTI_SLOT = "/manager/schedule/remove-multi-slot";
var UPDATE_NAME_AND_PRIVACY = "/manager/schedule/update-name-privacy";
var STREAM_EVENT = "/manager/stream/UpdateEvent"

var dayArray = [];
var streamResolutionDefault = "240p"
var workingEvent;
var currentEventIsMultiSlot;
var curSlotId;

var REGISTER_SUCCESS_STATUS = "Đăng ký thành công!";
var REGISTER_FAILURE_STATUS = "Đăng ký thất bại";
var EDIT_SUCCESS_STATUS = "Cập nhật thành công!";
var EDIT_FAILURE_STATUS = "Cập nhật thất bại!";
var ERROR_STATUS = "Có lỗi xảy ra!"
var REMOVE_SUCCESS_STATUS = "Xóa thành công!";
var REMOVE_FAILURE_STATUS = "Xóa thất bại";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";


//
classListInitial();
registerClassList();
datePickerLoad();
$(document).ready(function () {
    terminateEventCreateMenu();
    $('.day-checkbox').on('ifChecked', function (event) {
        dayArray.push(event.target.id)
        dayArray.sort(function (a, b) {
            return a - b;
        })
        if(dayArray.length!=0&&$.isNumeric($("#numberOfSlot").val())){
            $("#examDate").val(calculateExamDate(creatingEvent,$("#numberOfSlot").val()));
        }

        console.log(dayArray)
    });

    $('.day-checkbox').on('ifUnchecked', function (event) {
        var index = dayArray.indexOf(event.target.id);
        if (index > -1) {
            dayArray.splice(index, 1);
        }
        if(dayArray.length!=0&&$.isNumeric($("#numberOfSlot").val())){
            $("#examDate").val(calculateExamDate(creatingEvent,$("#numberOfSlot").val()));
        }
    });


    $("#createStreambtn").on("click", function () {
        streamRegister($(this).data("id"), $("#resolution").val())
        $("#resolution").val(streamResolutionDefault);
        $("#registration").modal('hide');
    })
})


//--------------------------------Function-------------------------------


/* set attribute for event on drag table */
function registerClassList() {
    $('#external-events .fc-event').each(function () {
        // store data so the calendar knows to render an event upon drop
        // $(this).data('event', {
        //     title: $.trim($(this).text()), // use the element's text as the event title
        //     stick: true, // maintain when user navigates (see docs on the renderEvent method)
        //     start: "06:00",
        //     duration: "01:30",
        //     color: '#24ea12',
        //     subId: $(this).attr('subId'),
        //     privacy: 1
        // });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    })
}

function inputUserEventPopup(event) {
    $('#userSlotHour').val(event.start.format('HH:mm') + " - " + event.end.format('HH:mm'));
    $('#userSubject').val(event.subName);
    getRegistrationInfo(event.slotId);
    $("#acceptBtn").unbind("click")
    $('#acceptBtn').bind("click", function () {
        acceptRegistration(event);
        $("#userRegister").fadeOut();
    })

    $("#rejectBtn").unbind("click");
    $('#rejectBtn').bind("click", function () {
        rejectRegistration(event);
        $("#userRegister").fadeOut();
    })
}

function inputEventPopupInformation(event) {
    $('#eventPopupTitle').val(event.title);
    $('#eventPopupTime').val(event.start.format('HH:mm') + " - " + event.end.format('HH:mm'));
    $('#eventPopupSubject').val(event.subName);
    $('#eventPopupConductor').val(event.conductorName);
    $('#eventPopupRoom').val(event.roomName);
    var streamBtn = $("#streamBtn");
    console.log(event.streamLink)
    console.log(event.isStream=='0');
    if (event.streamLink != null && event.isStream == '0') {
        if (streamBtn.attr("class").includes("btn-success")) {
            streamBtn.removeClass("btn-success");

        }
        if(streamBtn.attr("class").includes("btn-dark")){
            streamBtn.removeClass("btn-dark")
        }
        streamBtn.addClass("btn-danger")
        streamBtn.unbind("click");
        streamBtn.on("click", function (e) {
            e.preventDefault();
            streamEvent(event.slotId);
            var parameter = {
                streamLink: event.streamLink,
                streamCode: event.streamCode,
                streamTitle: event.title
            }
            post(contextPath + STREAM_URL, parameter)
        })

    }
    else if (event.isStream=='1') {
        if (streamBtn.attr("class").includes("btn-success")) {
            streamBtn.removeClass("btn-success");

        }
        if(streamBtn.attr("class").includes("btn-danger")){
            streamBtn.removeClass("btn-danger")
        }
        streamBtn.addClass("btn-dark");
        streamBtn.unbind("click");
    }
    else {
        if (streamBtn.attr("class").includes("btn-dark")) {
            streamBtn.removeClass("btn-dark");

        }
        if(streamBtn.attr("class").includes("btn-danger")){
            streamBtn.removeClass("btn-danger")
        }
        streamBtn.addClass("btn-success")
        streamBtn.unbind("click");
        streamBtn.on("click", function (e) {
            $("#registration").modal('show');
            $("#createStreambtn").data('id', event.slotId);
        })
    }
    if (event.privacy == 0) {
        if ($("#eventDetailIsPublic").prop('checked')) {
            console.log($("#eventDetailIsPublic").prop('checked'));
            $("#eventDetailIsPublic").click();

            console.log('Click')
        }
    } else {
        if (!$("#eventDetailIsPublic").prop('checked')) {
            $("#eventDetailIsPublic").click();
        }
    }

    $("#editSlotButton").on("click", function () {
        var parameter = {
            slotId: event.slotId
        }
        post(contextPath + UPDATE_EVENT_URL, parameter);
    })


    $("#btnRemove").unbind("click")
    $("#btnRemove").bind("click", function () {
        checkIsManySlot(event);
        curSlotId = event.slotId;
        console.log("Selected slot ID is: " + curSlotId);
        console.log("Removing slot with ID = " + curSlotId);

        if (currentEventIsMultiSlot == 1) {
            console.log("Selected slot has multi slot");
            $('#confirmDelete').modal('show');
            $("#oneSlot").unbind("click")
            $("#oneSlot").bind("click", function () {
                console.log("Option remove one slot is selected");
                removeSingleSlot(event);
                $('#confirmDelete').modal('hide');
            })

            $("#allSlot").unbind("click")
            $("#allSlot").bind("click", function () {
                console.log("Option remove many slot is selected");
                removeMultiSlot(curSlotId);
                $('#confirmDelete').modal('hide');
            })
        }
        else if (currentEventIsMultiSlot == 0) {
            console.log("Selected slot has one slot");
            removeSingleSlot(event);
        }
    })
    $("#btnSave").unbind("click")
    $("#btnSave").bind("click", function () {
        editEventNameAndPrivacy(event);
    })


}


function terminateEventCreateMenu() {

    $(document).bind('click', function (e) {
        if ($(e.target).prop("tagName").toUpperCase() == "SMALL") {
            return;
        }

        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String
            )) {
            $("#calendarPopup").fadeOut();
            $("#eventDetailPopup").fadeOut();
            $("#userRegister").fadeOut();
            return;
        }
        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#calendarPopup').has(e.target).length > 0 || !($(e.target).attr('class').toString()
                .indexOf('fc-widget-content')))) {
            $("#calendarPopup").fadeOut();
        }

        if (!(($(e.target).attr('class').toString().indexOf('fc-content') >= 0) ||
            ($('div#eventDetailPopup').has(e.target).length > 0) || ($(e.target).attr('class').toString()
                .indexOf('fc-title') >= 0) || ($(e.target).attr('class').toString().indexOf('fc-time') >= 0) || ($(e.target)
                .attr('class').toString()
                .indexOf('fc-bg') >= 0))) {
            $("#eventDetailPopup").fadeOut();
        }

        if (!(($(e.target).attr('class').toString().indexOf('fc-content') >= 0) ||
            ($('div#userRegister').has(e.target).length > 0) || ($(e.target).attr('class').toString()
                .indexOf('fc-title') >= 0) || ($(e.target).attr('class').toString().indexOf('fc-time') >= 0) || ($(e.target)
                .attr('class').toString()
                .indexOf('fc-bg') >= 0))) {
            $("#userRegister").fadeOut();
        }
    })
}


/* initialize the external events*/
function classListInitial() {
    classList.forEach(function (item) {
        var classTab = document.createElement('div');
        classTab.className = "fc-event";
        classTab.setAttribute('subId', item[0]);
        classTab.textContent = item[1] + ": " + item[2];
        $('#external-events-listing').append(classTab);

    })
}

function datePickerLoad() {
    $("#datepicker").datepicker();
    $("#datepicker").datepicker('option', 'dateFormat', 'yy-mm-dd');
}


function streamRegister(slotId, resolution) {
    var requestURL = contextPath + REGISTER_STREAM_URL;
    var requestMethod = "POST";
    var requestData = {
        "slotId": slotId,
        "resolution": resolution
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,

        data: requestData,
        async: false,
        success: function () {
            $("#calendar").fullCalendar('removeEvents');
            loadEvent();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function streamEvent(slotId) {
    var requestURL = contextPath + STREAM_EVENT;
    var requestMethod = "POST";
    var requestData = {
        "slotId": slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function removeMultiSlot(slotId) {
    var requestURL = contextPath + REMOVE_MULTI_SLOT;
    var requestMethod = "POST";
    var requestData = {
        slotId: slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        success: function () {
            console.log("Removed many slot success!")
            onClickShowPopup(REMOVE_SUCCESS_STATUS, TYPE_SUCCESS);
            $("#calendar").fullCalendar('removeEvents');
            loadEvent();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(REMOVE_FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function checkIsManySlot(event) {
    var requestURL = contextPath + CHECK_IS_MANY_SLOT;
    var requestMethod = "POST";
    var requestData = {
        slotId: event.slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        success: function (res) {
            console.log("Checking slot with ID = " + event.slotId + " is one or many slot!");
            currentEventIsMultiSlot = res;
            if (currentEventIsMultiSlot == 1) {
                console.log("Current event is many slot");
            } else if (currentEventIsMultiSlot == 0) {
                console.log("Current event is one slot");
            } else {
                console.log("Error happen!");
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error happen!");
            console.error(textStatus);
        }
    })
}

function removeSingleSlot(event) {
    var requestURL = contextPath + REMOVE_SINGLE_SLOT;
    var requestMethod = "POST";
    var requestData = {
        slotId: event.slotId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        // processData: false,
        success: function () {
            console.log("Removed single slot with ID = " + event.slotId);
            onClickShowPopup(REMOVE_SUCCESS_STATUS, TYPE_SUCCESS);
            $('#eventDetailPopup').fadeOut();
            $('#calendar').fullCalendar('removeEvents', event._id);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(REMOVE_FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function editEventNameAndPrivacy(event) {
    var requestURL = contextPath + UPDATE_NAME_AND_PRIVACY;
    var requestMethod = "POST";
    var isPublic = $("#eventDetailIsPublic").prop('checked')
    var privacy;
    if (isPublic) {
        privacy = 1
    }
    else {
        privacy = 0
    }

    var requestData = {
        slotId: event.slotId,
        eventName: $('#eventPopupTitle').val(),
        privacy: privacy,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        success: function () {
            onClickShowPopup(EDIT_SUCCESS_STATUS, TYPE_SUCCESS);
            $("#calendar").fullCalendar('removeEvents');
            loadEvent();
            $("#eventDetailPopup").fadeOut();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(EDIT_FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}


function onClickShowPopup(mes, type) {

    $.notify({
        // options
        message: mes
    }, {
        // settings
        element: 'body',
        position: null,
        type: type,
        allow_dismiss: false,
        newest_on_top: false,
        showProgressbar: false,
        placement: {
            from: "bottom",
            align: "center"
        },
        offset: 50,
        spacing: 10,
        z_index: 1031,
        delay: 1000,
        mouse_over: null,
        animate: {
            enter: 'animated fadeInDown',
            exit: 'animated fadeOutUp'
        },
        template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
        '<img data-notify="icon" class="img-circle pull-left">' +
        '<span data-notify="title">{1}</span>' +
        '<span data-notify="message">{2}</span>' +
        '</div>'
    });
}

function getRegistrationInfo(slotId) {
    var requestURL = contextPath + GET_USER_REGISTRATION;
    var requestMethod = "POST";
    var requestData = {
        "slotId": slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            $("#userPhone").val(res.phone);
            $("#conductor").val(res.conductor);
            $("#room").val(res.room);
            $("#userMessage").val(res.description);
            $("#userName").val(res.userName);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(ERROR_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function acceptRegistration(event) {
    var requestURL = contextPath + ACCEPT_REGISTRATION_URL;
    var requestMethod = "POST";
    var requestData = {
        "slotId": event.slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            event.eventStatus = 3;
            event.color = "#01ff70";
            $('#calendar').fullCalendar('updateEvent', event);
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(ERROR_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function rejectRegistration(event) {
    var requestURL = contextPath + REJECT_REGISTRATION_URL;
    var requestMethod = "POST";
    var requestData = {
        "slotId": event.slotId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
            $('#calendar').fullCalendar('removeEvents', event._id);
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(ERROR_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function calculateExamDate(event,numberOfSlot){
    var startDate=event.start.split("T")[0];
    var dayOfWeek =  new Date(startDate).getDay();
    var recent=-1;
    dayArray.forEach(function(e){
        var item=parseInt(e)-1;
        var dif=item-dayOfWeek;
        if(dif>=0&&dif>max){
            max=dif;
            recent=e;
        }
    })
    var max=recent;
    if(recent=-1){
        dayArray.forEach(function(e){
            if((e-1)> max){
                max=(e-1);
            }
        })
        max=max+6;
    }

    var date=new Date(startDate);
    date.setDate(date.getDate() + (max+(7-date.getDay())) % 7);
    var plus=(parseInt(numberOfSlot)/parseInt(dayArray.length));
    date.setDate(date.getDate()+parseInt(plus)*6+10);
    return date.toISOString().slice(0,10);
}
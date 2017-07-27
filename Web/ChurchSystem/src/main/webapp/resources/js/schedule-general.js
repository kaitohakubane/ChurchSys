/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */

var UPDATE_EVENT_URL = "/manager/event/Update";
var DELETE_EVENT_URL = "/manager/event/Delete";
var REGISTER_STREAM_URL = "/manager/stream/Register"
var STREAM_URL = "/manager/stream";
var CHECK_IS_MANY_SLOT = "/manager/event/check-is-many-slot";
var SCHEDULE_URL = "/manager/schedule";
// var REMOVE_EVENT = "/manager/schedule/remove-event";
var REMOVE_SINGLE_SLOT = "/manager/schedule/remove-single-slot";
var REMOVE_MULTI_SLOT = "/manager/schedule/remove-multi-slot";
var dayArray = [];
var streamResolutionDefault = "240p"
var workingEvent;
var currentEventIsMultiSlot;
var curSlotId;

//
classListInitial();
registerClassList();
datePickerLoad();
$(document).ready(function () {
    terminateEventCreateMenu();
    $("#cancel").on("click",function(){
        $("#confirmModal").modal("hide");
    })
    $('.day-checkbox').on('ifChecked', function (event) {
        dayArray.push(event.target.id)
        dayArray.sort(function (a, b) {
            return a - b;
        })
        console.log(dayArray)
    });

    $('.day-checkbox').on('ifUnchecked', function (event) {
        var index = dayArray.indexOf(event.target.id);
        if (index > -1) {
            dayArray.splice(index, 1);
        }
        console.log(dayArray)
    });


    $("#createStreambtn").on("click", function () {
        console.log($(this).data("id"))
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
        $(this).data('event', {
            title: $.trim($(this).text()), // use the element's text as the event title
            stick: true, // maintain when user navigates (see docs on the renderEvent method)
            start: "06:00",
            duration: "01:30",
            color: '#24ea12',
            subId: $(this).attr('subId'),
            privacy: 1
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    })
}


function inputEventPopupInformation(event) {
    $('#eventName').html(event.title);
    $('#eventPopupTime').val(event.start.format('HH:mm') + " - " + event.end.format('HH:mm'));
    $('#eventPopupSubject').val(event.subName);
    $('#eventPopupConductor').val(event.conductorName);
    $('#eventPopupRoom').val(event.roomName);
    var streamBtn = $("#streamBtn");
    if (event.streamLink != null) {
        console.log("stream Null")
        streamBtn.removeClass("btn-primary")
        streamBtn.addClass("btn-dark")
        streamBtn.unbind("click");
        streamBtn.on("click", function (e) {
            e.preventDefault();
            var parameter = {
                streamLink: event.streamLink,
                streamCode: event.streamCode
            }
            post(contextPath + STREAM_URL, parameter)
        })
    } else {
        if (streamBtn.attr("class").includes("btn-dark")) {

            streamBtn.removeClass("btn-dark");
            streamBtn.addClass("btn-primary")
        }
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
    $("#eventDetailIsPublic").prop('readonly',true);
    console.log("dmm");
    $("#editSlotButton").on("click", function () {
        var parameter = {
            slotId: event.slotId
        }
        post(contextPath + UPDATE_EVENT_URL, parameter);
    })

    $("#btnRemove").on('click', function () {
        checkIsManySlot(event);
        curSlotId = event.slotId;
        console.log("Selected slot ID is: " + curSlotId);
        console.log("Removing slot with ID = " + curSlotId);

        if (currentEventIsMultiSlot == 1) {
            console.log("Selected slot has multi slot");
            $('#confirmModal').modal('show');
        }
        else if (currentEventIsMultiSlot == 0) {
            console.log("Selected slot has one slot");
            removeSingleSlot(curSlotId);
        }
    })
}

$("#oneSlot").on("click", function () {
    console.log("Option remove one slot is selected");
    removeSingleSlot(curSlotId);

})
$("#manySlot").on("click", function () {
    console.log("Option remove many slot is selected");
    removeMultiSlot(curSlotId);
})

function terminateEventCreateMenu() {

    $(document).bind('click', function (e) {
        if ($(e.target).prop("tagName").toUpperCase() == "SMALL") {
            return;
        }

        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String
            )) {
            $("#calendarPopup").fadeOut();
            $("#eventDetailPopup").fadeOut();
            return;
        }


        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#calendarPopup').has(e.target).length > 0 || !($(e.target).attr('class').toString()
                .indexOf('fc-widget-content')))) {
            $("#calendarPopup").fadeOut();
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

function appendClassToList(subId) {
    var classTab = document.createElement('div');
    classList.forEach(function (item) {
        if (item[0] == subId) {
            classTab.className = "fc-event";
            classTab.setAttribute('subId', item[0]);
            classTab.textContent = item[1] + ": " + item[2];
            $('#external-events-listing').append(classTab);
        }

    })
    registerClassList();
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
            $("#calendar").fullCalendar('removeEventSources');
            loadEvent();
            $("#calendar").fullCalendar('addEventSource', {
                events: eventList,
                color: '#43abc9'
            })
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
            alert('Delete Success!');
            window.location.href = contextPath + SCHEDULE_URL;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
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
        dataType: 'json',
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
            alert('Error happen')
            console.error(textStatus);
        }
    })
}
function removeSingleSlot(slotId) {
    var requestURL = contextPath + REMOVE_SINGLE_SLOT;
    var requestMethod = "POST";
    var requestData = {
        slotId: slotId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        // processData: false,
        success: function () {
            console.log("Removed single slot with ID = " + slotId);
            alert('Delete success!');
            window.location.href = contextPath + SCHEDULE_URL;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}
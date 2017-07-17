/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */

var UPDATE_EVENT_URL = "/manager/event/Update";
var DELETE_EVENT_URL = "/manager/event/Delete";
var REGISTER_STREAM_URL = "/manager/stream/Register"
var STREAM_URL = "/manager/stream";
var REGISTER_STREAM_URL = "/manager/stream/Register";
var dayArray = [];
var streamResolutionDefault = "240p"
var workingEvent;
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
    $('#eventPopupTitle').val(event.title);
    $('#eventPopupTime').val(event.start.format('HH:mm') + " - " + event.end.format('HH:mm'));
    $('#eventPopupSubject').val(event.subName);
    $('#eventPopupConductor').val(event.conductorName);
    $('#eventPopupRoom').val(event.roomName);
    var streamBtn = $("#streamBtn");
    if (event.streamLink != null) {
        console.log("stream Null")
        streamBtn.removeClass("btn-primary")
        streamBtn.addClass("btn-dark")
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


    $("#editSlotButton").on("click", function () {
        var parameter = {
            slotId: event.slotId
        }
        post(contextPath + UPDATE_EVENT_URL, parameter);
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




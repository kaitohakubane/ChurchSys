/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
var CREATE_EVENT_URL = "/manager/event/Add";
var UPDATE_EVENT_URL = "/manager/event/Update";
var DELETE_EVENT_URL = "/manager/event/Delete";
//
classListInitial();
registerClassList();
terminateEventCreateMenu();


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

//Normaliza data for event object
function normalizeEventObject(event) {
    var normalizedEvent = {
        eventName: event.title,
        subjectId: event.subjectId,
        endTime: event.end,
        startTime: event.start,
        privacy: 1
    }
    return normalizedEvent;
}

function inputEventPopupInformation(event) {
    $('#eventPopupTitle').val(event.title);
    $('#eventPopupTime').val(event.start.format('HH:mm') + " - " + event.end.format('HH:mm'));
    $('#eventPopupSubject').val(event.subName);
    $('#eventPopupConductor').val(event.conductorName);
    $('#eventPopupRoom').val(event.roomName);
    console.log(event.privacy == 0)
    if (event.privacy == 0) {
        if ($("#eventDetailIsPublic").prop('checked')) {
            console.log($("#eventDetailIsPublic").prop('checked'));
            $("#eventDetailIsPublic").click();
            console.log('CLick')
        }
    } else{
        if (!$("#eventDetailIsPublic").prop('checked')) {
            $("#eventDetailIsPublic").click();
        }
    }


}

function terminateEventCreateMenu() {

    $(document).bind('click', function (e) {
        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String)) {
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

// -------------------------------------------Ajax------------------------------




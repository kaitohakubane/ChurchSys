/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */

calendarInitialize();
registerClassList();
var creatingEvent;
var calEventStatus = [];
var defaultMovePlus = 5;
var lastClicked = null;
var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');
$(document).ready(function () {
    terminatePopup();
    $('#createEventbtn').on('click',function(){
        $("#calendarPopup").fadeOut();
        $('#calendar').fullCalendar( 'renderEvent', creatingEvent );

    })


})
var isEventOverDiv = function(x, y) {

    var external_events = $( '#external-events' );
    var offset = external_events.offset();
    offset.right = external_events.width() + offset.left;
    offset.bottom = external_events.height() + offset.top;

    // Compare
    if (x >= offset.left
        && y >= offset.top
        && x <= offset.right
        && y <= offset .bottom) { return true; }
    return false;

}
function terminatePopup() {

    $(document).bind('click', function (e) {
        if(!(typeof $(e.target).attr('class')==="string" || $(e.target).attr('class') instanceof String)){
            $("#calendarPopup").fadeOut();
            return;
        }
        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#calendarPopup').has(e.target).length > 0)) {
            $("#calendarPopup").fadeOut();
        }

    })


}


function eventRegisterPopup(e) {
    var windowHeight = $(window).height() / 2;
    var windowWidth = $(window).width() / 2;
    if (e.clientY > windowHeight && e.clientX <= windowWidth) {
        $("#calendarPopup").css("left", e.clientX + defaultMovePlus);
        $("#calendarPopup").css("bottom", $(window).height() - e.clientY + defaultMovePlus);
        $("#calendarPopup").css("right", "auto");
        $("#calendarPopup").css("top", "auto");
        $("#calendarPopup").fadeIn();
    } else if (e.clientY > windowHeight && e.clientX > windowWidth) {
        $("#calendarPopup").css("right", $(window).width() - e.clientX + defaultMovePlus);
        $("#calendarPopup").css("bottom", $(window).height() - e.clientY + defaultMovePlus);
        $("#calendarPopup").css("left", "auto");
        $("#calendarPopup").css("top", "auto");
        $("#calendarPopup").fadeIn();
    } else if (e.clientY <= windowHeight && e.clientX <= windowWidth) {
        $("#calendarPopup").css("left", e.clientX + defaultMovePlus);
        $("#calendarPopup").css("top", e.clientY + defaultMovePlus);
        $("#calendarPopup").css("right", "auto");
        $("#calendarPopup").css("bottom", "auto");
        $("#calendarPopup").fadeIn();
    } else {
        $("#calendarPopup").css("right", $(window).width() - e.clientX + defaultMovePlus);
        $("#calendarPopup").css("top", e.clientY + defaultMovePlus);
        $("#calendarPopup").css("left", "auto");
        $("#calendarPopup").css("bottom", "auto");
        $("#calendarPopup").fadeIn();
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

        select: function(start, end, allDay, jsEvent, view) {
            // alert('you have clicked on this slot' + start.format());
        },

        dayClick: function (date, jsEvent, view) {

            if (lastClicked == $(this)) {
                $('#calendar').fullCalendar('changeView', 'agendaDay');
                $('#calendar').fullCalendar('gotoDate', date);
            }


            if (view.name == 'month') {
                if (lastClicked != null) {
                    lastClicked.css('background-color', '#ffffff')
                }

                eventRegisterPopup(jsEvent);
                if (date.format() != today) {
                    $(this).css('background-color', '#fcf2b3');
                    lastClicked = $(this);
                }
            }

            var eventName=$('#creatingEventName').val();
            var eventType=$('#eventType').val();
            if(eventName==''){
                eventName='UnnamedEvent';
            }
            if(eventType==''){
                eventType="UndefinedType"
            }
            creatingEvent={
                title: eventName +"  -  "+ eventType,
                start: date.format()+'T04:30',
                color: '#24ea12'
            }


        },

        dayRender: function(date, element, view){
            element.bind('dblclick', function() {
                $('#calendar').fullCalendar('changeView', 'agendaDay');
                $('#calendar').fullCalendar('gotoDate', date);
                $("#calendarPopup").fadeOut();
            });
        },


        // eventRender: function(event, element) {
        //     element.bind('dblclick', function() {
        //         alert('double click!');
        //     });
        // },
        drop: function(date) {
            $(this).remove();
            console.log('drop');
        },

        eventReceive: function( event ) {
            // makeEventsDraggable();
        },

        eventDragStart: function( event, jsEvent, ui, view ) {
            // Add dragging event in global var
            calEventStatus['calendar'] = '#calendar';
            calEventStatus['event_id'] = event._id;
        },
        eventDragStop: function( event, jsEvent, ui, view,revertFunc ) { console.log('calendar 1 eventDragStop');
            if(isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
                $('#calendar').fullCalendar('removeEvents', event._id);
                var el = $( "<div class='fc-event'>" ).appendTo( '#external-events-listing' ).text( event.title );
                el.draggable({
                    zIndex: 999,
                    revert: true,
                    revertDuration: 0
                });
                el.data('event', { title: event.title, id :event.id, stick: true });
                registerClassList();
            }

            calEventStatus = []; // Empty
            // makeEventsDraggable();



        },
        eventDrop:function( event, delta, revertFunc, jsEvent, ui, view ) {
            console.log('eventDrop')
            if(typeof event.end === 'undefined'||!event.end){
                return;
            }
            var start=event.start.format('HH:mm');
            var end=event.end.format('HH:mm');
            if(start<'04:30'||end>'21:00'||start>end){
                revertFunc();
                console.log('revert');
            }
        },

        events: [
            {
                title: 'event1',
                start: '2017-06-09'
            },
            {
                title: 'event2',
                start: '2017-06-25',
                end: '2010-06-025'
            },
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
        eventDurationEditable:true,
        droppable: true,
        dragRevertDuration: 0,
        eventLimit:true,
        slotLabelFormat:'HH:mm',
        timeFormat:'HH:mm'
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
function registerClassList(){
    $('.fc-event').each(function() {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
            title: $.trim($(this).text()), // use the element's text as the event title
            stick: true, // maintain when user navigates (see docs on the renderEvent method)
            start: "06:00",
            duration:"01:30",
            color: '#24ea12'
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




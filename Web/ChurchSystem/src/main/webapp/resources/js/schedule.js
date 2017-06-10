/**
 * Created by hungmcse61561-admin on 6/9/2017.
 */

calendarInitialize();

var lastClicked = null;
var today = $('#calendar').fullCalendar('getDate').format('YYYY-MM-DD');
$(document).ready(function () {
    terminatePopup();
})

function terminatePopup() {

    $(document).bind('click', function (e) {
        console.log($(e.target).attr('class'));
        console.log($('div#calendarPopup').has(e.target).length);
        console.log(($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
        $('div#calendarPopup').has(e.target).length>0));
        if (!($(e.target).attr('class').toString().indexOf('fc-day') >= 0 ||
            $('div#calendarPopup').has(e.target).length>0)){
            $("#calendarPopup").fadeOut();
        }


    })
}


function eventRegisterPopup(e) {
    var windowHeight = $(window).height() / 2;
    var windowWidth = $(window).width() / 2;
    if (e.clientY > windowHeight && e.clientX <= windowWidth) {
        $("#calendarPopup").css("left", e.clientX);
        $("#calendarPopup").css("bottom", $(window).height() - e.clientY);
        $("#calendarPopup").css("right", "auto");
        $("#calendarPopup").css("top", "auto");
        $("#calendarPopup").fadeIn();
    } else if (e.clientY > windowHeight && e.clientX > windowWidth) {
        $("#calendarPopup").css("right", $(window).width() - e.clientX);
        $("#calendarPopup").css("bottom", $(window).height() - e.clientY);
        $("#calendarPopup").css("left", "auto");
        $("#calendarPopup").css("top", "auto");
        $("#calendarPopup").fadeIn();
    } else if (e.clientY <= windowHeight && e.clientX <= windowWidth) {
        $("#calendarPopup").css("left", e.clientX);
        $("#calendarPopup").css("top", e.clientY);
        $("#calendarPopup").css("right", "auto");
        $("#calendarPopup").css("bottom", "auto");
        $("#calendarPopup").fadeIn();
    } else {
        $("#calendarPopup").css("right", $(window).width() - e.clientX);
        $("#calendarPopup").css("top", e.clientY);
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
                minTime: '04:00:00',
                maxTime: '21:00:00',
                slotDuration: '02:00:00',
                allDaySlot: false,
            }
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
                start: '2017-06-21T12:30:00',
                allDay: false // will make the time show
            }
        ]


    })
}
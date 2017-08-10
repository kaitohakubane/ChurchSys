/**
 * Created by hungmcse61561-admin on 6/29/2017.
 */

var STREAM_URL = "/manager/stream";
var FINISH_EVENT = "/automation/finishEvent";
/**
 * Display the notification message.
 */
$(document).ready(function () {
    $("#streamOption").on("click", function () {
        post(contextPath + STREAM_URL)
    })
})
function notify(information, link, time, sender) {
    $("#notification").prepend("<li> <a href='" + contextPath + link + "'> <span> " + sender + " </span> <span class='message'> " + information +
        " </span> <span>" + time + " </span></span></span> </a> </li>")

    var count = $("#numberOfNoti").html();
    if (count == null || count == "") {
        $("#numberOfNoti").html("1")
    } else {
        $("#numberOfNoti").html(parseInt(count) + 1);
    }


}


function eventRegisterPopup(e, popup) {
    console.log("popup")
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

// Post to the provided URL with the specified parameters.
function post(path, parameters) {
    var form = $('<form></form>');

    form.attr("method", "post");
    form.attr("action", path);

    $.each(parameters, function (key, value) {
        var field = $('<input></input>');

        field.attr("type", "hidden");
        field.attr("name", key);
        field.attr("value", value);

        form.append(field);
    });

    // The form needs to be a part of the document in
    // order for us to be able to submit it.
    $(document.body).append(form);
    form.submit();
}

function finishEvent(churchId) {
    var requestData = {
        "churchId": churchId
    }
    var requestMethod = "POST";
    var requestURL = contextPath + FINISH_EVENT;
    $.ajax({
            url: requestURL,
            data: requestData,
            type: requestMethod,
            success: function () {

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Error happen')
                console.error(textStatus);
            }
        }
    )
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

function onClickShowWarningPopup(mes, type) {

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
        template: '<div data-notify="warning-container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
        '<img data-notify="icon" class="img-circle pull-left">' +
        '<span data-notify="title">{1}</span>' +
        '<span data-notify="message">{2}</span>' +
        '</div>'
    });
}
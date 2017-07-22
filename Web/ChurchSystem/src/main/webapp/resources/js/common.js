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

    var count = parseInt($("#numberOfNoti").html());
    $("#numberOfNoti").html(count + 1);

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
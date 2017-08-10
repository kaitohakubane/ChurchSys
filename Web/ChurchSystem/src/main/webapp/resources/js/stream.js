/**
 * Created by hungmcse61561-admin on 7/2/2017.
 */

var CREATE_STREAM_URL = "/manager/stream/Add";
var START_STREAM_URL = "/manager/stream/Start";
var FINISH_STREAM_URL = "/manager/stream/Finish";
var MANAGER_MAIN_PAGE_URL = "/manager/";
var STREAM_INSTRUCTION_URL = "/manager/stream/instruction";
var START_OBS="/manager/StartOBS";
var STREAM_NOTIFICATION_URL = "/manager/stream/notification";
var streamEntity = null;
$(document).ready(function () {
    Initial();
})

function Initial() {
    $("#step-2").hide();

    $("#next").on('click', function () {
        $("#step-1").hide();
        $("#step-2").show();
        $("#youtubeVideo").attr('src', "https://www.youtube.com/embed/" + streamLink + "?autoplay=1")
        streamOnAir(streamLink);
        var streamTitle = $("#streamTitle").val();
        pushNotification(streamLink,streamTitle);
    });


    if (streamLink == "" || streamCode == "") {
        $("#registration").modal("show");
    } else {
        $("#streamCode").val(streamCode);
        $("#streamTitle").val(streamTitle);
        startOBS()
    }


    $("#createStreambtn").on("click", function () {
        var streamTitle = $("#streamTitle").val();
        var resolution = $("#resolution").val();
        createStream(streamTitle, resolution);
        $("#registration").modal("hide");
        $("#streamCode").val(streamCode)
        startOBS();
    })

    $("#end").on("click", function () {
        completeStream();
        window.location.href = contextPath + MANAGER_MAIN_PAGE_URL;
    })

    var parameter = {
        streamLink: streamLink,
        streamCode: streamCode
    }

    $("#guide").on("click", function () {
        post(contextPath + STREAM_INSTRUCTION_URL, parameter)
    })
}


function createStream(title, resolution) {
    var requestURL = contextPath + CREATE_STREAM_URL;
    var requestMethod = "POST";
    var requestData = {
        "streamTitle": title,
        "resolution": resolution
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            streamEntity = res;
            streamLink = streamEntity.streamLink;
            streamCode = streamEntity.streamCode;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function streamOnAir(link) {

    var requestData = {
        "streamLink": link
    };
    $("#loading").modal("show");
    var requestURL = contextPath + START_STREAM_URL;
    var requestMethod = "POST"
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        success: function () {
            $("#loading").modal("hide");
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    })
}

function pushNotification(link,streamTitle) {

    var requestData = {
        "streamLink": link,
        "streamTitle":streamTitle
    };
    var requestURL = contextPath + STREAM_NOTIFICATION_URL;
    var requestMethod = "POST"
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        success: function () {
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    })
}

function completeStream() {
    var requestURL = contextPath + FINISH_STREAM_URL;
    var requestType = "POST"
    var requestData = {
        "streamLink": streamLink
    }
    $.ajax({
        url: requestURL,
        type: requestType,
        data: requestData,
        success: function () {

        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    })
}

function startOBS(){
    var requestURL = contextPath + START_OBS;
    var requestType = "POST"

    $.ajax({
        url: requestURL,
        type: requestType,
        success: function () {

        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    })
}


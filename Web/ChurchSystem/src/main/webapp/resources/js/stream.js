/**
 * Created by hungmcse61561-admin on 7/2/2017.
 */

var CREATE_STREAM_URL = "/manager/stream/Add";
var START_STREAM_URL="/manager/stream/Start";
var FINISH_STREAM_URL="/manager/stream/Finish";
var streamEntity;
$(document).ready(function () {
    Initial();
})

function Initial() {
    $("#step-2").hide();

    $("#next").on('click', function () {
        $("#step-1").hide();
        $("#step-2").show();
        $("#youtubeVideo").attr('src',"https://www.youtube.com/embed/"+streamEntity.streamLink+"?autoplay=1")
        streamOnAir(streamEntity.streamLink);

    });


    if (streamLink == "" || streamCode == "") {
        $("#registration").modal("show");
    }

    $("#createStreambtn").on("click",function(){
        var streamTitle=$("#streamTitle").val();
        var resolution=$("#resolution").val();
        createStream(streamTitle,resolution);
        $("#registration").modal("hide");
        $("#streamCode").val(streamEntity.streamCode)
    })

    $("#end").on("click",function(){
        completeStream();
    })

}


function createStream(title,resolution) {
    var requestURL = contextPath + CREATE_STREAM_URL;
    var requestMethod = "POST";
    var requestData = {
        "streamTitle":title,
        "resolution":resolution
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            streamEntity=res;
            console.log(streamEntity);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function streamOnAir(link){

    var requestData={
        "streamLink":link
    };
    var requestURL=contextPath+START_STREAM_URL;
    var requestType="POST"
    $.ajax({
        url: requestURL,
        type:requestType,
        data:requestData,
        async: false,
        success: function(){

        },
        error:function(jqXHR, textStatus, errorThrown){

        }
    })
}

function completeStream(){
    var requestURL=contextPath+FINISH_STREAM_URL;
    var requestType="POST"
    $.ajax({
        url: requestURL,
        type:requestType,
        success: function(){

        },
        error:function(jqXHR, textStatus, errorThrown){

        }
    })
}

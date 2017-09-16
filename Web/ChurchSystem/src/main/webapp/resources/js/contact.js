/**
 * Created by Hung on 9/6/2017.
 */
var CHAT_URL = '/common/chat'

sendMessage();

function sendMessage() {
    $("#sendBtn").on("click", function () {
        $(".chatlogs").append('<div class="chat self"> <p class="chat-message">'+$('#chatInput').val()+'</p> </div>');
        sendServerMessage($('#chatInput').val())
        $('#chatInput').val('');
    })

}

function chat(message,sender) {
    $(".chatlogs").append('<div class="chat another"> <div class="user-photo"><img src=""></div> <p class="chat-message">'+message+'</p> </div>');
}

function sendServerMessage(message) {
    var requestMethod = "POST"
    var requestURL = contextPath + CHAT_URL;
    var requestData = {
        "message": message,
        "churchId":churchId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error(textStatus);
        }
    })
}
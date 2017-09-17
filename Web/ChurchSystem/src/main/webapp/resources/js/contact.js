/**
 * Created by Hung on 9/6/2017.
 */
var CHAT_URL = '/common/chat';
var chatHistory;
var LOAD_CHAT_HISTORY = "/chat/loadHistory";
generalInitial();

function generalInitial() {
    $("#sendBtn").on("click", function () {
        $(".chatlogs").append('<div class="chat self"> <p class="chat-message">'+$('#chatInput').val()+'</p> </div>');
        sendServerMessage($('#chatInput').val())
        $('#chatInput').val('');
    })

    $("#chatInput").keypress(function(){
        var key=window.event.keyCode;
        if(key===13){
            $(".chatlogs").append('<div class="chat self"> <p class="chat-message">' + $('#chatInput').val() + '</p> </div>');
            sendServerMessage($('#chatInput').val())
            $('#chatInput').val('');
        }
    })
    loadChatHistory()
    chatHistory.forEach(function (e) {
        console.log(e.senderId);
        console.log("accountId: "+accountId);
        if (e.senderId == accountId) {
            $(".chatlogs").append('<div class="chat self"> <p class="chat-message">' + e.information + '</p> </div>');
        } else {
            $(".chatlogs").append('<div class="chat another"> <div class="user-photo"><img src="'+contextPath+'/resources/img/icon.png"></div> ' +
                '<p class="chat-message">' + e.information + '</p> </div>');
        }
    })
}

function loadChatHistory() {
    var requestMethod = "POST"
    var requestURL = contextPath + LOAD_CHAT_HISTORY;
    var requestData = {
        "churchId": churchId,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        dataType: 'json',
        success: function (result) {
            chatHistory = result;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error(textStatus);
        }
    })
}

function chat(message,sender) {
    $(".chatlogs").append('<div class="chat another"> <div class="user-photo"><img src="'+contextPath+'/resources/img/icon.png"></div> <p class="chat-message">'+message+'</p> </div>');
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
/**
 * Created by Trung on 9/1/2017.
 */
var listOfChatter = [];
var isChatting = false;
var CHAT_URL = '/common/chat';
var LOAD_USER = '/chat/loadUser';
var LOAD_CHAT_HISTORY = "/chat/loadHistory";
var currentUser;
var chattingUser;
var chatHistory = [];


generalInit();

function activeChatRegister() {
    $('ul.list-chatter > li').click(function (e) {
        e.preventDefault();
        $('ul.list-chatter > li').removeClass('active-chatter');
        $(this).addClass('active-chatter');
    });
}

function generalInit(){
    $(".chatter").each(function(){
        activeChatRegister();
        commonInit();
        listOfChatter.push($(this).attr('id'))
        $(this).click();
        return;
    })
    sendMessage();

    $("#chatInput").keypress(function(){
        var key=window.event.keyCode;
        if(key===13){
            $(".chatlogs").append('<div class="chat self"> <p class="chat-message">' + $('#chatInput').val() + '</p> </div>');
            sendServerMessage($('#chatInput').val(),currentUser.accountId)
            $('#chatInput').val('');
        }
    })
}

function sendMessage() {
    $("#sendBtn").on("click", function () {
        $(".chatlogs").append('<div class="chat self"> <p class="chat-message">' + $('#chatInput').val() + '</p> </div>');
        sendServerMessage($('#chatInput').val(),currentUser.accountId)
        $('#chatInput').val('');
    })

}

function chat(message, sender) {
    if(chattingUser==sender){
        $(".chatlogs").append('<div class="chat another"> <div class="user-photo"><img src=""></div> <p class="chat-message">' + message + '</p> </div>');
    }

    listOfChatter.forEach(function (e) {
        if (e == sender) {
            isChatting = true;
            return;
        }
    })

    if (isChatting == false) {
        loadNewUser(sender);
        listOfChatter.push(sender);
        commonInit();
    }
    isChatting = false;

}

function loadNewUser(sender) {
    loadUser(sender);
    $('.list-chatter').prepend(' <li class="chatter" id="' + sender + '" data-name="' + currentUser.userName + '"> <a href="#" > <div class="user-photo">' +
        '<img src=""></div> <div class="name"> ' +
        '<span>' + currentUser.userName + '</span> </div> </a> </li>')
}

function commonInit() {
    $('.chatter').unbind("click");
    $('.chatter').bind("click", function () {
        console.log('cHATING')
        $(".chatlogs").empty();
        loadChatHistory($(this).attr('id'));
        $('#chatter-name').val($(this).data('name'));
        loadUser($(this).attr('id'));
        $('#informationName').html(currentUser.userName)
        $('#informationPhone').html(currentUser.tel);
        $('#informationMail').html(currentUser.email);
        $('#chattingUser').html(currentUser.userName);
        chattingUser=$(this).attr('id');
        chatHistory.forEach(function (e) {
            if (e.senderId == managerId) {
                $(".chatlogs").append('<div class="chat self"> <p class="chat-message">' + e.information + '</p> </div>');
            } else {
                $(".chatlogs").append('<div class="chat another"> <div class="user-photo"><img src=""></div> ' +
                    '<p class="chat-message">' + e.information + '</p> </div>');
            }
        })
    })
    activeChatRegister();
}

function loadChatHistory(sender) {
    var requestMethod = "POST"
    var requestURL = contextPath + LOAD_CHAT_HISTORY;
    var requestData = {
        "accountId": sender,
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

function loadUser(sender) {
    var requestMethod = "POST"
    var requestURL = contextPath + LOAD_USER;
    var requestData = {
        "accountId": sender,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        dataType: 'json',
        async: false,
        success: function (result) {
            currentUser = result;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error(textStatus);
        }
    })
}


function sendServerMessage(message, accountId) {
    var requestMethod = "POST"
    var requestURL = contextPath + CHAT_URL;
    var requestData = {
        "message": message,
        "accountId": accountId,
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
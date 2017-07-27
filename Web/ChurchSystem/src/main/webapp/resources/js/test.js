/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
var token=null;
$(document).ready(function () {
    // var options = {
    //     float: true
    // }
    // $('.grid-stack').gridstack(options);
    // $("#add-room").on("click", function () {
    //     addNewCabinet($(".room"));
    // })


    $("#dm").on("click", function () {
        testFunction();
    })
})

function testFunction() {
    var requestData = {
        "token": token
    }
    var requestMethod = "POST"
    var requestURL = contextPath + "/test/post"
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            token = res;
            if (token == "-1"||token=="") {
                alert("DM SS")
            } else {
                testCalendarFunction();
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });

}

function testCalendarFunction() {
    var requestData = {
        "token": token
    }
    var requestMethod = "POST"
    var requestURL = contextPath + "/test/get"
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            alert("NGON")
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });

}

//
//
// function addNewCabinet(e) {
//     var grid = e.data('gridstack');
//
//     var node =  {x: 0, y: 0, width: 2, height: 2}
//
//     grid.addWidget($('<div><div class="grid-stack-item-content" ><div class="grid-stack cabinet"></div></div><div/>'),
//         node.x, node.y, node.width, node.height);
//
// }
/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */

var GET_GRAVE_YARD = "/graveYard/Get";
var GENERATE_GRAVE_YARD = "/manager/graveYard/Generate";
var GENERATE_GRAVE = "/manager/grave/Generate";
var GET_GRAVE = "/manager/grave/Get";
var REGISTER_GRAVE = "/grave/Register";
var APPROVE_GRAVE_STATUS = "/manager/grave/Approve";
var GET_GRAVE_OF_CHURCH = "/grave/getGrave";
var ACCEPT_TYPE = 1;
var REJECT_TYPE = 0;
var GRAVE_NOT_INITIAL_COLOR = "#d8d2d2";
var GRAVE_APPROVED_COLOR = "#4288f1";
var GRAVE_WAITING_COLOR = "#f243b5";

var currentGraveYard;
var listOfGraveYard = [];
var listOfGrave = [];
var listOfChurchGrave = [];
var chosenPrototype = "";
var defaultMovePlus = 2;
var highLighting = [];
var highLightingYard = [];


$(document).ready(function () {
    generalInitial();
    getGraveYard();
    terminateEventCreateMenu();
})

function generateItem(target){
    var grid = target.data('gridstack');
    grid.addWidget($('<div><div class="grid-stack-item-content gate"></div><div/>'), 0, 0, 1, 1);

    grid.addWidget($('<div data-gs-id="1"><div class="grid-stack-item-content graveYardItem graveYardNotInitial"' +
        'data-status="0" ></div><div/>'), 0, 1, 1, 1);
}


function generateGraveYard(target) {
    var grid = target.data('gridstack');
    listOfGraveYard.forEach(function (e) {
        if (e.status < 3) {
            grid.addWidget($('<div data-gs-id='+e.graveYardId+'><div class="grid-stack-item-content graveYardItem " data-id=' + e.graveYardId + ' data-free=' + e.graveAvailable + ' data-status=' + e.status + ' data-gravewi=' + e.width + ' data-gravehe=' + e.height + '  >' + e.name + '</div><div/>'), e.x, e.y, 1, 1);
        } else if (e.status == 3) {
            grid.addWidget($('<div><div class="grid-stack-item-content gate" data-id=' + e.graveYardId + ' data-status=' + e.status + '>' + e.name + '</div><div/>'), e.x, e.y, 1, 1);
        } else {
            grid.addWidget($('<div><div class="grid-stack-item-content statue" data-id=' + e.graveYardId + ' data-status=' + e.status + '>' + e.name + '</div><div/>'), e.x, e.y, 2, 1);
        }
    })

    $(".graveYardItem").each(function () {
        if ($(this).data("status") == 0) {
            $(this).addClass("graveYardNotInitial")
        } else if ($(this).data("status") == 1) {
            $(this).addClass("graveYardInitial")
        } else if (($(this).data("status") == 2)) {
            $(this).addClass("graveYardFull")
        }
    })


    graveYardItemEvent();

}

function graveYardItemEvent(){
    $(".graveYardItem").on("click", function (x) {
        contextMenuInitial($(this))
        eventRegisterPopup(x, $("#graveYardInformation"));
    })
}

function contextMenuInitial(e) {
    $("#contextName").val(e.html());
    console.log('41231')
    var width = e.data("gravewi");
    var height = e.data("gravehe");
    var free = e.data("free");
    var data;
    if (width != null && height != null && $.isNumeric(width) && $.isNumeric(height)) {
        data = parseInt(width) * parseInt(height);
    } else {
        data = 0;
    }
    $("#contextSlot").val(data);

    if (!(free != null && $.isNumeric(free))) {
        data = 0;
    } else {
        data = free;
    }
    $("#contextFree").val(data);
    var btn = $("#contextBtn");
    if (e.data("status") == 0) {
        btn.html("Khởi tạo");
        btn.unbind("click");
        btn.bind("click", function () {
            $("#graveYardPopup").modal('show');

            $("#intialGraveYard").unbind("click");
            $("#intialGraveYard").bind("click", function () {
                width = $("#graveYardWidth").val();
                height = $("#graveYardHeight").val()
                setupGraveYard(e, width, height)
            })
        })
    } else {
        btn.html("Xem")
        btn.unbind("click");
        btn.bind("click", function () {
            $("#graveYardInformation").fadeOut();
            getGrave(e.data("id"), width, height)
            currentGraveYard = e.data("id");
            $('.nav-tabs a[href="#step2"]').click();
            var search = $('#graveSearch').dropdown('get value')[0];
            generateSearch(search)
            $('.nav-tabs a[href="#step2"]').html('Sơ đồ ' + e.html());
        })

    }
}
function prototypePopupInitial() {
    $("#prototypeWidth").val("6");
    $("#prototypeHeight").val("4");
}

function generalInitial() {
    $("#graveBirthDay").datepicker({changeMonth: true,changeYear: true,yearRange: "-100:+0"});
    $("#graveDeathDay").datepicker({changeMonth: true,changeYear: true,yearRange: "-100:+0"});
    $("#graveBirthDay").datepicker('option', 'dateFormat', 'yy-mm-dd');
    $("#graveDeathDay").datepicker('option', 'dateFormat', 'yy-mm-dd');
    var $box = null;
    $('.style-grave')
        .click(function () {
                if ($box == null) {
                    $box = $(this);
                    $box.css("border", "5px double #26b99a");
                } else {
                    $box.css("border", "5px double #e8e8e8");
                    if ($box != $(this)) {
                        $box = $(this);
                        $box.css("border", "5px double #26b99a");
                    }
                    else
                        $box = null;
                }
                chosenPrototype = $(this).data("id");
            }
        );

    var options = {
        float: true,
        disableResize: true,
        acceptWidgets: '.grid-stack-item'
    }
    $('#graveYard').gridstack(options);
    $('#grave').gridstack(options);
    var options2={
        float: true,
        disableResize: true,
        height:2,
        width:1
    }

    $('#graveYard').on('added',function(event,items){
        graveYardItemEvent();
    })


    $("#protoypePopupBtn").on("click", function () {
        $("#prototype").modal('hide');
        console.log(chosenPrototype);
        var width = $("#prototypeWidth").val();
        var height = $("#prototypeHeight").val();

        if (chosenPrototype == "") {

        } else if (chosenPrototype == "type1") {
            generatePrototype(1, width, height);
        } else if (chosenPrototype == "type2") {
            generatePrototype(2, width, height);
        }
    })

    getGraveOfChurch();
    initialSearchBox();
    prototypePopupInitial();
}

function initialSearchBox() {
    listOfChurchGrave.forEach(function (e) {
        var option = document.createElement("option");
        option.text = e.name;
        option.value = e.graveId;
        $("#graveSearch").append(option)
    })

    $("#graveSearch").dropdown({
        allowAdditions: true,
        onChange: function () {
            var search = $('#graveSearch').dropdown('get value')[0];
            console.log(search);
            generateSearch(search)

        }
    })
}

function generateSearch(search) {
    highLighting.forEach(function (e) {
        e.removeClass("result-grave");
    })
    highLightingYard.forEach(function (e) {
        e.removeClass("result-grave");
    })
    if ($.isNumeric(search)) {

        listOfChurchGrave.forEach(function (e) {
            if (e.graveId == search) {
                console.log("graveId" + e.graveId);
                // $(".graveItem").each(function (index, element) {
                //     console.log(" Element data"+$(element.data("id")))
                //     if ($(element).data("id") == search) {
                //         $(element).addClass("result-grave");
                //         highLighting.push($(this));
                //         return;
                //     }
                // })
                $(".graveYardItem").each(function (index, element) {
                    if (e.graveYardId == $(element).data("id")) {
                        $(element).addClass("result-grave");
                        highLightingYard.push($(element));
                    }
                })
            }
        })

        listOfChurchGrave.forEach(function (e) {
            if (e.graveId == search) {
                $(".graveItem").each(function (index, element) {

                })
            }
        })

    } else {

    }
}

function generatePrototype(prototype, width, height) {
    var requestURL = contextPath + GENERATE_GRAVE_YARD;
    var requestMethod = "POST";
    var requestData = {
        "prototype": prototype,
        "width": width,
        "height": height
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        dataType: 'json',
        success: function (res) {
            listOfGraveYard = res;
            console.log(listOfGraveYard)
            generateGraveYard($("#graveYard"));
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });

}

function getGraveYard() {
    var requestURL = contextPath + GET_GRAVE_YARD;
    var requestMethod = "POST";

    $.ajax({
        url: requestURL,
        type: requestMethod,
        processData: false,
        dataType: 'json',
        success: function (res) {
            listOfGraveYard = res;
            if (listOfGraveYard.length == 0 || listOfGraveYard == null) {
                $("#prototype").modal('show');
            } else {
                generateGraveYard($("#graveYard"));
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function setupGraveYard(e, width, height) {
    var requestURL = contextPath + GENERATE_GRAVE;
    var requestMethod = "POST";
    var graveYardId = e.data("id");
    console.log(e.data("id"));
    console.log(width);
    console.log(height);
    var requestData = {
        "graveYardId": graveYardId,
        "width": width,
        "height": height
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        dataType: 'json',
        success: function (res) {
            $("#graveYardPopup").modal('hide');
            e.data("gravehe", res.height);
            e.data("gravewi", res.width);
            e.data("status", res.status);
            e.data("free", res.graveAvailable);
            e.removeClass("graveYardNotInitial");
            e.addClass("graveYardInitial");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}


function getGrave(graveYardId, width, height) {
    // var requestURL = contextPath + GET_GRAVE;
    // var requestMethod = "POST";
    // var requestData = {
    //     "graveYardId": graveYardId
    // }
    // $.ajax({
    //     url: requestURL,
    //     type: requestMethod,
    //     data: requestData,
    //     dataType: 'json',
    //     success: function (res) {
    //
    //     },
    //     error: function (jqXHR, textStatus, errorThrown) {
    //         alert('Error happen')
    //         console.error(textStatus);
    //     }
    // });
    listOfGrave = []
    listOfChurchGrave.forEach(function (e) {
        if (e.graveYardId == graveYardId) {
            listOfGrave.push(e)
        }
    })
    generateGrave($("#grave"), width, height, graveYardId);
    updateColor();
}

function getGraveOfChurch() {
    var requestURL = contextPath + GET_GRAVE_OF_CHURCH;
    var requestMethod = "POST";
    $.ajax({
        url: requestURL,
        type: requestMethod,
        async: false,
        dataType: 'json',
        success: function (res) {
            listOfChurchGrave = res;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function generateGrave(target, width, height, graveYard) {
    console.log("OK")
    $("#grave div").remove(".grid-stack-item");
    var grid = target.data('gridstack');
    var isAdd = true;
    for (var i = 0; i < width; i++) {
        for (var k = 0; k < height; k++) {
            for (var count = 0; count < listOfGrave.length; count++) {
                if (listOfGrave[count].x == i && listOfGrave[count].y == k) {
                    grid.addWidget($('<div><div class="grid-stack-item-content graveItem  " data-id=' + listOfGrave[count].graveId + ' data-grave=' + count + ' data-status=' + listOfGrave[count].status + ' data-yard=' + graveYard + ' data-x' + listOfGrave[count].x + ' data-y=' + listOfGrave[count].y + '  </div> <div/>'), listOfGrave[count].x, listOfGrave[count].y, 1, 1);
                    isAdd = false;
                }
            }
            if (isAdd == true) {
                grid.addWidget($('<div><div class="grid-stack-item-content graveItem" data-yard=' + graveYard + ' data-x=' + i + ' data-y=' + k + '  data-status="0" </div> <div/>'), i, k, 1, 1);
            } else {
                isAdd = true;
            }
        }
    }


    $(".graveItem").on("click", function (x) {
        if ($(this).data("status") == 0) {
            $("#detailContext").fadeOut();
            initialRegisContext($(this));
            eventRegisterPopup(x, $("#regisContext"));

        } else {
            $("#regisContext").fadeOut();
            initialDetailContext($(this));
            eventRegisterPopup(x, $("#detailContext"))
        }


    })
}

function initialDetailContext(e) {
    var index = e.data("grave");
    console.log(listOfGrave);
    console.log(index);
    if (listOfGrave[index].image != null) {
        $("#image").attr("src", contextPath + "/product-images/" + listOfGrave[index].image);
    } else {
        $("#image").attr("src", contextPath + "/product-images/noimagefound.jpg");
    }

    $("#detailName").html(listOfGrave[index].name);
    $("#detailBirthday").html(listOfGrave[index].birthDay);
    $("#detailParish").html(listOfGrave[index].parish);
    $("#detailDeathDay").html(listOfGrave[index].deathDay);
    $("#detailHomeTown").html(listOfGrave[index].homeTown);
    $("#detailRegisName").html(listOfGrave[index].userName);
    $("#detailRegisPhone").html(listOfGrave[index].tel);
    var processBtn;
    var rejectBtn;
    if (listOfGrave[index].status == 2) {
        processBtn = $("#detailProcess");
        processBtn.html("Duyệt");
        processBtn.unbind("click");
        processBtn.bind("click", function () {
            approveGraveStatus(e, ACCEPT_TYPE)
        })

        rejectBtn = $("#detailReject");
        rejectBtn.html("Từ chối");
        rejectBtn.unbind("click");
        rejectBtn.bind("click", function () {
            approveGraveStatus(e, REJECT_TYPE)
        })
    } else {
        processBtn = $("#detailProcess");
        processBtn.html("Rút");
        processBtn.unbind("click");
        processBtn.bind("click", function () {
            approveGraveStatus(e, REJECT_TYPE)
        })

        rejectBtn = $("#detailReject");
        rejectBtn.html("Hủy");
        rejectBtn.unbind("click");
        rejectBtn.bind("click", function () {
            $("#detailContext").fadeOut();
        })
    }
}

function initialRegisContext(e) {
    $("#regisBtn").unbind("click");
    $("#regisBtn").bind("click", function () {
        regisGrave(e);
    })
}

function regisGrave(e) {
    var requestURL = contextPath + REGISTER_GRAVE;
    var requestMethod = "POST";
    var formData = new FormData($("#grave-form")[0]);
    formData.append("graveYardId", e.data("yard"));
    formData.append("positionX", e.data("x"));
    formData.append("positionY", e.data("y"));
    var requestData = formData;
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        processData: false,
        contentType: false,
        async: false,
        dataType: 'json',
        success: function (res) {

            console.log(res);
            e.data("status", res.status);
            e.data("id", res.graveId);
            e.data("grave", listOfGrave.length);
            listOfGrave.push(res);
            $("#regisContext").fadeOut();
            updateColor();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function approveGraveStatus(e, type) {
    var requestURL = contextPath + APPROVE_GRAVE_STATUS;
    var requestMethod = "POST";
    var requestData = {
        "graveId": e.data("id"),
        "statusType": type
    };
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        dataType: 'json',
        success: function (res) {
            e.data("status", res.status);
            updateColor()
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function updateColor() {
    $(".graveItem").each(function () {
        if ($(this).data("status") == 1) {
            $(this).css({"background-color": GRAVE_APPROVED_COLOR})
        } else if ($(this).data("status") == 2) {
            $(this).css({"background-color": GRAVE_WAITING_COLOR})
        } else {
            $(this).css({"background-color": GRAVE_NOT_INITIAL_COLOR})
        }
    })
}

function terminateEventCreateMenu() {

    $(document).bind('click', function (e) {
        if ($(e.target).prop("tagName").toUpperCase() == "SMALL") {
            return;
        }

        if (!(typeof $(e.target).attr('class') === "string" || $(e.target).attr('class') instanceof String
            )) {
            $(".graveContextMenu").fadeOut();
            return;
        }

        if (!($('div#graveYardInformation').has(e.target).length > 0 || ($(e.target).attr('class').toString()
                .indexOf('graveYardItem') >= 0))) {
            $("#graveYardInformation").fadeOut();
        }

        if (!($('div#regisContext').has(e.target).length > 0 || ($(e.target).attr('class').toString()
                .indexOf('graveItem') >= 0))) {
            $("#regisContext").fadeOut();
        }

        if (!($('div#detailContext').has(e.target).length > 0 || ($(e.target).attr('class').toString()
                .indexOf('graveItem') >= 0))) {
            $("#detailContext").fadeOut();
        }

    })
}
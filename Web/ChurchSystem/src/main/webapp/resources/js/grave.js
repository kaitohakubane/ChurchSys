/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */

var GET_GRAVE_YARD = "/manager/graveYard/Get";
var GENERATE_GRAVE_YARD = "/manager/graveYard/Generate";
var GENERATE_GRAVE = "/manager/grave/Generate";
var GET_GRAVE = "/manager/grave/Get";
var REGISTER_GRAVE = "/grave/Register";
var APPROVE_GRAVE_STATUS = "/manager/grave/Approve";
var ACCEPT_TYPE = 1;
var REJECT_TYPE = 0;
var GRAVE_NOT_INITIAL_COLOR = "#d8d2d2";
var GRAVE_APPROVED_COLOR = "#4288f1";
var GRAVE_WAITING_COLOR = "#f243b5";

var currentGraveYard;
var listOfGraveYard = [];
var listOfGrave = [];
var chosenPrototype = "";
var defaultMovePlus = 2;


$(document).ready(function () {
    generalInitial();
    getGraveYard();
})

function addNewCabinet(e) {
    var grid = e.data('gridstack');

    var node = {x: 0, y: 0, width: 1, height: 1}

    grid.addWidget($('<div><div class="grid-stack-item-content" >Mo thang Kiet<br/> Sinh năm 1995 mất năm 2080</div><div/>'),
        node.x, node.y, node.width, node.height);

}

function initial(width, height, e) {
    var grid = e.data('gridstack');
    var list = [];
    var node;

    loadCabinet(width, height);

    listOfGraveYard.forEach(function (e) {
        grid.addWidget($('<div><div class="grid-stack-item-content cabinet" ></div><div/>'),
            e.x, e.y, e.width, e.height);
    })

    grid.addWidget($('<div><div class="grid-stack-item-content gate" data-id="gate" ></div><div/>'),
        width - 2, height - 1, 1, 1);

    grid.addWidget($('<div><div class="grid-stack-item-content statue" data-id="statue" ></div><div/>'),
        (width - 1) / 2, 1, 2, 1);

    $('.grid-stack-item-content').each(function (e) {
        if ($(this).data("id") == "statue") {
            $(this).html("Tượng chúa")
        } else if ($(this).data("id") == "gate") {
            $(this).html("Cổng")
        } else {
            $(this).html("Tủ " + (e + 1))
            $(this).data("id", (e + 1))
        }

    })


}

function loadGrave(width, height, target) {
    var node;
    var grid = target.data('gridstack');
    for (var j = 0; j < height; j += 2) {
        for (var i = 0; i < width; i += 2) {
            node = {x: i, y: j, width: 2, height: 2}
            listOfGrave.push(node);
        }
    }
    listOfGrave.forEach(function (e) {
        grid.addWidget($('<div><div class="grid-stack-item-content grave" ></div><div/>'),
            e.x, e.y, e.width, e.height);
    })
    $('.grave').each(function (e) {
        $(this).html("Tây Môn Xuy Tuyết</br>20-7-1985 - 19-5-2017")

    })
}

function loadCabinet(width, height) {
    var node;
    for (var j = 0; j < height; j++) {
        if (j == 0 || j == (height - 1)) {
            for (var i = 0; i < width; i++) {
                if (j == height - 1 && i == width - 2) {

                } else {
                    node = {x: i, y: j, width: 1, height: 1}
                    listOfGraveYard.push(node);
                }

            }
        }
        else {
            node = {x: 0, y: j, width: 1, height: 1}
            listOfGraveYard.push(node);
            node = {x: width - 1, y: j, width: 1, height: 1}
            listOfGraveYard.push(node);
        }
    }

}

function generateGraveYard(target) {
    var grid = target.data('gridstack');
    listOfGraveYard.forEach(function (e) {
        if (e.status < 3) {
            grid.addWidget($('<div><div class="grid-stack-item-content graveYardItem " data-id=' + e.id + ' data-free=' + e.graveAvailable + ' data-status=' + e.status + ' data-graveWi=' + e.width + ' data-graveHe=' + e.height + '  >' + e.name + '</div><div/>'), e.x, e.y, 1, 1);
        } else if (e.status == 3) {
            grid.addWidget($('<div><div class="grid-stack-item-content gate" data-id=' + e.id + ' data-status=' + e.status + '>' + e.name + '</div><div/>'), e.x, e.y, 1, 1);
        } else {
            grid.addWidget($('<div><div class="grid-stack-item-content statue" data-id=' + e.id + ' data-status=' + e.status + '>' + e.name + '</div><div/>'), e.x, e.y, 2, 1);
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

    $(".graveYardItem").on("click", function (x) {
        contextMenuInitial($(this))
        eventRegisterPopup(x, $("#graveYardInformation"));
    })
}

function contextMenuInitial(e) {
    $("#contextName").val(e.html());

    var width = e.data("graveWi");
    var height = e.data("graveHe");
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
    }
    $("#contextFree").val(data);
    var btn = $("#contextBtn");
    if (e.data("status") == 0) {
        btn.html("Khởi tạo");
        btn.unbind("click");
        btn.bind("click", function () {
            $("#graveYardPopup").modal('show');
            $("#intialGraveYard").on("click", function () {
                setupGraveYard(e, width, height)
            })
            e.removeClass("graveYardNotInitial");
            e.addClass("graveYardInitial");
        })
    } else {
        btn.html("Xem")
        btn.unbind("click");
        btn.bind("click", function () {
            getGrave(e.data("id", width, height))
            currentGraveYard=e.data("id");
        })
        $('.nav-tabs a[href="#step2"]').tab('show');
        $('.nav-tabs a[href="#step2"]').html('Sơ đồ ' + e.html());
    }
}
function prototypePopupInitial() {
    $("#prototypeWidth").val("12");
    $("#prototypeHeight").val("6");
}

function generalInitial() {
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
        disableResize: true
    }
    $('.grid-stack').gridstack(options);

    $("#load-grid").on("click", function () {
        initial(4, 3, $(".graveYard"));
        loadGrave(12, 5, $(".grid-stack.cabinet"))
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

    prototypePopupInitial();
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
    var requestData = {
        "graveYardId": graveYardId,
        "width": width,
        "height": height
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        success: function (res) {
            $("#graveYardPopup").modal('hide');
            e.data("graveHe", res.height);
            e.data("graveWi", res.width);
            e.data("status", res.status);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}


function getGrave(graveYardId, width, height) {
    var requestURL = contextPath + GET_GRAVE;
    var requestMethod = "POST";
    var requestData = {
        "graveYardId": graveYardId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        dataType: 'json',
        success: function (res) {
            listOfGrave = res;
            generateGrave($("#grave"), width, height)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}

function generateGrave(target, width, height) {
    var grid = target.data('gridstack');
    var isAdd = true;
    for (var i = 0; i < width; i++) {
        for (var k = 0; k < height; k++) {
            for (var count = 0; count < listOfGrave.length; count++) {
                if (listOfGrave[count].x == i && listOfGrave[count] == k) {
                    grid.addWidget($('<div><div class="grid-stack-item-content graveItem  " data-id=' + listOfGrave[count].graveId + ' data-grave=' + count + ' data-status=' + listOfGrave[count].status + ' </div> <div/>'), listOfGrave[count].x, listOfGrave[count].y, 1, 1);
                    isAdd = false;
                }
            }
            if (isAdd == true) {
                grid.addWidget($('<div><div class="grid-stack-item-content graveItem " data-status="0" </div> <div/>'), i, k, 1, 1);
            } else {
                isAdd = true;
            }
        }
    }


    $(".graveItem").on("click", function (x) {
        if ($(this).data("status") == 0) {
            eventRegisterPopup(x, $("#regisContext"));
            $("#detailContext").fadeOut();
            initialRegisContext($(this));
        } else {
            initialDetailContext($(this));
            eventRegisterPopup(x, $("#detailContext"))
            $("#regisContext").fadeOut();
        }


    })
}

function initialDetailContext(e) {
    var index = e.data("grave");
    $("#detailName").html(listOfGrave[index].name);
    $("#detailBirthday").html(listOfGrave[index].birthDay);
    $("#detailParish").html(listOfGrave[index].parish);
    $("#detailDeathDay").html(listOfGrave[index].deathDay);
    $("#detailHomeTown").html(listOfGrave[index].homeTown);
    $("#detailRegisName").html(listOfGrave[index].homeTown);
    $("#detailRegisPhone").html(listOfGrave[index].homeTown);
    $("#detailRegisMail").html(listOfGrave[index].homeTown);
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
    $("#regisBtn").on("click", function () {
        regisGrave(e);
    })
}

function regisGrave(e) {
    var requestURL = contextPath + REGISTER_GRAVE;
    var requestMethod = "POST";
    var formData = new FormData($("#grave-form")[0]);
    formData.append("graveYardId", e.data("id"))
    var requestData = formData;
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        dataType: 'json',
        success: function (res) {
            listOfGrave.push(res);
            e.data("status", res.status);
            e.data("id", res.graveId);
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
            $(this).css("background-color", GRAVE_APPROVED_COLOR)
        } else if ($(this).data("status") == 2) {
            $(this).css("background-color", GRAVE_WAITING_COLOR)
        } else {
            $(this).css("background-color", GRAVE_NOT_INITIAL_COLOR)
        }
    })
}

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */

var GET_GRAVE_YARD = "/manager/grave/graveYard/Get"

var listOfGraveYard = [];
var listOfGrave = [];
var chosenPrototype;

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
        if (e.status == 1) {
            grid.addWidget($('<div><div class="grid-stack-item-content graveYardItem" data-id=' + e.id + ' data-status=' + e.status + '>' + e.name + '</div><div/>'), e.x, e.y, 1, 1);
        }

    })
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
    })
}

function generatePrototype() {
    var requestURL = contextPath + GET_GRAVE_YARD;
    var requestMethod = "POST";

    $.ajax({
        url: requestURL,
        type: requestMethod,
        processData: false,
        dataType: 'json',
        success: function (res) {
            generateGraveYard($("#graveYard"));
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });

}
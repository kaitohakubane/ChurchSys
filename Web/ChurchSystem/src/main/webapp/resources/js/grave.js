/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */

var listOfCabinet=[];
var listOfGrave=[];
$(document).ready(function () {
    var options = {
        float: true
    }
    $('.grid-stack').gridstack(options);
    $("#add-room").on("click", function () {
        addNewCabinet($(".room"));
    })

    $("#load-grid").on("click", function () {
        loadCabinet($(".room"));
        loadGrave(12,5,$(".grid-stack.cabinet"))
    })

})

function addNewCabinet(e) {
    var grid = e.data('gridstack');

    var node = {x: 0, y: 0, width: 1, height: 1}

    grid.addWidget($('<div><div class="grid-stack-item-content" >Mo thang Kiet<br/> Sinh năm 1995 mất năm 2080</div><div/>'),
        node.x, node.y, node.width, node.height);

}

function loadCabinet(e) {
    var grid = e.data('gridstack');
    var list = [];
    var node;

    initalCabinet(12,6);

    listOfCabinet.forEach(function (e) {
        grid.addWidget($('<div><div class="grid-stack-item-content cabinet" ></div><div/>'),
            e.x, e.y, e.width, e.height);
    })


    $('.grid-stack-item-content').each(function (e) {
        $(this).html("Tủ " + e)
        $(this).data("id", e)
    })



}

function loadGrave(width,height,target){
    var node;
    var grid = target.data('gridstack');
    for (var j = 0; j < height; j+=2) {
            for (var i = 0; i < width; i+=2) {
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

function initalCabinet(width,height){
    var node;
    for (var j = 0; j < height; j++) {
        if (j == 0 || j == (height - 1)) {
            for (var i = 0; i < width; i++) {
                node = {x: i, y: j, width: 1, height: 1}
                listOfCabinet.push(node);
            }
        } else {
            node = {x: 0, y: j, width: 1, height: 1}
            listOfCabinet.push(node);
            node = {x: width-1, y: j, width: 1, height: 1}
            listOfCabinet.push(node);
        }
    }
    listOfCabinet.push({x:(width-1)/2,y:1,width:2,height:1})
}



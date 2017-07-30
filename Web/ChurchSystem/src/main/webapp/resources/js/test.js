/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */

$(document).ready(function () {
    var options = {
        float: true
    }
    $('.grid-stack').gridstack(options);
    $("#add-room").on("click", function () {
        addNewCabinet($(".room"));
    })


})

function addNewCabinet(e) {
    var grid = e.data('gridstack');
    var list=[];
    var node;
    for(var i=0;i<5;i++){
        var node =  {x: i, y: 0, width: 1, height: 1}
        list.push(node);
        node =  {x: i, y: 5, width: 1, height: 1}
        list.push(node)
    }
    for(var i=0;i<5;i++){
        node =  {x: 0, y: i, width: 1, height: 1}
        list.push(node);
        node =  {x: 5, y: i, width: 1, height: 1}
        list.push(node);
    }

    grid.addWidget($('<div><div class="grid-stack-item-content" >Mo thang Kiet<br/> Sinh năm 1995 mất năm 2080</div><div/>'),
        node.x, node.y, node.width, node.height);

}
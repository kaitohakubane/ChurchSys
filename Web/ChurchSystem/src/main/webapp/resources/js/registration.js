
SCHEDULE_URL="/admin/schedule";
$(document).ready(function () {
    $('#datatable').DataTable(
    );


    popupInitial();
})

function popupInitial() {
    $("#room").prop("disabled",true);
    $("#manager").prop("disabled",true);
    $("#manager").disabled = true;
    $("#slot").on('change', function () {
        $("#room").prop("disabled",false);
        $("#manager").prop("disabled",false);
    })
    $("#confirm-btn").on("click",function(){
        window.location.href=contextPath+SCHEDULE_URL;
    })

}






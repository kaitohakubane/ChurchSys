/**
 * Created by hungmcse61561-admin on 8/5/2017.
 */
var ADD_CHURCH_URL = "/admin/new-church";
$(document).ready(function(){
    $("#addChurch").on("click", function () {
        window.location.href = contextPath + ADD_CHURCH_URL;
    })
})
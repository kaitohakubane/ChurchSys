/**
 * Created by hungmcse61561-admin on 8/5/2017.
 */

var CREATE_CHURCH_URL = "/admin/add-church";


var SUCCESS_STATUS = "Thành công!";
var FAILURE_STATUS = "Thất bại!";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";

$(document).ready(function () {
    $('#us3').locationpicker({
        location: {
            latitude: 16.0759032,
            longitude: 108.16987130000007
        },
        radius: false,
        inputBinding: {
            latitudeInput: $('#us3-lat'),
            longitudeInput: $('#us3-lon'),
            locationNameInput: $('#us3-address')
        },
        enableAutocomplete: true,
    });

    $('#locationModal').on('shown.bs.modal', function () {
        $('#us3').locationpicker('autosize');
    });
})


$("#btnOK").on('click', function () {
    $("#churchAddress").val($("#us3-address").val());
    $("#locationModal").modal('hide');
})

$("#btnSave").on('click', function () {
    addChurch();
})


function addChurch() {
    var requestURL = contextPath + CREATE_CHURCH_URL;
    var requestMethod = "POST";
    var requestData = {
        'churchName': $("#churchName").val(),
        'tel': $("#churchTel").val(),
        'address': $("#churchAddress").val(),
        'mail': $("#churchEmail").val(),
        'description': $("#churchDescription").val(),
        'longitude': $("#us3-lon").val(),
        'latitude': $("#us3-lat").val(),
    }
    console.log(requestData);
    $.ajax({
        // url: requestURL,
        // type: requestMethod,
        // data: JSON.stringify(requestData),
        // contentType: 'application/json',
        // processData: false,

        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    });
}
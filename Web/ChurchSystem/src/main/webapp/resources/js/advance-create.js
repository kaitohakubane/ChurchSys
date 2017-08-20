$(document).ready(function () {
    subjectDropdownEvent($('#category'));
    $('#category').change(function () {
        var firstVal = null;
        var categoryValue = $(this).val();
        $('#eventType option').each(function () {
            var item = $(this);
            if (!(item.data("category") == categoryValue)) {
                item.hide();
            } else {
                if (firstVal == null) {
                    firstVal = item.val();
                }
                item.show();
            }
        })
        $('#eventType').val(firstVal);
    })
})


$("#hiding-form").hide();

$("input:radio[name=repeat]").on('ifChanged', function () {
    var selectedValue = $(this).val();
    if (selectedValue == "showForm") {
        $("#hiding-form").show();
    }
    else if (selectedValue == "hideForm") {
        $("#hiding-form").hide();
    }
});

$('#option-select').on('change', function () {
    var selected = $('#option-select option:selected');
    if (selected.length > 0) {
        var result = '';
        selected.each(function () {
            result += $(this).val();
        });
        $('#option-result').html(result);
    }
});

$("#week-selected").hide();
$("#month-selected").hide();

$('#option-select').on('change', function () {
    var selected = $(this).val();
    if (selected == "days") {
        $("#week-selected").hide();
        $("#month-selected").hide();
    }
    else if (selected == "weeks") {
        $("#week-selected").show();
        $("#month-selected").hide();
    }
    else if (selected == "months") {
        $("#week-selected").hide();
        $("#month-selected").show();
    }
    else if (selected == "years") {
        $("#week-selected").hide();
        $("#month-selected").hide();
    }
});

$(document).ready(function () {
    $("#advance-starDay").datepicker();
    $("#advance-starDay").datepicker('option', 'dateFormat', 'yy-mm-dd');
})


function subjectDropdownEvent(category) {
    var firstVal = null;
    var categoryValue = category.val();
    $('#eventType option').each(function () {
        var item = $(this);
        if (!(item.data("category") == categoryValue)) {
            item.hide();
        } else {
            if (firstVal == null) {
                firstVal = item.val();
            }
            item.show();
        }
    })
    $('#eventType').val(firstVal);
}
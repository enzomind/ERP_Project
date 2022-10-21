
$(document).ready(function () {

    if($("#state").val() == "승인"){
        $("#notDone").hide();
    }

    if($("#state").val() == "반려"){
        $("#notDone").hide();
    }

    if($("#state").val() == "미결재"){
        $("#done").hide();
    }

    var date = new Date()
    var today= date.toLocaleDateString().slice(0,12).replaceAll('. ','-')

    $('#ybtn').click(function () {
        $("#state").val("승인");
        $("#time").val(today);
    })

    $('#nbtn').click(function () {
        $("#state").val("반려");
        $("#time").val(today);
    })

});
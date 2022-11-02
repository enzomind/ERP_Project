
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

    $('#btn').click(function () {
        if ($("#state").val() == "미결재") {
            alert("승인여부를 선택해주세요");
            return false;
        }

        if ($("#state").val() == "승인" || $("#state").val() == "반려"){
            if (confirm("승인여부를 반영합니다") == true) {    //확인
            } else {   //취소
                return false;
            }
        }
    })

});


$(document).ready(function (){
    var result = false;

    //테이블 행 클릭하면 마지막 td를 찾아서 result에 나타내고 모달창을 닫음
    $('#dataTable tr').click(function(){
        var tr = $(this).find("td:last");
        $("#result").text(tr.text());
        result = true;
        $('#modal1').modal('hide')
    })


    //경고창 띄우기
    $('#submit').click(function (){
        if(result == false){
            alert("결재자를 선택해주세요");
            return false;
        }
    })

    $('#submit').click(function (){
        if($('#title').val().length < 1){
            alert("제목을 입력해주세요.");
        return false;
        }
    })

    $('#submit').click(function (){
        if($('#select1').val() == "선택" || $('#summary').val().length < 1 || $('#select2').val() == "선택" || $('#sum').val().length < 1 ){
            alert("지출결의 내역을 한 건이라도 작성해야 합니다.");
            return false;
        }
    })

    $('#submit').click(function (){
        if($('#file').val().length < 1){
            alert("증빙서류를 업로드해주세요.");
            return false;
        }
    })

});



$(document).ready(function (){

    //날짜 화면 표시
    var date = new Date()
    var year = date.getFullYear()
    var month = date.getMonth() + 1
    var day = date.getUTCDate()
    var today = year + '-' + month + '-' + day
    $('#date').text(today);


    //테이블 행 클릭하면 마지막 td를 찾아서 result에 나타내고 모달창을 닫음
    var result = false;
    $('#dataTable tr').click(function(){
        var tr = $(this).find("td:last");
        $("#appr").val(tr.text());
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
        if($('#exp_title').val().length < 1){
            alert("제목을 입력해주세요.");
        return false;
        }
    })

    $('#submit').click(function (){
        if($('#det_code').val() == "선택" || $('#remk').val().length < 1 || $('#com_acc').val() == "선택" || $('#expense').val().length < 1 ){
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


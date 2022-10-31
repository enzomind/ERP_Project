
$(document).ready(function () {

        //날짜 화면 표시
        var date = new Date()
        var year = date.getFullYear()
        var month = date.getMonth() + 1
        var day = date.getUTCDate()
        var today = year + '-' + month + '-' + day
        $('#date').text(today);

        //테이블 행 클릭하면 마지막 td를 찾아서 result에 나타내고 모달창을 닫음
        var result = false;
        $('#dataTable tr').click(function () {
            var tr1= $(this).find("td:first");
            var tr2= $(this).find("td:last");
            $("#appr1").val(tr2.text());
            $("#apprId1").val(tr1.text());
            $("#apprText").text(tr2.text());
            result = true;
            $('#modal1').modal('hide');
        })

        //입력 하나만 받는애들 value 동일하게 맞추기
        $('#submit').click(function () {
            //title
            const titleVal = $("#exp_title1").val()
            $('#exp_title2').val(titleVal);
            $('#exp_title3').val(titleVal);
            $('#exp_title4').val(titleVal);
            $('#exp_title5').val(titleVal);

            //appr
            const apprVal = $("#appr1").val()
            $('#appr2').val(apprVal);
            $('#appr3').val(apprVal);
            $('#appr4').val(apprVal);
            $('#appr5').val(apprVal);

            const apprIdVal = $("#apprId1").val()
            $('#apprId2').val(apprIdVal);
            $('#apprId3').val(apprIdVal);
            $('#apprId4').val(apprIdVal);
            $('#apprId5').val(apprIdVal);

            //file
            const fileVal = $("#file").val()
            $('#file2').val(fileVal);
            $('#file3').val(fileVal);
            $('#file4').val(fileVal);
            $('#file5').val(fileVal);

        })



        //경고창 띄우기
        $('#submit').click(function () {
            if (result == false) {
                alert("결재자를 선택해주세요");
                return false;
            }
            if ($('#exp_title1').val().length < 1) {
                alert("제목을 입력해주세요.");
                return false;
            }
            if($('#det_code1').val() == "선택" || $('#remk1').val().length < 1 || $('#com_acc1').val() == "선택" || $('#expense1').val() <= 0){
                alert("지출결의 내역을 한 건이라도 작성해야 합니다.");
                return false;
            }
            if($('#file').val().length < 1){
                alert("증빙서류를 업로드해주세요.");
                return false;
            }
        })


    });

//alert 추가 : 비용이 음수일 경우"비용은 음수일 수 없습니다", (2번째행부터) 다안채우고 비용만 채웠을경우, 비용을 비워뒀을경우


const fileInput = document.getElementById("file");
fileInput.onchange = (e) => {
    const selectFile = fileInput.files[0];
    const fileReader = new FileReader();

    fileReader.readAsDataURL(selectFile);
    fileReader.onload = function (){
        document.getElementById("preview").src = fileReader.result;
    };

}
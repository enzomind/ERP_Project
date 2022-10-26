window.onload = () => {
    findEmpName();
}

$(document).ready(function () {
    $('#password').on("propertychange change paste input", function() {
        // $('#input-pw').show()
        let pw = $('#password').val()
        if (pw === null || pw === '' || pw === undefined) {
            alert("비밀번호를 입력해주세요.")
            $('#update').attr("disabled", true);
            $('#delete').attr("disabled", true);
        } else if (pw === password) {
            $('#update').attr("disabled", false);
            $('#delete').attr("disabled", false);
        } else if(pw !== password) {
            $('#update').attr("disabled", true);
            $('#delete').attr("disabled", true);
        }
    })

});
// th:onclick="|location.href='@{/board/updateBoard(boardNum=${view.boardNum})}'|"

function findEmpName() {

    let empId = {
        empId: $('#epId').text()
    }

    $.ajax({

        url: "/board/searchEmpName", // 클라이언트가 요청을 보낼 서버의 URL 주소
        data:empId,                // HTTP 요청과 함께 서버로 보낼 데이터
        type: "POST",                           // HTTP 요청 방식(GET, POST)s
        dataType: "json",                       // 서버에서 보내줄 데이터의 타입

        success: function (data) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'data'는 응답받은 데이터이다.

            console.log(data)
            $('#writer').val(`${data[0].emp_name}`);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            alert("데이터를 불러오는 도중에 오류가 발생하였습니다.")
        }
    });

}
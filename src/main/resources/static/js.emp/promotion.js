$(document).ready(function () {

    $('#promotion').click(function () {
        let promoWho = $(this).parent().siblings('.empId').html()

        let ProData = {
            empId: promoWho
        }

        $.ajax({

            url: "/emp/searchWhoPro", // 클라이언트가 요청을 보낼 서버의 URL 주소
            data: ProData,                // HTTP 요청과 함께 서버로 보낼 데이터
            type: "POST",                           // HTTP 요청 방식(GET, POST)s
            dataType: "json",                       // 서버에서 보내줄 데이터의 타입

            success: function (data) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'data'는 응답받은 데이터이다.


                console.log(data)
                i = 0;
                $('.emNum').html(`${data[i].emp_id}`)
                $('.emName').html(`${data[i].emp_name}`)
                $('.hqNo').html(`${data[i].hq_name}`)
                $('.depNo').html(`${data[i].dep_name}`)
                $('#position').val(`${data[i].job_name}`)
                $('#salary').val(`${addComma(data[i].salary)}원`)

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("데이터를 불러오는 도중에 오류가 발생하였습니다.")
            }
        });
    });
    $('#confirmFirst').click(function () {

        let proPosi = $('#proPosition').val();
        let proSal = $('#proSalary').val();


        console.log(proPosi)
        if (proPosi =='none') {
            $('#noInfo').show()
        } else if (proSal === null || proSal === '' || proSal === undefined) {
            $('#noInfo').show()
        } else {
            $('#noInfo').hide()
            $("#sss").attr('id','send1');
        }
    });

    $('#finalConfirm').click(function () {
        let emNum = $('.emNum').html();
        let proPosi = $('#proPosition').val();
        let proSal = $('#proSalary').val();

        let ProData = {
            empId: emNum,
            jobCode: proPosi,
            salary: uncomma(proSal)
        }
        console.log(ProData);

        $.ajax({

            url: "/emp/confirmPromotion", // 클라이언트가 요청을 보낼 서버의 URL 주소
            data: ProData,                // HTTP 요청과 함께 서버로 보낼 데이터
            type: "POST",                           // HTTP 요청 방식(GET, POST)s
            dataType: "json",                       // 서버에서 보내줄 데이터의 타입

            success: function (data) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'data'는 응답받은 데이터이다.
                alert("승진 처리 완료")
                i = 0;
                $('#position').val(`${data[i].job_name}`)
                $('#salary').val(`${addComma(data[i].salary)}원`)

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.

            }

        });

    });


});

function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}
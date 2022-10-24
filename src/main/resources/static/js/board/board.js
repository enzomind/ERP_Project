$(document).ready(function () {

    $('#search').click(function () {

        let boarddata = {
            start: $('#start').val(),
            end: $('#end').val(),
            title : $('#title').val()
        }

        $.ajax({

            url: "/board/searchBoard", // 클라이언트가 요청을 보낼 서버의 URL 주소
            data:boarddata,                // HTTP 요청과 함께 서버로 보낼 데이터
            type: "POST",                           // HTTP 요청 방식(GET, POST)s
            dataType: "json",                       // 서버에서 보내줄 데이터의 타입

            success: function (data) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'data'는 응답받은 데이터이다.

                let board = '';
                console.log(data)

                $.each(data, function (index, item) {
                    console.log(item)
                    board += `
                                <tr th:onclick="|location.href='@{/info/viewinfo(ntcNum=${item.boardNum})}'|" style="cursor:pointer;">
                                <td>${item.boardNum}</td>
                                <td name="title">${item.title}</td>
                                <td name="writer">${item.writer}</td>
                                <td name="date">${item.date}</td>
                                <td id="cbnNum">${item.cbnNum}</td>
                            </tr>
                        `;
                });

                $('.info-table').empty().append(board)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("데이터를 불러오는 도중에 오류가 발생하였습니다.")
            }
        });

    });
});


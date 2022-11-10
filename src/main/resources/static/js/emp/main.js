$(document).ready(function () {
    // $('#collapseTwo').stop().slideDown(200);
    $('#search').click(function () {

        let empdata = {
            hqName: $('#hdqrt').val(),
            depName: $('#dep').val(),
            jobName: $('#pstn').val(),
            start: $('#start').val(),
            end: $('#end').val(),
            empName: $('#empName').val()
        }

        $.ajax({

            url: "/emp/searchemp", // 클라이언트가 요청을 보낼 서버의 URL 주소
            data: empdata,                // HTTP 요청과 함께 서버로 보낼 데이터
            type: "POST",                           // HTTP 요청 방식(GET, POST)s
            dataType: "json",                       // 서버에서 보내줄 데이터의 타입

            success: function (data) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'data'는 응답받은 데이터이다.

                let promo = '';
                console.log(data)
                $('.col-sm-12').css("margin-top", '20px');

                $('#dataTable').DataTable().destroy();
                $('tbody').empty();

                $.each(data, function (index, item) {
                    promo += `
                            <tr>
                                <td class="empId">${item.emp_id}</td>
                                <td>${item.auth_name}</td>
                                <td>${item.job_name}</td>
                                <td>
                                    <button data-toggle="modal" class="payname" data-target="#ecmodal4"
                                            style="background: none; border: none; color: #4e73df;"
                                          >${item.emp_name}
                                    </button>
                                </td>
                                <td>${item.birth}</td>
                                <td>${item.hq_name}</td>
                                <td>${item.dep_name}</td>
                                <td>
                                    <button class="btn btn-outline-primary promotion" data-toggle="modal"
                                            data-target="#ecmodal3" >설정
                                    </button>
                                </td>
                            </tr>   
                        `;
                });
                $('tbody').append(promo)
                table = $('#dataTable').DataTable( {
                    searching: false
                } );
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("데이터를 불러오는 도중에 오류가 발생하였습니다.")
            }
        });

    });


});

// <tr>
//     // <td className="empId">${item.emp_id}</td>
//     // <td>${item.auth_name}</td>
//     // <td>${item.job_name}</td>
//     // <td>
//     // <button data-toggle="modal" data-target="#ecmodal4"
//                 style="background: none; border: none; color: #4e73df;" class="payname">${item.emp_name}
//         </button>
//     </td>
//     <td>${item.birth}</td>
//     <td>${item.hq_name}</td>
//     <td>${item.dep_name}</td>
//     <td>
//         <button class="btn btn-outline-primary" data-toggle="modal"
//                data-target="#ecmodal3">설정
//         </button>
//     </td>
// </tr>  <tr>
//                                      //     <td class="empId">${item.emp_id}</td>
//                                      //     <td>${item.auth_name}</td>
//                                      //     <td>${item.job_name}</td>
//                                      //     <td>
//                                      //         <button data-toggle="modal" data-target="#ecmodal4"
//                                      //                 style="background: none; border: none; color: #4e73df;" class="payname">${item.emp_name}
//                                      //         </button>
//                                      //     </td>
//                                      //     <td>${item.birth}</td>
//                                      //     <td>${item.hq_name}</td>
//                                      //     <td>${item.dep_name}</td>
//                                      //     <td>
//                                      //         <button class="btn btn-outline-primary" data-toggle="modal"
//                                      //                data-target="#ecmodal3">설정
//                                      //         </button>
//                                      //     </td>
//                                      // </tr>
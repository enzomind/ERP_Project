//** 담당 : 오윤섭
//** 설명 : 메인 페이지 대시보드 데이터 출력하기 위한 함수들 정의

//생일자 대시보드 데이터 가져오는 함수
function getBirthDash() {
    fetch('/api/getBirthDash').then(response => {
        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        //당월 기준 데이터 출력위해 날짜 객체 생성
        const instantDate = new Date();
        const month = instantDate.getMonth() + 1;
        //타이틀 요소 생성
        const titleHtml = `${month}월 생일자`;
        //콘텐츠 요소 초기화
        let dashHtml = '';

        //데이터가 없다면 생일자가 없으므로 noData 처리
        //당월 생일자가 3명 이상이라면 아무개 외 N명 <- 으로 노출되도록 처리
        //당월 생일자 2명까진 풀 노출
        if (!json) {
            dashHtml = '-';
        } else if (json.length >= 3){
            dashHtml = `${json[0]} 외 ${json.length - 1}명`;
        } else {
            dashHtml = `${json}`;
        }

        $("#birthDash").empty().append(dashHtml);
        $("#birthTitle").empty().append(titleHtml);
    })
}

//결재 대기 현황 API
function getExpreportDash() {
    fetch('/api/getExpreportDash').then(response => {
        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        //데이터가 없으면 모두 완료건으로 처리, else 건 출력
        if(!json) {
            html = '모두 완료!';
        } else {
            html = `${json}건`;
        }
        $("#expreportDash").empty().append(html);
    })
}

//전체 직원 수 현황 API
function getEmpDash() {
    fetch('/api/getEmpDash').then(response => {
        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        $("#empDash").empty().append(`${json}명`);
    })
}


//당월 입사자 현황 API
function getHireDash() {
    fetch('/api/getHireDash').then(response => {
        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        if(!json) {
            html = '0명';
        } else {
            html = `${json}명`;
        }
        $("#hireDash").empty().append(html);
    })
}



//휴가자 현황 API
function getCalInfo() {
    $(function () {
        var request = $.ajax({
            url: "/main/getCalAll",
            method: "GET",
            dataType: "json"
        });
        //요청 완료 시, fullCalendar 라이브러리 구성
        request.done(function (data) {
            const calendarEl = document.getElementById('calendar');
            let calendar = new FullCalendar.Calendar(calendarEl, {

                //툴바, 언어, 달력 종류 등 설정
                headerToolbar: {
                    left: 'today',
                    center: 'title',
                    right: 'prev next'
                },
                initialView: 'dayGridMonth',
                locale: "ko",
                dayMaxEvents: true,
                events: data,
                contentHeight: 500
            });
            //설정끝나면 렌더링
            calendar.render();
        })
        //요청 실패 시, 얼럿
        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });
    });
}

//공지사항 대시 API
function getNoticeDash() {
    fetch('/api/getNoticeDash').then(response => {
        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        //데이터가 없다면 noData 처리
        if(!json.length) {
            html = '<td colspan="3">등록된 공지사항이 없습니다.</td>';
        } else {
            json.forEach((obj) => {
                html += `
                <tr style="cursor:pointer;" onclick="location.href='http://localhost:8080/info/viewinfo?ntcNum='+${obj.ntcNum}" onmouseover="this.style.background='whitesmoke'" onmouseout="this.style.background='white'" >
                    <td>${obj.ntcNum}</td>
                    <td align="left">${obj.title}</td>
                    <td>${obj.date}</td>
                </tr>
            `;
            })
        }
        $("#noticeDash").empty().append(html);
    })
}

//페이지 인입 시, 함수들 호출
window.onload = () => {
    getCalInfo();
    getHireDash();
    getEmpDash();
    getExpreportDash();
    getNoticeDash();
    getBirthDash();
}
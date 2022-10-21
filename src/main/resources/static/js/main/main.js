window.onload = () => {

    getCalInfo();
    getHireDash();
    getEmpDash();
    getExpreportDash();
    getNoticeDash();
}

//결재 대기 현황
function getExpreportDash() {

    fetch('/main/getExpreportDash').then(response => {

        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        if(!json) {
            html = '<div>모두 완료!</div>';
        } else {
            html = `<div>${json}건</div>`;
        }

        $("#expreportDash").empty().append(html);
    })
}


//전체 직원 수 현황
function getEmpDash() {

    fetch('/main/getEmpDash').then(response => {

        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        if(!json) {
            html = '<div>0명 뭐임 ㄹㅇ?</div>';
        } else {
            html = `<div>${json}명</div>`;
        }

        $("#empDash").empty().append(html);
    })
}


//당월 입사자 현황
function getHireDash() {

    var instantDate = new Date();
    var setMonth = instantDate.getMonth() + 1;

    fetch(`/main/getHireDash/${setMonth}`).then(response => {

        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        if(!json) {
            html = '<div>0명</div>';
        } else {
            html = `<div>${json}명</div>`;
        }

        $("#hireDash").empty().append(html);
    })
}



//휴가자 현황
function getCalInfo() {

    $(function () {
        var request = $.ajax({
            url: "/main/getCalAll",
            method: "GET",
            dataType: "json"
        });

        request.done(function (data) {
            console.log(data);

            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {

                headerToolbar: {
                    left: 'today',
                    center: 'title',
                    right: 'prev next'
                },
                initialView: 'dayGridMonth',
                locale: "ko",
                dayMaxEvents: true,
                events: data

            });

            calendar.render();

        })

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });

    });
}

//공지사항 대시
function getNoticeDash() {

    fetch('/main/getNoticeDash').then(response => {

        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        if(!json.length) {
            html = '<td colspan="3"> 등록된 공지사항이 없습니다.</td>';
        } else {
            json.forEach((obj) => {

                var num = obj.ntcNum;

                html += `
                <tr style="cursor:pointer;" onclick="location.href='http://localhost:8080/info/viewinfo?ntcNum='+${num}" onmouseover="this.style.background='whitesmoke'" onmouseout="this.style.background='white'" >
                    <td>${num}</td>
                    <td>${obj.title}</td>
                    <td>${obj.date}</td>
                </tr>
            `;
            })
        }

        $("#noticeDash").empty().append(html);
    })
}
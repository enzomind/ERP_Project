//** 담당 : 오윤섭
//** 설명 : 회계전표 대시보드 및 리스트들을 출력하기 위한 함수들 정의

//기간 조회를 위한 공통 함수(defaultPeriodSet)의 로케이션값 전역 설정
let setLocation = 'acc';

//페이지 인입 시, 기간(당일 날짜까지 7일) 조회 기본값을 가져오기 위해 아래 함수 호출
window.onload = () => {
    defaultPeriodSet(setLocation);
}

//회계전표 페이지의 [검색] 버튼 클릭 시, search 함수 호출
document.getElementById('dateSearchBtn').addEventListener('click', search);

//사용자 설정 기간 조회
function search() {

    //각 날짜 세팅값을 변수에 저장하고 값 여부에 따라 얼럿 호출 또는 gateway 함수 호출
    const setStartDate = document.getElementById('searchSDate').value;
    const setEndDate = document.getElementById('searchEDate').value;

    if(setStartDate === '' && setEndDate === ''){
        alert('검색하실 날짜를 선택해주세요.')
    }else {
        //정의해둔 기간 조회 공통 함수 호출
        gateway(setStartDate, setEndDate, setLocation);
    }
}

//급여 이체내역 조회 데이터를 가져오는 API
function payInfo(sDate, eDate) {

    //API호출 > json 전달 > 함수 실행
    fetch(`/accapi/accounting/getpaytotal/${sDate}/${eDate}`).then(response => {
        if (response.ok) {
            return response.json();
        }
    }).then(json => {

        //조회 기간 내 급여이체 합계 초기화
        let payTotalSum = 0;
        //html 내용 초기화
        let payInfoTbody = '';
        //키(데이터)가 없으면 noData
        if(!json.length) {
            payInfoTbody = ` 
                    <tr> 
                        <td colspan="3">해당 기간에 조회된 급여 이체 내역이 없습니다.</td>
                    </tr>
                    `
        } else {
            //html에 넣을 데이터 생성
            json.forEach((obj) => {

                //조회결과 내 급여이체 총 합계 구하면서 html 요소 생성
                payTotalSum = payTotalSum + parseInt(`${obj.payTotal}`);

                payInfoTbody += `
                        <tr>
                            <td>${(obj.paymdate).substring(7, 5)}월</td>
                            <td>${obj.paymdate}</td>
                            <td>${(obj.payTotal).toLocaleString()}</td>
                        </tr>
                    `
            })
            //반복문 끝나면 합계 나타내는 html 요소 생성
            payInfoTbody += `
                        <tr>
                            <td colspan="2" bgcolor="#f8f8ff"><b>급여 지출합계</b></td>
                            <td>${(payTotalSum).toLocaleString()}</td>
                        </tr>
                    `
        }

        //조건문 모두 끝나면 append 및 지출결의 전표 API 함수 호출(조회 기간, 급여 이체 합계 데이터)
        $("#payroll").empty().append(payInfoTbody);
        findAccAll(sDate, eDate, payTotalSum);
    })
}
//지출 결의 조회 데이터를 가져오는 API
function findAccAll(sDate, eDate, payTotalSum) {

    fetch(`/accapi/accounting/${sDate}/${eDate}`).then(response => {
        if (response.ok) {
            return response.json();
        }
    }).then(json => {
        //회계전표 대시보드 초기화
        let dashTbody = '';
        //지출결의 리스트 건 수 초기화
        let listTotalCount = 0;
        //지출결의 합계 초기화
        let listTotalSum = 0;
        //지출결의 리스트 html 초기화
        let listTbody = '';
        //지출결의 합계 html 초기화
        let listTotalTbody = '';

            //html에 넣을 데이터 생성
            json.forEach((obj) => {
                //LEFT OUTER JOIN 결과값에 의해 null값 체크 후, 데이터 생성
                if (obj.expTitle != null) {

                    //리스트 총 건 수 카운트
                    listTotalCount = listTotalCount + 1;
                    //리스트 총 금액 합계 구하기
                    listTotalSum = listTotalSum + obj.expense;
                    //하나의 레이블 선택 시, 상세내역 리스트 API 함수 호출
                    listTbody += `
                        <tr style="cursor:pointer;" onclick="findAccDetail(${obj.statNum})" onmouseover="this.style.background='whitesmoke'" onmouseout="this.style.background='white'">
                            <td>${obj.statNum}</td>
                            <td>${obj.expTitle}</td>
                            <td>${obj.statDate}</td>
                            <td>${obj.expense.toLocaleString()}</td>
                            <td>${obj.income}</td>
                            </tr>
                        `;

                }
            });
            //요소(데이터) 생성된게 없다면 noData 처리
            if(listTbody == '') {
                listTbody = '<td colspan="5"> 해당 기간에 조회된 데이터가 없습니다.</td>';
            } else {
                //리스트 합계
                listTotalTbody = `
                        <tr>
                            <td colspan="3" bgcolor="#f8f8ff"><b>합계</b></td>
                            <td>${(listTotalSum).toLocaleString()}</td>
                            <td>0</td>
                        </tr>
                    `;
                //대시보드에 나타낼 'sumResult'는 급여 지출금액 + 지출결의 지출 금액
                let sumResult = payTotalSum + listTotalSum;

                //대시보드에 데이터 출력
                dashTbody = `
                    <tr>
                        <td style="text-align: center; vertical-align: middle"><font size="8">${(sumResult).toLocaleString()}</font></td>
                        <td style="text-align: center; vertical-align: middle"><font size="8">0</font></td>
                    </tr>
        
                 `;
            }

        //리스트 건 수 출력되도록 append
        $("#listTotal").empty().append(`<span>전체 ${listTotalCount}건</span>`);
        //대시보드 출력
        $("#dash").empty().append(dashTbody);
        //리스트 출력
        $("#list").empty().append(listTbody + listTotalTbody);
        //상세 리스트는 페이지 인입 또는 검색 후, 리스트에서 선택해서 조회하므로 noData 처리
        $("#detailList").empty().append(`<td colspan="7">전표 리스트에서 상세 조회할 항목을 선택해 주세요.</td>`);
    })
}

//지출 결의 상세 조회 데이터를 가져오는 API
function findAccDetail(statNum) {
    //전표번호(statNum) 조회
    fetch(`accapi/accounting/${statNum}`).then(response => {
        if (response.ok) {
            return response.json();
        }
    }).then(json => {
        //상세 리스트 요소 초기화
        let detailTbody = '';
        //상세 건 수 초기화
        let detailTotalCount = 0;
        //상세 건 합계 초기화
        let detailTotalSum = 0;
        //요소 생성
        json.forEach((obj) => {
            //상세 건 수 카운트
            detailTotalCount = detailTotalCount + 1;
            //상세 건 합계
            detailTotalSum = detailTotalSum + parseInt(obj.expense);

            detailTbody += `
                <tr>
                    <td>${obj.expNum}</td>
                    <td>${obj.empName}</td>
                    <td>${obj.remk}</td>
                    <td>${obj.appr}</td>
                    <td>${obj.apprDate}</td>
                    <td>${obj.comAcc}</td>
                    <td>${obj.expense.toLocaleString()}</td>
                </tr>
                `
        });
        //상세 건 수 출력
        $("#listDetailTotal").empty().append(`상세 ${detailTotalCount}건`);
        //상세 건 합계
        detailTotal = `
                        <tr>
                            <td colspan="6" bgcolor="#f8f8ff"><b>상세 건 합계</b></td>
                            <td>${detailTotalSum.toLocaleString()}</td>
                        </tr>    
                    `;

        //상세 건 리스트 출력
        $("#detailList").empty().append(detailTbody + detailTotal);
    })
}

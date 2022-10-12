let listTotalCount=0;
let detailTotalCount=0;
let listTotalSum=0;
let detailTotalSum=0;

let letstartDate = new Date();
let letendDate = new Date();
let syear = letstartDate.getFullYear();
let smonth = letstartDate.getMonth() + 1;
let sdate = letstartDate.getDate() - 2;
let eyear = letendDate.getFullYear();
let emonth = letendDate.getMonth() + 1;
let edate = letendDate.getDate();

let setStartDate;
let setEndDate;


window.onload = () => {

    setStartDate = syear + '-' + smonth + '-' + sdate;
    setEndDate = eyear + '-' + emonth + '-' + edate;
    console.log("기본빵 " + setStartDate + "부터 " + setEndDate + "까지 기간 조회");

    findAccAll(setStartDate, setEndDate);
}

function search() {
    setStartDate = document.getElementById("searchSDate").value;
    setEndDate = document.getElementById("searchEDate").value;

    findAccAll(setStartDate, setEndDate);
}

function findAccAll(setSDate, setEDate) {

    const startDate = setSDate;
    const endDate = setEDate;

    fetch(`/accapi/accounting/${startDate}/${endDate}`).then(response => {

        console.log("response : ", response);

        if (response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        let htmlTotal = '';

        if (!json.length) {
            html = '<td colspan="5"> 해당 기간에 조회된 데이터가 없습니다.</td>';
        } else {

                json.forEach((obj, idx) => {
                    var tempComAcc = obj.comAcc;


                    if (tempComAcc == null) {
                        console.log("<-- 제외된 데이터 수");
                    } else {

                        listTotalCount = listTotalCount + 1;
                        var tempExpense = obj.expense;
                        listTotalSum = listTotalSum + tempExpense;
                        var formatExpense = tempExpense.toLocaleString();

                    html += `
                        <tr style="cursor:pointer;" onclick="findAccDetail(${obj.statNum})" onmouseover="this.style.background='lightgrey'" onmouseout="this.style.background='white'">
                            <td>${json.length - idx}</td>
                            <td>${obj.comAcc}</td>
                            <td>${obj.statDate}</td>
                            <td>${formatExpense}</td>
                            <td>${obj.income}</td>
                            </tr>
                        `;
                    }
                });
        }
        listTotalView(listTotalCount);

        var sum = listTotalSum.toLocaleString();

        if (listTotalSum>0) {
            htmlTotal = `
                        <th colspan="3">합계</th>
                            <td>${sum}</td>
                            <td>0</td>
                    `;
        }


        $("#list").empty().append(html + htmlTotal);
        //document.getElementById('list').innerHTML = html + htmlTotal;

        var tempDetail = '<td colspan="6">전표 리스트에서 상세 조회할 항목을 선택해 주세요.</td>';
        document.getElementById('detailList').innerHTML = tempDetail;
        listTotalCount = 0;
        listTotalSum = 0;
    })

}

function listTotalView(listTotalCount) {

    html = `<span>총 ${listTotalCount}건</span>`;
    document.getElementById('listTotal').innerHTML = html;
}


function findAccDetail(statNum) {
    console.log(statNum);

    fetch(`accapi/accounting/${statNum}`).then(response => {

        console.log(response);

        if(response.ok) {
            return response.json();
        }
    }).then(json => {
        let detail = '';

        json.forEach((obj) => {
            detailTotalCount = detailTotalCount + 1;

            var tempExpense = obj.expense;
            detailTotalSum = detailTotalSum + tempExpense;

            var formatExpense = tempExpense.toLocaleString();

            detail += `
                <tr>
                    <td>${obj.expNum}</td>
                    <td>${obj.empName}</td>
                    <td>${obj.appr}</td>
                    <td>${obj.apprDate}</td>
                    <td>${obj.comAcc}</td>
                    <td>${formatExpense}</td>
                    
                </tr>
                `
        });

        detailTotalView(detailTotalCount);

        var sum = detailTotalSum.toLocaleString();

        if (detailTotalSum>0) {
            detailTotal = `
                        <th colspan="5">합계</th>
                            <td>${sum}</td>
                            
                    `;
        }

        document.getElementById('detailList').innerHTML = detail + detailTotal;
        detailTotalCount = 0;
        detailTotalSum = 0;
    })

}

function detailTotalView(detailTotalCount) {

    html = `<span>상세 ${detailTotalCount}건</span>`;
    document.getElementById('listDetailTotal').innerHTML = html;
}
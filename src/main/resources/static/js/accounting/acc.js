let payTotalSum = 0;

let setLocation = 'acc';


window.onload = () => {
    defaultPeriodSet(setLocation);
}

function search() {

    const setStartDate = document.getElementById("searchSDate").value;
    const setEndDate = document.getElementById("searchEDate").value;

    payTotalSum = 0;
    gateway(setStartDate, setEndDate, setLocation);
}


function payInfo(sDate, eDate) {

    const startDate = sDate;
    const endDate = eDate;

    fetch(`/accapi/accounting/getpaytotal/${startDate}/${endDate}`).then(response => {
        if (response.ok) {
            return response.json();
        }
    }).then(json => {

        let payInfoTbody = '';

        if(!json.length) {
            payInfoTbody = ` 
                    <tr> 
                        <td colspan="3">해당 기간에 조회된 급여 이체 내역이 없습니다.</td>
                    </tr>
                    `
        } else {

            json.forEach((obj) => {

                payTotalSum = payTotalSum + parseInt(`${obj.payTotal}`);

                (payTotalSum > 0)
                payInfoTbody += `
                        <tr>
                            <td>${(obj.paymdate).substring(7, 5)}월</td>
                            <td>${obj.paymdate}</td>
                            <td>${(obj.payTotal).toLocaleString()}</td>
                        </tr>
                    `

            })
            payInfoTbody += `
                        <tr>
                            <td colspan="2" bgcolor="#f8f8ff"><b>급여 지출합계</b></td>
                            <td>${(payTotalSum).toLocaleString()}</td>
                        </tr>
                    `
        }

        $("#payroll").empty().append(payInfoTbody);

    })

    findAccAll(startDate, endDate);
}


function findAccAll(setSDate, setEDate) {

    const startDate = setSDate;
    const endDate = setEDate;

    fetch(`/accapi/accounting/${startDate}/${endDate}`).then(response => {

        if (response.ok) {
            return response.json();
        }
    }).then(json => {
        let listTbody = '';
        let listTotalTbody = '';
        let dashTbody = '';
        let listTotalCount = 0;
        let listTotalSum = 0;

        if (!json.length) {
            listTbody = '<td colspan="5"> 해당 기간에 조회된 데이터가 없습니다.</td>';
        } else {

            json.forEach((obj, idx) => {

                if (obj.expTitle == null) {

                    console.log("<-- 제외된 데이터 수");

                } else {
                    listTotalCount = listTotalCount + 1;
                    var tempExpense = obj.expense;
                    listTotalSum = listTotalSum + tempExpense;
                    var formatExpense = tempExpense.toLocaleString();

                    listTbody += `
                        <tr style="cursor:pointer;" onclick="findAccDetail(${obj.statNum})" onmouseover="this.style.background='whitesmoke'" onmouseout="this.style.background='white'">
                            <td>${json.length - idx}</td>
                            <td>${obj.expTitle}</td>
                            <td>${obj.statDate}</td>
                            <td>${formatExpense}</td>
                            <td>${obj.income}</td>
                            </tr>
                        `;

                    listTotalTbody = `
                        <tr>
                            <td colspan="3" bgcolor="#f8f8ff"><b>합계</b></td>
                            <td>${(listTotalSum).toLocaleString()}</td>
                            <td>0</td>
                        </tr>
                    `;

                }
                let sumResult = payTotalSum + listTotalSum;
                dashTbody = `
                    <tr>
                        <td style="text-align: center; vertical-align: middle"><font size="8">${(sumResult).toLocaleString()}</font></td>
                        <td style="text-align: center; vertical-align: middle"><font size="8">0</font></td>
                    </tr>
        
                 `;

                if (listTotalCount == 0) {
                    listTbody = '<td colspan="5"> 해당 기간에 조회된 데이터가 없습니다.</td>';
                }
            });
        }

        listTotalView(listTotalCount);



        $("#dash").empty().append(dashTbody);
        $("#list").empty().append(listTbody + listTotalTbody);

        var tempDetail = `<td colspan="7">전표 리스트에서 상세 조회할 항목을 선택해 주세요.</td>`;

        $("#detailList").empty().append(tempDetail);



    })

}

function listTotalView(listTotalCount) {

    listTotalDiv = `<span>전체 ${listTotalCount}건</span>`;
    $("#listTotal").empty().append(listTotalDiv);

}


function findAccDetail(statNum) {
    console.log(statNum);

    fetch(`accapi/accounting/${statNum}`).then(response => {

        console.log(response);

        if (response.ok) {
            return response.json();
        }
    }).then(json => {
        let detailTbody = '';
        let detailTotalCount = 0;
        let detailTotalSum = 0;

        json.forEach((obj) => {
            detailTotalCount = detailTotalCount + 1;

            var tempExpense = obj.expense;
            detailTotalSum = detailTotalSum + tempExpense;

            var formatExpense = tempExpense.toLocaleString();

            detailTbody += `
                <tr>
                    <td>${obj.expNum}</td>
                    <td>${obj.empName}</td>
                    <td>${obj.remk}</td>
                    <td>${obj.appr}</td>
                    <td>${obj.apprDate}</td>
                    <td>${obj.comAcc}</td>
                    <td>${formatExpense}</td>
                    
                </tr>
                `
        });

        detailTotalView(detailTotalCount);

        var detailTotalTbody = detailTotalSum.toLocaleString();

        if (detailTotalSum > 0) {
            detailTotal = `
                        <tr>
                            <td colspan="6" bgcolor="#f8f8ff"><b>상세 건 합계</b></td>
                            <td>${detailTotalTbody}</td>
                        </tr>    
                    `;
        }

        $("#detailList").empty().append(detailTbody + detailTotal);


    })

}

function detailTotalView(detailTotalCount) {
    detailTotalDiv = `상세 ${detailTotalCount}건`;
    $("#listDetailTotal").empty().append(detailTotalDiv);

}

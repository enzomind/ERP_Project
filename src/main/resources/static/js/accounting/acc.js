let listTotalCount=0;
let listTotalSum=0;

console.log("start");
window.onload = () => {
    findAccAll();
}

function findAccAll() {
    fetch('/accapi/accounting').then(response => {

        console.log("response : ", response);

        if (response.ok) {
            return response.json();
        }
    }).then(json => {
        let html = '';
        let htmlTotal = '';

        if (!json.length) {
            html = '<td colspan="5"> 등록된 게시글이 없습니다.</td>';
        } else {
            json.forEach((obj, idx) => {
                listTotalCount = listTotalCount + 1;

                var tempExpense = obj.expense;
                listTotalSum = listTotalSum + tempExpense;

                var formatExpense = tempExpense.toString()
                    .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");


                html += `
                        <tr style="cursor:pointer;" onclick="findAccDetail()" onmouseover="this.style.background='lightgrey'" onmouseout="this.style.background='white'">
                            <td>${obj.statNum}</td>
                            <td>${obj.comAcc}</td>
                            <td>${obj.statDate}</td>
                            <td>${formatExpense}</td>
                            <td>${obj.income}</td>
                            </tr>
                        `;
            });
        }
        listTotalView(listTotalCount);

        var sum = listTotalSum.toString()
            .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

        htmlTotal = `
        <th colspan="3">합계</th>
        <td>${sum}</td>
        <td>0</td>
    `;

        document.getElementById('list').innerHTML = html + htmlTotal;

    })

}

function listTotalView(listTotalCount) {

    html = `<span>총 ${listTotalCount}건</span>`;
    document.getElementById('listTotal').innerHTML = html;
}


function findAccDetail(statNum) {

    console.log(statNum);

}
let listTotalCount=0;

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

        if (!json.length) {
            html = '<td colspan="5"> 등록된 게시글이 없습니다.</td>';
        } else {
            json.forEach((obj, idx) => {
                listTotalCount = listTotalCount + 1;
                var formatExpense = obj.expense.toString()
                    .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

                html += `
                        <tr style="cursor:pointer;" onclick="location.href='naver.com'" onmouseover="this.style.background='lightgrey'" onmouseout="this.style.background='white'">
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
        document.getElementById('list').innerHTML = html;
    })
}


function listTotalView(listTotalCount) {

    html = `<span>총 ${listTotalCount}건</span>`;

    document.getElementById('listTotal').innerHTML = html;
}
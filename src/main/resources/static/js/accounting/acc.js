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
                var formatExpense = obj.expense.toString()
                    .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

                html += `
                        <tr>
                            <td>${obj.statNum}</td>
                            <td>${obj.comAcc}</td>
                            <td>${obj.statDate}</td>
                            <td>${formatExpense}</td>
                            <td>${obj.income}</td>
                            </tr>
                        `;
            });
        }

        document.getElementById('list').innerHTML = html;
    })
}


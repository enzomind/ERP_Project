let name = 'hanul';
let i = 2;

function testlogic() {
    console.log($("#det_code1").val());

    html =
        ` 
        <td>
            <select class="form-control" name="detCode" id="det_code">
                 <option value="선택" selected>선택</option>
                 <option value="복리후생비">복리후생비</option>
            </select>
        </td>
        <td><input type="text" name="remk" id="remk" class="form-control"></td>
        <td>
            <select class="form-control" name="comAcc" id="com_acc">
                <option value="선택" selected>선택</option>
                <option value="기업은행 110-110-111111">기업은행 110-110-111111</option>
            </select>
        </td>
        <td><input type="text" name="expense" id="expense" class="form-control"></td>
                            `


    document.getElementById(name+i).innerHTML = html;
    i = i + 1;
    console.log(i);
    //document.getElementById('list').innerHTML = html + htmlTotal;
}
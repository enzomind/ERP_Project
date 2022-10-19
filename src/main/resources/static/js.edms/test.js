let name = 'row';
let i = 1;
function addForm() {

    html =
        `
        <tr id="row2">
           <td>
            <select class="form-control" name="acRequestDtoList[1].detCode" id="det_code2">
               <option value="선택" selected>선택</option>
               <option value="복리후생비">복리후생비</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[1].remk" id="remk2" class="form-control" placeholder="저는 row2예요"></td>
           <td>
            <select class="form-control" name="acRequestDtoList[1].comAcc" id="com_acc2">
               <option value="선택" selected>선택</option>
               <option value="기업은행 110-110-111111">기업은행 110-110-111111</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[1].expense" id="expense2" class="form-control"></td>
        </tr>`
    html1 =
        `
        <tr id="row3">
           <td>
            <select class="form-control" name="acRequestDtoList[2].detCode" id="det_code3">
               <option value="선택" selected>선택</option>
               <option value="복리후생비">복리후생비</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[2].remk" id="remk3" class="form-control" placeholder="저는 row3예요"></td>
           <td>
            <select class="form-control" name="acRequestDtoList[2].comAcc" id="com_acc3">
               <option value="선택" selected>선택</option>
               <option value="기업은행 110-110-111111">기업은행 110-110-111111</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[2].expense" id="expense3" class="form-control"></td>
        </tr>`
    html2 =
        `
        <tr id="row4">
           <td>
            <select class="form-control" name="acRequestDtoList[3].detCode" id="det_code4">
               <option value="선택" selected>선택</option>
               <option value="복리후생비">복리후생비</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[3].remk" id="remk4" class="form-control" placeholder="저는 row4예요"></td>
           <td>
            <select class="form-control" name="acRequestDtoList[3].comAcc" id="com_acc4">
               <option value="선택" selected>선택</option>
               <option value="기업은행 110-110-111111">기업은행 110-110-111111</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[3].expense" id="expense4" class="form-control"></td>
        </tr>`
    html3 =
        `
        <tr id="row5">
           <td>
            <select class="form-control" name="acRequestDtoList[4].detCode" id="det_code5">
               <option value="선택" selected>선택</option>
               <option value="복리후생비">복리후생비</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[4].remk" id="remk5" class="form-control" placeholder="저는 row5예요"></td>
           <td>
            <select class="form-control" name="acRequestDtoList[4].comAcc" id="com_acc5">
               <option value="선택" selected>선택</option>
               <option value="기업은행 110-110-111111">기업은행 110-110-111111</option>
            </select>
           </td>
           <td><input type="text" name="acRequestDtoList[4].expense" id="expense5" class="form-control"></td>
        </tr>`

    document.getElementById('row2').innerHTML = html;
    $('#row1').after(html);
    i = i + 1;
    html = html+i;

    if(i == 5){
        $('#plusBtn').hide()
    }
    //document.getElementById('list').innerHTML = html + htmlTotal;
}

/*
$(document).ready(function (){

    $.ajax({
        type: "POST",
        url: "/edms/edms_1",
        data: { "det" : $("#det_code").val(),
                "remk" : $("#remk").val(),
                "com_acc" : $("#com_acc").val(),
                "exp" : $("#expense").val()
        },
        success : function() {
        }
    });


})*/

$(document).ready(function () {

    //날짜 화면 표시
    var date = new Date()
    var year = date.getFullYear()
    var month = date.getMonth() + 1
    var day = date.getUTCDate()
    var today = year + '-' + month + '-' + day
    $('#date').text(today);

    // $("#td_name").click(function(){
    //     $("#appr_name").text("#td_name");
    // });


//     $('#rowClicked').click(function () {
//     var table =document.getElementById('modal_click');
//     var rowList = table.rows; // *1)rows collection
//
//     for (i=1; i<rowList.length; i++) {//thead부분 제외.
//
//         var row = rowList[i];
//         var tdsNum = row.childElementCount;// 자식요소 갯수 구하기.
//
//         row.onclick = function(){
//             return function(){
//                 var str = "";
//                 for (var j = 3; j < tdsNum; j++){//row안에 있는 값 순차대로 가져오기.
//                     var row_value = this.cells[j].innerHTML; //*2)cells collection
//                     str += row_value+' ';//값을 하나의 text값으로 만듦
//                 };//td for
//                 document.querySelector('#tr_name').innerText =str; //p태그 안에 값 넣어주기.
//             };//return
//         }(row);//onclick
//     }//for
// })//function
// window.onload = rowClicked();


//경고창 띄우기
$('#submit').click(function () {
    if ($('#appr_name').val().length < 1) {
        alert("결재자를 선택해주세요");
        return false;
    }
    if ($('#title').val().length < 1) {
        alert("제목을 입력해주세요.");
        return false;
    }
    if ($('#type').val().length < 1) {
        alert("휴가구분을 선택해주세요.");
        return false;
    }
    if($('#content').val().length < 1){
        alert("내용을 입력해주세요");
        return false;
    }
})


});

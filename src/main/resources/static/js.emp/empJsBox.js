//오늘 날짜 정리
let today = new Date();
let attrYear = today.getFullYear(); // 년도
let attrMonth = today.getMonth() + 1;  // 월
let attrDate = today.getDate();  // 날짜
let attrResDate = (attrYear + '-' + attrMonth + '-' + attrDate);

//이미지 가져오기위한 프로젝트 경로 상황맞춰서 수정 필요
let myPrjPath = "/Users/seonghuchoi/Downloads/erp_Project/";

$(document).ready(function () {

    //직원조회 테이블의 직원이름 클릭 시 해당 직원정보 모달 팝업
    $('.hiddenEmpName').click(function () {
        //empId 가져가기
        let hiddenEmpId2 = $(this).parent().siblings('.hiddenEmpId').text();
        //직원조회 테이블
        $.getScript("/js.emp/empTable.js", function () {
            empGetTable(hiddenEmpId2);
        });
        //직원수정 실행 시 empId 가져가기
        $.getScript("/js.emp/empUpdate.js", function () {
            empUpdateModal(hiddenEmpId2)
        });
    });
    //등록 클릭 시 직원등록 모달 팝업
    $('.hiddenEmpInput').click(function () {
        $.getScript("/js.emp/empInput.js", function () {
            empInputModal();
        });
    });

    //검색버튼 구현 중
    $('.searchHrTable').click(function (){
        }
    )
});
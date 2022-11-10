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

    //검색 필터 ajax 정의
    $('.searchHrTable').click(function (){
        $.ajax({
                type: "POST",
                url: "/employee/filter",
                data: {
                    depNo : $('#dep').val(),
                    jobCode : $('#pstn').val(),
                    start : $('#searchDateStart').val(),
                    end : $('#searchDateEnd').val(),
                    empName : $('#empName').val(),
                },

                success: function (e) {
                    let html = jQuery('<div>').html(e);
                    let contents = html.find("div#selectFilter").html();
                    $('#dataTable').dataTable().empty();
                    $('#filterDiv').children().remove();
                    $('#filterDiv').append(contents);
                    $('#dataTable').dataTable({searching : false});

                    //직원조회 테이블의 직원이름 클릭 시 해당 직원정보 모달 팝업 재실행
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

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest, textStatus, errorThrown);
                }
            });

        });

});

//값 포맷 콤마 찍어주는 정규화
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}

//널 체크 함수
function nullCheck() {
    $('.checkVali').each(function (){
        let thisVal = $(this).val();
        if(thisVal.length == 0){
            $(this).siblings('.ValiVali').text("재확인 요망");
            $(this).siblings('.ValiVali').css("color", "red");

        } else {
            $(this).siblings('.ValiVali').empty();
            $(this).siblings('.ValiVali').css("color", "black");
        }
    })
}
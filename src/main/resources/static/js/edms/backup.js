/* 여러건의 dto ajax로 보내는 법
ac_form.js

$("#submit").click(function () {
    //배열 선언
    var detcode = [];
    var remk = [];
    var acc = [];
    var expense = [];
    var title = $('#exp_title1').val();

    $('.sel1').each(function (i) {//체크된 리스트 저장
        detcode.push($(this).val());
    });

    $('.sel2').each(function (i) {//체크된 리스트 저장
        remk.push($(this).val());
    });
    $('.sel3').each(function (i) {//체크된 리스트 저장
        acc.push($(this).val());
    });
    $('.sel4').each(function (i) {//체크된 리스트 저장
        expense.push($(this).val());
    });

    var objParams = {
        expTitle: title, //title 저장
        detCode: detcode,
        remk: remk,
        comAcc: acc,
        expense: expense//나머지배열 저장
    };

        console.log(objParams);

            //ajax 호출
            $.ajax({
                url         :   "/edms/edms_1",
                dataType    :   "json",
                contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                type        :   "post",
                data        :   objParams,
                success     :   function(data){

                console.log(data)

                },
                error       :   function(request, status, error){
                    console.log("AJAX_ERROR");
                }
            });

        })

*/


// controller

// @RequestParam(value="expTitle") String expTitle, @RequestParam(value="detCode[]") List<String> detCode,@RequestParam(value="remk[]") List<String> remk,@RequestParam(value="comAcc[]") List<String> comAcc,@RequestParam(value="expense[]") List<String> expense
//
// System.out.println("=user=");
// System.out.println(expTitle);
//
// System.out.println("=det=");
// for(String fruit : detCode) {
// System.out.println(fruit);
//    }
// System.out.println("=remk=");
// for(String fruit1 : remk) {
// System.out.println(fruit1);
//    }
// System.out.println("=acc=");
// for(String fruit2 : comAcc) {
// System.out.println(fruit2);
//    }
// System.out.println("=det=");
// for(String fruit3 : expense) {
// System.out.println(fruit3);
//    }

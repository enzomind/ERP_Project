//이미지 가져오기위한 프로젝트 경로 상황맞춰서 수정 필요
let myPrjPath = "/Users/seonghuchoi/Downloads/intelliJFolder/erp_Project/";
// let myPrjPath = "C:\\Users\\user\\erp_Project\\";
$(document).ready(function () {
    //개인정보 창 띄우기
    MyEmpSel();

    //비밀번호 확인 클릭 시
    $('.checkPwBtn').on("click", function () {
        let inputPw = $('.checkPassWord').val();
        //에이잭스 시작
        $.ajax({
            type: "GET",
            url: "/mypage/getUserName",
            data : {
             password : inputPw
            },
            success: function (data) {
                //에이잭스 성공 후 암호 일치 시
                if(data == true) {
                    let html1 = "";
                    let html2 = "";

                    html1 = `
                    <span style="color : limegreen"> 기존 암호와 일치합니다. 비밀번호를 변경합니다.</span>
                            `;
                    html2 = ` 
                        <span>변경할 암호를 입력한 뒤 이어서 재입력 해주세요.</span><br><br>
                        <spans> 새암호 : </spans><input type="password" class="form-input NewPassWord"> <br>
                        <spans> 재입력 : </spans><input type="password" class="form-input mt-3 checkNewPassWord"> <button type="button" class="btn btn-primary mx-2 mb-2 UpdatePwBtn">변경</button>
                        <p class="checkingPw"></p>
                        `;
                    $('#TestPassWord').empty().append(html1)
                    $('#PassWordUpdateDiv').empty().append(html2);

                    //비밀번호 체크해서 밑에 글씨 띄워주기 -1
                    $('.NewPassWord').on("change", function () {
                        let NewPw = $('.NewPassWord').val();
                        $('.checkNewPassWord').on("change", function () {
                            let CheckPw = $('.checkNewPassWord').val();
                            if(NewPw != CheckPw){
                                $('.checkingPw').css("color", "red");
                                $('.checkingPw').text("비밀번호가 일치하지 않습니다.");
                            } else if (NewPw == CheckPw) {
                                $('.checkingPw').css("color", "limegreen");
                                $('.checkingPw').text("비밀번호가 일치합니다.");
                            }
                        });
                    });
                    //비밀번호 체크해서 밑에 글씨 띄워주기 -1 끝

                    //비밀번호 체크해서 밑에 글씨 띄워주기 -2
                    $('.checkNewPassWord').on("change", function () {
                        let CheckPw = $('.checkNewPassWord').val();
                        $('.NewPassWord').on("change", function () {
                            let NewPw = $('.NewPassWord').val();
                            if(NewPw != CheckPw){
                                $('.checkingPw').css("color", "red");
                                $('.checkingPw').text("비밀번호가 일치하지 않습니다.");
                            } else if (NewPw == CheckPw) {
                                $('.checkingPw').css("color", "limegreen");
                                $('.checkingPw').text("비밀번호가 일치합니다.");
                            }
                        });
                    });
                    //비밀번호 체크해서 밑에 글씨 띄워주기 -2 끝


                    //변경 버튼 클릭 시, 비밀번호 일치하면 에이잭스 실행
                    $('.UpdatePwBtn').on("click", function (){
                        let NewPw = $('.NewPassWord').val();
                        if($('.checkingPw').text() == "비밀번호가 일치하지 않습니다.") {
                            alert("비밀번호가 서로 다릅니다. 다시 확인해 주세요.");
                        } else if ($('.checkingPw').text() == "비밀번호가 일치합니다.") {
                            pwUpdateAjax(NewPw);
                        }
                    });

                }
                //에이잭스 성공 후 암호 불일치 시
                else if(data == false){
                    let html = "";
                    html = `
                    <span style="color : red"> 암호 재입력 바랍니다.</span>
                    `;
                    $('#TestPassWord').children('span').empty();
                    $('#TestPassWord').prepend(html);
                }
            },
            error: function () {
                console.log("error");
            }
        });
        //에이잭스 끝

    });

});

//패스워드 업데이트 에이잭스
function pwUpdateAjax (newPw){
    $.ajax({
        type: "POST",
        url: "/mypage/UpdatePw",
        data : {
            UpdatePw : newPw
        },
        success() {
            console.log("비밀번호 업데이트 완료");
            window.location.replace("/dologout");
        },
        error(){
            console.log("비밀번호 업데이트 에러")
        }
    });
}

//개인정보 창 에이잭스
function MyEmpSel() {
    let html1 = "";

    $.ajax({
        url: "/mypage/myEmpUp",
        type: 'GET',
        success: function (data) {
            let empId = data[0].empId;
            let empName = data[0].empName;
            let idpNum = data[0].idpNum;
            let idpNum1 = idpNum.split('-')[0];
            let idpNum2 = idpNum.split('-')[1];
            let email = data[0].email;
            let email1 = email.split('@')[0];
            let email2 = '@' + email.split('@')[1];
            let tel = data[0].tel;
            let hireDate = data[0].hireDate;
            let hqCode = data[0].hqCode;
            let depNo = data[0].depNo;
            let jobCode = data[0].jobCode;
            let bankName = data[0].bankName;
            let account = data[0].account;
            let note = data[0].note;
            let resYn = data[0].resYn;
            let resDate = data[0].resDate;
            let salary = data[0].salary;
            salary = salary.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
            let wage =  data[0].wage;
            wage = wage.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

            // 파일 네임, 파일 패스 널값 대처
            if(data[0].fileName != null) {
                fileSaveName = data[0].fileName;
            } else {
                fileSaveName = "fff.jpg&text=Please+insert+the+image";
            }
            if(data[0].filePath != null) {
                filePath = data[0].filePath;
            } else {
                filePath = "https://dummyimage.com/600x400/000/";
            }
            let fileFakePath;
            let slicePath = filePath.slice(0,2);
            if (slicePath == "ht") {
                fileFakePath = filePath + fileSaveName;
            } else if (slicePath == "re") {
                fileFakePath = myPrjPath + filePath + fileSaveName;
            }

            //본부코드 문자열로 변환
            switch (hqCode) {
                case "SJHQ_0001" :
                    hqCode = "HR본부";
                    break;
                case "SJHQ_0002" :
                    hqCode = "ICT개발본부";
                    break;
                case "SJHQ_0003" :
                    hqCode = "솔루션사업본부";
                    break;
            }
            //부서코드 문자열로 변환
            switch (depNo) {
                case "SJDP_0001" :
                    depNo = "경영관리부";
                    break;
                case "SJDP_0002" :
                    depNo = "솔루션개발부";
                    break;
                case "SJDP_0003" :
                    depNo = "SI개발부";
                    break;
                case "SJDP_0004" :
                    depNo = "영업부";
                    break;
                case "SJDP_0005" :
                    depNo = "전략기획부";
                    break;
                case "SJDP_0006" :
                    depNo = "인사관리부";
                    break;
            }
            //직급코드 문자열로 변환
            switch (jobCode) {
                case "SJPS_0001" :
                    jobCode = "사원";
                    break;
                case "SJPS_0002" :
                    jobCode = "대리";
                    break;
                case "SJPS_0003" :
                    jobCode = "과장";
                    break;
                case "SJPS_0004" :
                    jobCode = "팀장";
                    break;
                case "SJPS_0005" :
                    jobCode = "부장";
                    break;
                case "SJPS_0006" :
                    jobCode = "상무";
                    break;
                case "SJPS_0007" :
                    jobCode = "전무";
                    break;
                case "SJPS_0008" :
                    jobCode = "부대표";
                    break;
                case "SJPS_0009" :
                    jobCode = "대표";
                    break;
            }
            //참고사항 빈 칸 대치
            if (note == null) {
                note = "작성된 내용이 없습니다.";
            }
            //퇴사자 확인
            if (resYn == 'y') {
                resYn = "퇴사 (퇴사일 : " + resDate + ")";
            } else if (resYn == 'n') {
                resYn = "재직 중";
            } else {
                resYn = "확인필요";
            }
            html1 = `
                                <div class="form-body">

                                    <div class="form-group">
                                        <label class="label-title">재직 상태</label>
                                        <input type="text" class="form-input" value="${resYn}" readonly>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">이름</label><br>
                                            <input type="text" class="form-input" name="empInputName"
                                                           required="required" value="${empName}" readonly/>
                                        </div>
                                        <div class="form-group right">
                                            <p class="birth">주민번호</p>
                                             <input type="text" class="form-input birth" name="empInputIdpNum1"
                                                           required="required" value="${idpNum1}" readonly>
                                                    <data class="dash">-</data>
                                                    <input type="password" class="form-input birth" name="empInputIdpNum2"
                                                           required="required" value="${idpNum2}" readonly>
                                        </div>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">이메일</label><span class="ValiVali"></span><br>
                                            <input type="email" class="form-email checkVali" name="myPageEmail1"
                                                   value="${email1}" required="required">
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title my-0">&nbsp;</label><span class="ValiVali"></span><br>
                                            <input type="email" class="form-email checkVali" name="myPageEmail2"
                                                   value="${email2}" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">휴대전화</label><span class="ValiVali"></span><br>
                                        <input type="email" class="form-input checkVali" name="myPageTel"
                                               value="${tel}" required="required">
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">입사일</label>
                                        <input type="date" min="18" max="80"
                                               class="form-input" value="${hireDate}" readonly>
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">본부</label>
                                        <select class="form-input" readonly>
                                            <option>${hqCode}</option>
                                        </select>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">부서</label>
                                            <select class="form-input" readonly>
                                                <option>${depNo}</option>
                                            </select>
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title">직급</label>
                                            <select class="form-input" readonly>
                                                <option>${jobCode}</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">급여정보</label><span class="ValiVali"></span><br>
                                            <select class="form-option checkVali" name="myPageBankName" >
                                                <option value="${bankName}">${bankName} (현재)</option>
                                                <option value="한국은행">한국은행</option>
                                                        <option value="국민은행">국민은행</option>
                                                        <option value="신한은행">신한은행</option>
                                                        <option value="우리은행">우리은행</option>
                                                        <option value="새마을금고중앙회">새마을금고중앙회</option>
                                                        <option value="SC제일은행">SC제일은행</option>
                                                        <option value="KDB산업은행">KDB산업은행</option>
                                                        <option value="농협은행">농협은행</option>
                                                        <option value="수협은행">수협은행</option>
                                                        <option value="케이뱅크">케이뱅크</option>
                                                        <option value="신협은행">신협은행</option>
                                                        <option value="기업은행">기업은행</option>
                                                        <option value="씨티은행">씨티은행</option>
                                                        <option value="하나은행">하나은행</option>
                                                        <option value="카카오뱅크">카카오뱅크</option>
                                            </select>
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title">&nbsp;</label><span class="ValiVali"></span><br>
                                            <input type="text" min="18" max="80" name="myPageAccount"
                                                   class="form-input checkVali" value = "${account}"/>
                                        </div>
                                    </div>
                                    
                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">책정 급여(연별)</label>
                                            <input type="text" class="form-input" value="${salary} 원" readonly>     
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title">예상 급여(월별)</label>
                                            <input type="text" class="form-input" value="${wage} 원"readonly>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                       <label class="label-title">서명 파일 업로드</label><span class="ValiVali"></span><br>
                                       <img class="myPageSignImg mb-1" width="180" alt="첨부이미지 미리보기" src="${fileFakePath}"/><br>
                                       <input type="file" class="myPageSign float-left" size="80" accept="image/*" multiple/> <br>
                                    </div>

                                </div>
                                <!-- form-footer -->
                                <div class="modal-footer">
                                <span>* 이메일, 연락처, 급여정보, 서명파일 정보만 변경 가능합니다. 다른 정보 변경은 인사담당자에게 문의해 주세요.</span>
                                    <button type="button" class="btn btn-success" onclick="myPageUpdate()">수정</button>
                                </div>

                            `;

            $('#MyEmpDiv').empty().append(html1);

            //서명파일 수정
            $('.myPageSign').on("input", function (e) {
                let formDataUp = new FormData;
                formDataUp.append("myPageSign", e.target.files[0], e.target.files[0].name);
                //이미지변경 함수 사용
                readImageUp2(e.target);
                formDataAjaxUp2(formDataUp);
            });
        },
        error: function () {
            console.log("error");
        }
    })
}

//이미지 미리보기
function readImageUp2(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            $('.myPageSignImg').attr("src", e.target.result);
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0]);
    }
}

//파일업로드 전용 ajax (폼데이타)
function formDataAjaxUp2(formData) {
    $.ajax({
        type: "POST",
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        url: "/mypage/myPageSignImgUp",

        data: formData,

        success: function (data) {
            console.log("파일 업로드 완료")
            //업로드 사용 시 파일 저장 경로와 저장명 반환
            filePath = data[0].file_path;
            fileSaveName = data[0].save_file_name;

        },
        error: function () {
            console.log("error");
        }
    });
}

//empUpdate 수정내용 ajax
function myPageUpdate() {
//여기부터 null 체크
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

    if($('.ValiVali').text().length != 0){
        alert("빈 칸이 존재합니다.");
    } else if ($('.ValiVali').text() == 0){
//여기까지 null 체크
        $.ajax({
            url: "/mypage/myPageUpdate",
            type: 'post',
            datatype: 'json',
            data: {
                email: $('input[name=myPageEmail1]').val() + $('input[name=myPageEmail2]').val(),
                tel: $('input[name=myPageTel]').val(),
                bankName: $('select[name=myPageBankName]').val(),
                account: $('input[name=myPageAccount]').val(),
                fileName : fileSaveName,
                filePath : filePath,
            },
            success: function () {
                console.log("성공");
                location.reload();
            },
            error: function () {
                console.log("error");
            }
        })
    }
}
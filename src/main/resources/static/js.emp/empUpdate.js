//empUpdate 수정모달 팝업 정의 ajax
function empUpdateModal(e) {
    let html2 = "";

    $.ajax({

        url: "/employee/empGetTable",
        type: 'post',
        datatype: 'json',
        data: {
            "empId": e
        },
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
                fileFakePath = myPrjPath +filePath + fileSaveName;
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
                    depNo = "솔루션관리부";
                    break;
                case "SJDP_0003" :
                    depNo = "SI관리부";
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
                resDate = " ";
            } else {
                resYn = "확인필요, (현재 퇴사일 정보 : " + resDate + ")";
            }

            html2 = `

                                <div class="form-body">

                                    <!-- form header -->
                                    <div class="form-header"><br>
                                        <h1>인사 정보</h1>
                                    </div>
                                    <br>

                                    <div class="horizontal-group">
                                    <div class="form-group left">
                                        <label class="label-title">재직 상태</label><br>
                                        <input type="text" class="form-input resYnClass" name="empUpdateResYn" 
                                        value="${resYn}" readonly>
                                        </div>
                                        <div class="form-group right resYnRight">
                                         <button type="button" onclick="attrValue()" class="btn btn-primary mx-2">퇴사</button>
                                        <button type="button" onclick="attrValue2()" class="btn btn-secondary">취소</button>
                                        </div>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">이름 *</label><span class="ValiVali"></span><br>
                                            <input type="text" class="form-input checkVali" name="empUpdateName"
                                                           required="required" value="${empName}"/>
                                        </div>
                                        <div class="form-group right">
                                            <label class="birth">주민번호 *</label><span class="ValiVali"></span><br>
                                             <input type="text" class="form-input birth checkVali" name="empUpdateIdpNum1"
                                                           required="required" value="${idpNum1}">
                                                    <data class="dash">-</data>
                                                    <input type="password" class="form-input birth checkVali" name="empUpdateIdpNum2"
                                                           required="required" value="${idpNum2}">
                                        </div>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">이메일 *</label><span class="ValiVali"></span><br>
                                            <input type="email" class="form-email checkVali" name="empUpdateEmail1"
                                                   value="${email1}" required="required">
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title">　</label>
                                            <input type="email" class="form-email checkVali" name="empUpdateEmail2"
                                                   value="${email2}" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">휴대전화 *</label><span class="ValiVali"></span><br>
                                        <input type="email" class="form-input checkVali" name="empUpdateTel"
                                               value="${tel}" required="required">
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">입사일</label><span class="ValiVali"></span><br>
                                        <input type="date" min="18" max="80" name="empUpdateHireDate"
                                               class="form-input checkVali" value="${hireDate}">
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">본부</label><span class="ValiVali"></span><br>
                                        <select class="form-input checkVali" name="empUpdateHqCode">
                                            <option value="${hqCode}">${hqCode} (현재)</option>
                                             <option value="SJHQ_0001">HR본부</option>
                                                    <option value="SJHQ_0002">ICT개발본부</option>
                                                    <option value="SJHQ_0003">솔루션사업본부</option>
                                        </select>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">부서</label><span class="ValiVali"></span><br>
                                            <select class="form-input checkVali" name="empUpdateDepNo">
                                                <option value="${depNo}">${depNo} (현재)</option>
                                                <option value="SJDP_0001">경영관리부</option>
                                                        <option value="SJDP_0002">솔루션개발부</option>
                                                        <option value="SJDP_0003">SI개발부</option>
                                                        <option value="SJDP_0004">영업부</option>
                                                        <option value="SJDP_0005">전략기획부</option>
                                                        <option value="SJDP_0006">인사관리부</option>
                                            </select>
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title">직급</label><span class="ValiVali"></span><br>
                                            <select class="form-input checkVali" name="empUpdateJobCode" readonly>
                                                <option>${jobCode}</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="horizontal-group">
                                        <div class="form-group left">
                                            <label class="label-title">급여통장</label><span class="ValiVali"></span><br>
                                            <select class="form-option checkVali" name="empUpdateBankName" >
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
                                            <input type="text" min="18" max="80" name="empUpdateAccount"
                                                   class="form-input checkVali" value = "${account}"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                       <label class="label-title">서명 파일 업로드</label><span class="ValiVali"></span><br>
                                       <img class="empUpdateSignImg" width="180" alt="첨부이미지 미리보기" src="${fileFakePath}"/><br>
                                       <input type="file" class="empUpdateSign float-left" size="80" accept="image/*" multiple/> <br>
                                    </div>
                                    

                                    <div class="form-group">
                                        <label class="label-title">참고사항</label>
                                        <textarea name="empUpdateNote" 
                                        class="form-input" rows="4" cols="50"
                                                  style="height:auto">${note}</textarea>
                                    </div>
                                </div>
                                <!-- form-footer -->
                                <div class="modal-footer">
                                    <button onclick="dataDismiss('${empId}')" type="button" class="btn btn-secondary" >취소</button>
                                    <button onclick="empUpdate('${empId}')" type="button" class="btn btn-primary hiddenEmpUpdate" >완료</button>
                                </div>

                            `;
            $('.modal-updateEmp').empty().append(html2);


            //서명파일 수정
            $('.empUpdateSign').on("input", function (e) {
                let formDataUp = new FormData;
                formDataUp.append("empInputSign", e.target.files[0], e.target.files[0].name);
                //이미지변경 함수 사용
                readImageUp(e.target);
                formDataAjaxUp(formDataUp);
            });

        }
        ,
        error: function () {
            console.log("error");
        }
    })
}

//empUpdate 수정내용 ajax
function empUpdate(e) {
    let hqCodeVal;
    hqCodeVal = $('select[name=empUpdateHqCode]').val();
    switch (hqCodeVal) {
        case "HR본부":
            hqCodeVal = "SJHQ_0001";
            break;
        case "ICT개발본부":
            hqCodeVal = "SJHQ_0002";
            break;
        case "솔루션사업본부":
            hqCodeVal = "SJHQ_0003";
            break;
    }
    let depNoVal;
    depNoVal = $('select[name=empUpdateDepNo]').val();
    switch (depNoVal) {
        case "경영관리부":
            depNoVal = "SJDP_0001";
            break;
        case "솔루션개발부":
            depNoVal = "SJDP_0002";
            break;
        case "SI개발부":
            depNoVal = "SJDP_0003";
            break;
        case "영업부":
            depNoVal = "SJDP_0004";
            break;
        case "전략기획부":
            depNoVal = "SJDP_0005";
            break;
        case "인사관리부":
            depNoVal = "SJDP_0006";
            break;
    }

    let resYnVal;
    resYnVal = $('input[name=empUpdateResYn]').val();
    let transResYnVal = resYnVal.slice(0, 1);
    let transResDateVal;
    if (transResYnVal == '재') {
        today.setFullYear(1111, 11, 11);
        attrYear = today.getFullYear(); // 년도
        attrMonth = today.getMonth();  // 월
        attrDate = today.getDate();  // 날짜
        attrResDate = (attrYear + '-' + attrMonth + '-' + attrDate);
        transResYnVal = 'n';
        transResDateVal = attrResDate;
    } else if (transResYnVal == '퇴') {
        transResYnVal = 'y';
        transResDateVal = attrResDate;
    }
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
                url: "/employee/empUpdate",
                type: 'post',
                datatype: 'json',
                data: {
                    empIdUp: e,
                    empNameUp: $('input[name=empUpdateName]').val(),
                    idpNum1Up: $('input[name=empUpdateIdpNum1]').val(),
                    idpNum2Up: $('input[name=empUpdateIdpNum2]').val(),
                    emailUp: $('input[name=empUpdateEmail1]').val() + $('input[name=empUpdateEmail2]').val(),
                    telUp: $('input[name=empUpdateTel]').val(),
                    hireDateUp: $('input[name=empUpdateHireDate]').val(),
                    hqCodeUp: hqCodeVal,
                    // $('select[name=empUpdateHqCode]').val(),
                    depNoUp: depNoVal,
                    // $('select[name=empUpdateDepNo]').val(),
                    bankNameUp: $('select[name=empUpdateBankName]').val(),
                    accountUp: $('input[name=empUpdateAccount]').val(),
                    noteUp: $('textarea[name=empUpdateNote]').val(),
                    resYnUp: transResYnVal,
                    resDateUp: transResDateVal,
                    fileNameUp : fileSaveName,
                    filePathUp : filePath,
                },
            success: function () {
                console.log("성공");

                $('#ecmodal3').modal('hide');
                $('#ecmodal2').modal('hide');
                location.reload();

            },
            error: function () {
                console.log("error");
            }
        })

    }


}

//이중모달 취소버튼 클릭 시 모달 새로고침
function dataDismiss(e) {
    $('#ecmodal3').modal('hide');
    $('#ecmodal2').modal('hide');
    empGetTable(e);
    $('#ecmodal3').modal('show');
    $('#ecmodal2').modal('show');
    // $('.modal-updateEmp').location.reload();
}

//재직여부 밸류 붙여넣기 1
function attrValue() {
    $('.resYnClass').attr("value", "퇴사 (퇴사일 : " + attrResDate + ")");
}

//재직여부 밸류 붙여넣기 2
function attrValue2() {
    $('.resYnClass').attr("value", "재직 중");
}

//이미지 미리보기
function readImageUp(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            $('.empUpdateSignImg').attr("src", e.target.result);
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0]);
    }
}

//파일업로드 전용 ajax (폼데이타)
function formDataAjaxUp(formData) {
    $.ajax({
        type: "POST",
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        url: "/employee/empSignImgUp",

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
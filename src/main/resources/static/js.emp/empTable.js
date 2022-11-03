//empTable 모달 팝업 함수 정의(empId 값 받아서 select) ajax
function empGetTable(e) {
    let html1 = "";

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

                                    <!-- form header -->
                                    <div class="form-header"><br>
                                        <h1>인사 정보</h1>
                                    </div>
                                    <br>

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
                                            <label class="label-title">이메일</label>
                                            <input type="email" class="form-email"
                                                   value="${email1}" readonly>
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title my-0">&nbsp;</label>
                                            <input type="email" class="form-email"
                                                   value="${email2}" readonly>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">휴대전화</label>
                                        <input type="email" class="form-input"
                                               value="${tel}" readonly>
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
                                            <label class="label-title">급여정보</label>
                                            <select class="form-option" readonly>
                                                <option>${bankName}</option>
                                            </select>
                                        </div>
                                        <div class="form-group right">
                                            <label class="label-title">　</label>
                                            <input type="text" min="18" max="80"
                                                   class="form-input" value = "${account}" readonly>
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
                                        <label class="label-title">서명 파일 </label><br>                                         
                                        <img class="empTableSignImg" width="200" alt="첨부이미지 미리보기" src="${fileFakePath}"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="label-title">참고사항</label>
                                        <textarea class="form-input" rows="4" cols="50"
                                                  style="height:auto" readonly>${note}</textarea>
                                    </div>
                                </div>
                                <!-- form-footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" onclick="dataDismiss2('${empId}')"
                                            data-dismiss="modal">목록
                                    </button>
                                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#ecmodal3">수정</button>
                                </div>

                            `;

            $('.modal-searchEmp').empty().append(html1);
            // $('.empTableSignImg').attr("src","file:///private/tmp/2022_10_25_104704028_78824.jpg");
        },
        error: function () {
            console.log("error");
        }
    })
}

//이중모달 취소버튼 클릭 시 모달 새로고침
function dataDismiss2(e) {
    $('#ecmodal2').modal('hide');
    empGetTable(e);
    $('#ecmodal2').modal('show');
}
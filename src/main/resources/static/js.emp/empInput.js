let filePath;
let fileSaveName;
//empInput 등록모달 팝업 정의
function empInputModal() {
    let html3 = `

                                            <div class="form-body">
                                            <!-- form header -->
                                            <div class="form-header"><br>
                                                <h1>직원 등록</h1>
                                            </div>
                                            <br>
                                            <!-- Firstname and Lastname -->
                                            <div class="horizontal-group">
                                                <div class="form-group left">
                                                    <label class="label-title">이름</label><span class="ValiVali"></span>
                                                    <input type="text" class="form-input checkVali" name="empInputName"
                                                           placeholder="enter your name" required="required"/>
                                                </div>
                                                <div class="form-group right">
                                                    <label class="birth">주민번호</label><span class="ValiVali"></span><br>
                                                    <input type="text" class="form-input birth checkVali" name="empInputIdpNum1"
                                                           placeholder="ex) 900101" required="required">
                                                    <data class="dash">-</data>
                                                    <input type="text" class="form-input birth checkVali" name="empInputIdpNum2"
                                                           placeholder="1101011" required="required">
                                                </div>
                                            </div>

                                            <div class="horizontal-group">
                                                <div class="form-group left">
                                                    <label class="label-title">이메일</label><span class="ValiVali"></span><br>
                                                    <input type="email" class="form-email checkVali" name="empInputEmail1"
                                                           placeholder="enter your email" required="required">
                                                </div>
                                                <div class="form-group right">
                                                    <label class="label-title my-0">&nbsp;</label><span class="ValiVali"></span><br>
                                                    <input type="email" class="form-email checkVali" name="empInputEmail2" value="@sjht.ac.kr"
                                                           placeholder="@sjht.ac.kr" required="required"><p></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="label-title">휴대전화</label><span class="ValiVali"></span><br>
                                                <input type="tel" class="form-input checkVali" name="empInputTel"
                                                       pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13"
                                                       placeholder="enter your phone number" required="required">
                                            </div>

                                            <div class="form-group">
                                                <label class="label-title ">입사일</label><span class="ValiVali"></span><br>
                                                <input type="date" min="18" max="80" name="empInputHireDate"
                                                       class="form-input checkVali">
                                            </div>

                                            <div class="form-group">
                                                <label class="label-title">본부</label><span class="ValiVali"></span><br>
                                                <select class="form-input checkVali" name="empInputHqCode">
                                                    <option value="">본부</option>
                                                    <option value="SJHQ_0001">HR본부</option>
                                                    <option value="SJHQ_0002">ICT개발본부</option>
                                                    <option value="SJHQ_0003">솔루션사업본부</option>
                                                </select>
                                            </div>

                                            <div class="horizontal-group">
                                                <div class="form-group left">
                                                    <label class="label-title">부서</label><span class="ValiVali"></span><br>
                                                    <select class="form-input checkVali" name="empInputDepNo">
                                                        <option value="">부서</option>
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
                                                    <select class="form-input checkVali" name="empInputJobCode">
                                                        <option value="">직급</option>
                                                        <option value="SJPS_0001">사원</option>
                                                        <option value="SJPS_0002">대리</option>
                                                        <option value="SJPS_0003">과장</option>
                                                        <option value="SJPS_0004">팀장</option>
                                                        <option value="SJPS_0005">부장</option>
                                                        <option value="SJPS_0006">상무</option>
                                                        <option value="SJPS_0007">전무</option>
                                                        <option value="SJPS_0008">부대표</option>
                                                        <option value="SJPS_0009">대표</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="horizontal-group">
                                                <div class="form-group left mb-3">
                                                    <label class="label-title">급여정보</label><span class="ValiVali"></span><br>
                                                    <select class="form-option checkVali" name="empInputBankName" >
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
                                                <div class="form-group right mb-0">
                                                    <label class="label-title">&nbsp;</label><span class="ValiVali"></span><br>
                                                    <input type="text" min="18" max="80" name="empInputAccount"
                                                           class="form-input checkVali" /><p></p>
                                                </div>
                                            </div>
                                            
                                            <div class="horizontal-group">
                                                <div class="form-group left">
                                                    <label class="label-title">책정 급여(연별)</label><span class="ValiVali"></span><br>
                                                    <input type="text" class="form-input checkVali empInputSalary" name="empInputSalary"
                                                            required="required">     
                                                </div>
                                                <div class="form-group right">
                                                    <label class="label-title">예상 급여(월별)</label>
                                                    <input type="text" class="form-input empInputWage"
                                                            required="required" readonly>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="label-title">서명 파일 업로드</label><span class="ValiVali"></span><br>
                                                <img class="empInputSignImg" width="180" alt="첨부이미지 미리보기" src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image"/> <br>
                                                <input type="file" class="empInputSign float-left checkVali" size="80" accept="image/*" multiple/><br>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="label-title">참고사항</label>
                                                <textarea name="empInputNote"
                                                          class="form-input" rows="4" cols="50"
                                                          style="height:auto"></textarea>
                                            </div>
                                        </div>
                                        <!-- form-footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                    data-dismiss="modal">취소
                                            </button>
                                            <button onclick="empInput()" type="button" class="btn btn-primary">등록</button>
                                            <input type="hidden" class="checkValidation" value="n">
                                        </div>

                            `;
    $('.modal-inputEmp').empty().append(html3);
    //월급여 보여주기
    $('.empInputSalary').on("input", function (e){
        let exSalary = $('.empInputSalary').val();
        let exWage = Math.round((exSalary/12)/10)*10;
        exWage = exWage.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        $('.empInputWage').val(exWage+" 원");
    });
    //파일 입력이 되면 실행되는 함수
    $('.empInputSign').on("input", function (e) {
        let formData = new FormData;
        formData.delete("empInputSign");
        formData.append("empInputSign", e.target.files[0], e.target.files[0].name);

        //이미지변경 함수 사용
        readImage(e.target);
        //폼데이타 에이잭스 사용
        formDataAjax(formData);

        /* 입력 정보 확인용
        // 폼 객체 key 값을 순회.
        let keys = formData.keys();
        for (const pair of keys) {
            console.log(pair);
        }

        // 폼 객체 values 값을 순회.
        let values = formData.values();
        for (const pair of values) {
            console.log(pair);
        }

        // 폼 객체 key 와 value 값을 순회.
        let entries = formData.entries();
        for (const pair of entries) {
            console.log(pair[0] + ', ' + pair[1]);
        }
        */
    });
}

//이미지 미리보기
function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            $('.empInputSignImg').attr("src", e.target.result);
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0]);
    }
}

//empInput 함수 정의 ajax
function empInput() {
    let inputSalary = $('input[name=empInputSalary]').val();
    let inputWage = Math.round((inputSalary/12)/10)*10;
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
            url: "/employee/empInput",
            type: 'post',
            datatype: 'json',
            data: {
                empName: $('input[name=empInputName]').val(),
                idpNum1: $('input[name=empInputIdpNum1]').val(),
                idpNum2: $('input[name=empInputIdpNum2]').val(),
                email1: $('input[name=empInputEmail1]').val(),
                email2: $('input[name=empInputEmail2]').val(),
                tel: $('input[name=empInputTel]').val(),
                hireDate: $('input[name=empInputHireDate]').val(),
                hqCode: $('select[name=empInputHqCode]').val(),
                depNo: $('select[name=empInputDepNo]').val(),
                jobCode: $('select[name=empInputJobCode]').val(),
                bankName: $('select[name=empInputBankName]').val(),
                account: $('input[name=empInputAccount]').val(),
                note: $('textarea[name=empInputNote]').val(),
                inputFileName : fileSaveName,
                inputFilePath : filePath,
                salary: inputSalary,
                wage: inputWage,
            },
            success: function () {
                console.log("등록 성공")
                $('#ecmodal').modal('hide');
                empInputModal()
                $('#ecmodal').modal('show');
                location.reload();

            },
            error: function () {
                console.log("error");
            }
        })
    }



}

//파일업로드 전용 ajax (폼데이타)
function formDataAjax(formData){
    $.ajax({
        type: "POST",
        processData: false,
        contentType: false,
        enctype : 'multipart/form-data',
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

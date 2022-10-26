package com.choongang.erpproject.employee.dto;

import lombok.Data;

@Data
public class HrTableDto {
    String empId; //사원번호
    String authCode; // 권한코드.. 지만 권한명으로 불러야해
    String empName; // 성명
    String birth; //생년월일
    String tel; //연락처
    String email; //이메일
    String hqCode; // 본부코드
    String depNo; //부서코드
    String jobCode; // 직급코드
    String hireDate; // 입사일
    String resYn; // 퇴직여부..지만 재직/퇴사로 구분지어야함
    String note;

    /* 인사관리에서 안쓰는 부분
    String pw; //암호
    String idpNum; // 주민번호
    String resDate; // 퇴사일
    int salary; // 연봉
    int wage; // 기본급
    String vctYn; // 휴직유무
    String fileName; //파일명
    String filePath; //파일경로
    int fileSize; // 파일사이즈
    int totLev; //총 연차
    int useLev; //사용 연차
    String bankName; //은행명
    String account; //계좌번호
    String gender; //성별
    */

}

package com.choongang.erpproject.employee.dto;

import lombok.Data;

@Data
public class EmpInputDto {
    //pw, totLev, useLev, resYn, vctYn 디폴트 값
    String pw = "1111";
    String birth;
    String authCode;
    int totLev = 15;
    int useLev = 0;
    String resYn = "n";
    String vctYn = "n";
    String empName;
    String IdpNum;
    String email;
    String tel;
    String hireDate;
    String hqCode;
    String depNo;
    String jobCode;
    String bankName;
    String account;
    String note;
    String fileName;
    String filePath;
}

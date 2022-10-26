package com.choongang.erpproject.employee.dto;

import lombok.Data;

@Data
public class EmpUpdateDto {
    String empId;
    String birth;
    String resYn = "n";
    String resDate;
    String empName;
    String IdpNum;
    String email;
    String tel;
    String hireDate;
    String hqCode;
    String depNo;
    String bankName;
    String account;
    String note;
    String fileName;
    String filePath;
}

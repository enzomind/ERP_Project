package com.choongang.erpproject.employee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class employeeDto {
    String empId;
    String pw;
    String empName;
    String tel;
    String idpNum;
    String birth;
    String hireDate;
    String resDate;
    int salary;
    int wage;
    String resYn;
    String vctYn;
    String fileName;
    String filePath;
    int fileSize;
    String depNo;
    int totLev;
    int useLev;
    String email;
    String bankName;
    String account;
    String hqCode;
    String jobCode;
    String authCode;
    String gender;
}

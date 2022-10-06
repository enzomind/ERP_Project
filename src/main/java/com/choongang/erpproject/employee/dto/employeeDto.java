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
    String idp_num;
    String birth;
    String hire_date;
    String res_date;
    int salary;
    int wage;
    String res_yn;
    String vct_yn;
    String filename;
    String filepath;
    int filesize;
    String dep_no;
    int tot_lev;
    int use_lev;
    String email;
    String bankname;
    String account;
    String hq_code;
    String job_code;
    String authCode;
    String gender;
}

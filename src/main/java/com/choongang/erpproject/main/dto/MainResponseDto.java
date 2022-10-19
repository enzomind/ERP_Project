package com.choongang.erpproject.main.dto;

import lombok.Getter;

@Getter
public class MainResponseDto {

    //부서, 이름, 직급, 휴가 구분
    private String depName;
    private String empName;
    private String jobName;
    private String levType;

}

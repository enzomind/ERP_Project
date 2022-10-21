package com.choongang.erpproject.main.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MainResponseDto {

    //부서, 이름, 직급, 휴가 구분
    private String depName;
    private String empName;
    private String jobName;
    private String levType;

    //공지사항 제목, 작성일자
    private int ntcNum;
    private String title;
    private String date;
}

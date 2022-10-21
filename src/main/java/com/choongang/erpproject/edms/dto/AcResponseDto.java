package com.choongang.erpproject.edms.dto;

import lombok.Getter;

import java.time.LocalDate;

//select
@Getter
public class AcResponseDto {
    //결재구분
    private String majCode;
    //결의번호
    private String expNum;
    //제목
    private String expTitle;
    //상신일자(등록일자)
    private LocalDate applDate;
    //상태
    private String apprState;

    private LocalDate apprDate;

    //작성자
    private String empName;
    //결재자
    private String appr;

    //소속
    private String hqName;
    private String depName;

    //계정과목
    private String detCode;
    //적요
    private String remk;
    //카드/계좌
    private String comAcc;
    //금액
    private int expense;

    //증빙서류
    private String attFile;
    private String attFilepath;
    private int attFilesize;
}

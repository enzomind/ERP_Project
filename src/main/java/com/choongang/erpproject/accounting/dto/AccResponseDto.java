package com.choongang.erpproject.accounting.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class AccResponseDto {


//    회계전표 리스트
//    전표번호, 거래처명, 전표 생성일자, 지출금액, 수입금액;
//    상세내역(지출결의서)
//    결의번호, 기안자, 승인자, 승인일자, 거래처명(카드/계좌), 지출금액, 수입금액;

    //전표 정보
    private int statNum; //전표번호
    private LocalDate statDate; //전표발생날짜

    //카드/계좌 정보
    private String comAcc; // 카드/계좌(거래처명)

    //유저테이블 정보
    private String empId; //사번
    private String empName; //기안자

    //지출결의서 정보
    private int expId; //결의자
    private String expTitle; //지출결의서 제목
    private String expNum; //결의번호
    private LocalDate applDate; //신청일자(지출결의서 상신일자)
    private LocalDate apprDate; //지출결의서 승인일자
    private String appr; //승인자
    private int expense; //지출금액
    private int income; //수입금액
    private String remk; //적요

}

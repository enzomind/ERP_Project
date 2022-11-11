package com.choongang.erpproject.accounting.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AccRequestDto {

    private Long statNum; //전표번호
    private LocalDate statDate; //발생날짜
    private String expNum; //결의번호
    private String empId; //사번

    private LocalDate startDate; //기간조회 시작일자
    private LocalDate endDate; //기간조회 종료일자

    private Double payTotal; //당월 급여금액
    private LocalDate paymdate; //급여이체일자
}

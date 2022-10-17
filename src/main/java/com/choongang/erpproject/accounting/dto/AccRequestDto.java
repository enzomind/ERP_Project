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

    private LocalDate startDate;
    private LocalDate endDate;
}

package com.choongang.erpproject.edms.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

//목록 조회 dto

@Data
public class HrRequestDto {
    private Long levId;
    private String levNum;
    private String appr;
    private LocalDate applDate;
    private String levType;
    private String levTitle;
    private String levContent;
    private Date startDate;
    private Date endDate;
    private Date levTerm;
}

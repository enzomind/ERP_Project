package com.choongang.erpproject.edms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

//목록 조회 dto


@Data
public class HrRequestDto {
    private Long levId;
    private String levNum;
    private String appr;
    private String apprState;
    private String apprDate;
    private String applDate;
    private String levType;
    private String levTitle;
    private String levContent;
    private String startDate;
    private String endDate;
    private int levTerm;
    private String empId;


}

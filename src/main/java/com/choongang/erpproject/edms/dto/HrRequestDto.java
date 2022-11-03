package com.choongang.erpproject.edms.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

//목록 조회 dto


@Data
public class HrRequestDto {
    private Long levId;
    private String levNum;
    private String appr;
    private String apprId;
    private String apprState;
    private String apprDate;
    private String applDate;
    private String levType;
    private String levTitle;
    private String levContent;
    private String startDate;
    private String endDate;
    private int levTerm;

    //작성자
    private String empId;
    private String empName;

    //소속
    private String hqName;
    private String depName;
    private String jobName;


}

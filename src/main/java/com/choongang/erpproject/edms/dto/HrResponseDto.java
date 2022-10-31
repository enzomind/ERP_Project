package com.choongang.erpproject.edms.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

//상세 조회 dto
@Getter
public class HrResponseDto {

    private Long levId;
    private String levNum;
    private String appr;
    private String apprState;
    private LocalDate apprDate;
    private LocalDate applDate;
    private String levType;
    private String levTitle;
    private String levContent;

    //작성자
    private String empId;
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    private String empName;

    //소속
    private String hqName;
    private String depName;
    private String jobName;

}

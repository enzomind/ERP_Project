package com.choongang.erpproject.edms.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EdmsResponseDto {
    private String majCode;
    private String num;
    private String title;
    private LocalDate applDate;
    private String apprState;
    private String apprId;
}

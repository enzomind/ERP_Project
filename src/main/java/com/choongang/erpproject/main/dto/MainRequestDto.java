package com.choongang.erpproject.main.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MainRequestDto {
    private int month;
    private String empId;
}

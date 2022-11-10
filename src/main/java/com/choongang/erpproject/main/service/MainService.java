package com.choongang.erpproject.main.service;

import com.choongang.erpproject.main.dto.MainRequestDto;
import com.choongang.erpproject.main.dto.MainResponseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MainService {

    List<Map<String, Object>> getCalAll();
    List<MainResponseDto> getCalDetail(LocalDate selectDate);

    int getHireDash();

    Long getEmpDash();

    int getExpreportDash(MainRequestDto params);

    List<MainResponseDto> getNoticeDash();

    List<MainResponseDto> getBirthDash();

}

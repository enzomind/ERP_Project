package com.choongang.erpproject.main.service;

import com.choongang.erpproject.main.dto.MainResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface MainService {

    List<MainResponseDto> getCalAll();
    List<MainResponseDto> getCalDetail(LocalDate selectDate);

}

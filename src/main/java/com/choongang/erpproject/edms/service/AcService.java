package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;

import java.util.List;

public interface AcService {

    List<AcResponseDto> findAll();
    List<AcResponseDto> findByNum(String expNum);
    void save(AcRequestDto acRequestDto);
}

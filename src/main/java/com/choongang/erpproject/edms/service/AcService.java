package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;

import java.util.List;

public interface AcService {

    List<AcResponseDto> findAll();
    List<AcResponseDto> findByNum(String expNum);
    List<AcResponseDto> findAc();
    AcResponseDto findWriter(String id);
    void save(AcRequestDto acRequestDto);

    void saveList(List<AcRequestDto> acRequestDtoList);

    void updateNum(List<AcRequestDto> acRequestDtoList);

    void updateList(AcRequestDto acRequestDto);

}

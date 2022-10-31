package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;

import java.util.List;

public interface AcService {

    List<AcResponseDto> findAllOut(String id);
    List<AcResponseDto> findAllIn(String id);
    List<AcResponseDto> findByNum(String expNum);
    List<AcResponseDto> findAc();
    AcResponseDto findWriter(String id);
    void saveList(List<AcRequestDto> acRequestDtoList);

    void updateNum(List<AcRequestDto> acRequestDtoList);

    void updateList(AcRequestDto acRequestDto);

}

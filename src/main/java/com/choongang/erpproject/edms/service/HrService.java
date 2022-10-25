package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;

import java.util.List;

public interface HrService {

    List<HrResponseDto> getLevList();

    HrResponseDto getLevDetail(Long levId);

    void writeSave(HrRequestDto hrRequestDto);

    void stateSave(HrRequestDto hrRequestDto);

}

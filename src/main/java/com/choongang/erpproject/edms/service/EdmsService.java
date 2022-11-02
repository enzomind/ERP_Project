package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.EdmsRequestDto;
import com.choongang.erpproject.edms.dto.EdmsResponseDto;

import java.util.List;

public interface EdmsService {

    List<EdmsResponseDto> findAll(EdmsRequestDto params);
}

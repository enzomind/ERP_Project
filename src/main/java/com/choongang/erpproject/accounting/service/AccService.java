package com.choongang.erpproject.accounting.service;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;

import java.util.List;

public interface AccService {

    List<AccResponseDto> getAccList();

    List<AccResponseDto> getAccDetail(Long statNum);

}

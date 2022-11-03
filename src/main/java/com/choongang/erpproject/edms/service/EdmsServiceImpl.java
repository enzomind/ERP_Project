package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.edms.dto.EdmsRequestDto;
import com.choongang.erpproject.edms.dto.EdmsResponseDto;
import com.choongang.erpproject.edms.mapper.EdmsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EdmsServiceImpl implements EdmsService {

    private final EdmsMapper edmsMapper;

    @Override

    public List<EdmsResponseDto> findAll(EdmsRequestDto params) {

        List<EdmsResponseDto> list = edmsMapper.findAll(params);

        return list;

    }
}

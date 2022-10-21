package com.choongang.erpproject.main.service;

import com.choongang.erpproject.main.dto.MainRequestDto;
import com.choongang.erpproject.main.dto.MainResponseDto;
import com.choongang.erpproject.main.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{

    private final MainMapper mainMapper;

    @Override
    public List<Map<String, Object>>  getCalAll() {
        return mainMapper.getCalAll();
    }

    @Override
    public List<MainResponseDto> getCalDetail(LocalDate selectDate) {
        return null;
    }

    @Override
    public int getHireDash(MainRequestDto params) {
        return mainMapper.getHireDash(params);
    }

    @Override
    public Long getEmpDash() {
        return mainMapper.getEmpDash();
    }

    @Override
    public int getExpreportDash(MainRequestDto params) {
        return mainMapper.getExpreportDash(params);
    }

    @Override
    public List<MainResponseDto> getNoticeDash() {
        return mainMapper.getNoticeDash();
    }
}

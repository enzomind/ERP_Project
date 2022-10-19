package com.choongang.erpproject.main.service;

import com.choongang.erpproject.main.dto.MainResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    @Override
    public List<MainResponseDto> getCalAll() {
        return null;
    }

    @Override
    public List<MainResponseDto> getCalDetail(LocalDate selectDate) {
        return null;
    }
}

package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.mapper.AcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDate.now;

@Service
public class AcServiceImpl implements AcService{
    @Autowired
    private AcMapper acMapper;
    @Override
    public List<AcResponseDto> findAll() {
        List<AcResponseDto> list = acMapper.selectList();
        return list;
    }

    @Override
    public List<AcResponseDto> findByNum(String expNum) {
        List<AcResponseDto> detail = acMapper.selectDetail(expNum);
        return detail;
    }

    @Override
    public void save(AcRequestDto acRequestDto) {
        acMapper.insert(acRequestDto);
    }

    @Override
    public void saveList(List<AcRequestDto> acRequestDtoList) {
        acMapper.insertList(acRequestDtoList);
    }

}

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
    public List<AcResponseDto> findAllOut(String id) {
        List<AcResponseDto> list = acMapper.selectListOut(id);
        return list;
    }

    @Override
    public List<AcResponseDto> findAllIn(String id) {
        List<AcResponseDto> list = acMapper.selectListIn(id);
        return list;
    }

    @Override
    public List<AcResponseDto> findByNum(String expNum) {
        List<AcResponseDto> detail = acMapper.selectDetail(expNum);
        return detail;
    }

    @Override
    public List<AcResponseDto> findAc() {
        List<AcResponseDto> acList = acMapper.selectAcList();
        return acList;
    }

    @Override
    public AcResponseDto findWriter(String id) {
        AcResponseDto writerInfo = acMapper.selectWriter(id);
        return writerInfo;
    }

    @Override
    public String viewExpNum() {
        String viewExpNum = acMapper.expNumView();
        return viewExpNum;
    }

    @Override
    public void saveList(List<AcRequestDto> acRequestDtoList) {
        acMapper.insertList(acRequestDtoList);
    }

    @Override
    public void updateNum(List<AcRequestDto> acRequestDtoList) {
        acMapper.updateExpNum(acRequestDtoList);
    }

    @Override
    public void updateList(AcRequestDto acRequestDto) {
        acMapper.update(acRequestDto);
    }

}

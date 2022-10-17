package com.choongang.erpproject.accounting.service;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.mapper.AccMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccServiceImpl implements AccService {

    private final AccMapper accMapper;

    @Override
    public List<AccResponseDto> getAccList(AccRequestDto params) {

        List<AccResponseDto> list = Collections.emptyList();

        int listCount = accMapper.listCount();

        if(listCount > 0) {
            list = accMapper.getAccList(params);
        }
        return list;
    }

    @Override
    public List<AccResponseDto> getAccDetail(Long statNum) {
        List<AccResponseDto> detailList = Collections.emptyList();

        int detailListCount = accMapper.listCount();

        if(detailListCount > 0) {
            detailList = accMapper.getAccDetail(statNum);
        }
        return detailList;
    }

}

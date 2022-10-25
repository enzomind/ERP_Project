package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.mapper.HrMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HrServiceImpl implements HrService {
    private final HrMapper hrMapper;

    @Override
    public List<HrResponseDto> getLevList() {
        List<HrResponseDto> list = Collections.emptyList();
        int listCount = hrMapper.listCount();
        if(listCount > 0) {
            list = hrMapper.getLevList();
        }
        return list;
    }

    @Override
    public HrResponseDto getLevDetail(Long levId) {
        HrResponseDto detail = hrMapper.getLevDetail(levId);
        return detail;
    }

    @Override
    public void writeSave(HrRequestDto hrRequestDto) {
        hrMapper.writeSave(hrRequestDto);
    }

    @Override
    public void stateSave(HrRequestDto hrRequestDto) {
        hrMapper.stateSave(hrRequestDto);

    }

}

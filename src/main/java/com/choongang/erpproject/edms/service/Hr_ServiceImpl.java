package com.choongang.erpproject.edms.service;


import com.choongang.erpproject.edms.Repository.Hr_Mapper;
import com.choongang.erpproject.edms.dto.Hr_ReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Hr_ServiceImpl {
    private final Hr_Mapper hr_mapper;

    public int levCount() {
        return hr_mapper.levCount();
    }

    public List<Hr_ReportDto> levList() {
        return hr_mapper.findAll();
    }

    public Hr_ReportDto findById(Long lev_num){
        return hr_mapper.findById(lev_num);
    }

    @Transactional
    public Long insert(Hr_ReportDto hr_reportDto) {
        hr_mapper.save(hr_reportDto);
        return hr_reportDto.getLev_num();
    }

    

}

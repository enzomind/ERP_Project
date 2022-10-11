package com.choongang.erpproject.edms.Repository;

import com.choongang.erpproject.edms.dto.Hr_ReportDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Hr_Mapper {
    int levCount();

    List<Hr_ReportDto> findAll();

    Hr_ReportDto findById(Long lev_num);

    void save(Hr_ReportDto hr_reportDto);
}

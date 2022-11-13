package com.choongang.erpproject.main.mapper;

import com.choongang.erpproject.main.dto.MainRequestDto;
import com.choongang.erpproject.main.dto.MainResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MainMapper {

    List<Map<String, Object>> getCalAll();

    List<MainResponseDto> getCalDetail(MainRequestDto params);

    int getHireDash();

    Long getEmpDash();

    int getExpreportDash(MainRequestDto params);

    List<MainResponseDto> getNoticeDash();

    List<MainResponseDto> getBirthDash();

}

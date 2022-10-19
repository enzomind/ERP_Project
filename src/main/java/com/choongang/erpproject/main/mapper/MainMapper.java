package com.choongang.erpproject.main.mapper;

import com.choongang.erpproject.main.dto.MainRequestDto;
import com.choongang.erpproject.main.dto.MainResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MainMapper {

    List<MainResponseDto> getCalAll();

    List<MainResponseDto> getCalDetail(MainRequestDto params);

}

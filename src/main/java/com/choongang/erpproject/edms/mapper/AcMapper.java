package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcMapper {

    //지결 리스트 조회
    List<AcResponseDto> selectList();

    //지결 상세페이지 조회
    List<AcResponseDto> selectDetail(String expNum);


    //지결 입력
    void insert(AcRequestDto acRequestDto);
}

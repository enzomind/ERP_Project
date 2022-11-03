package com.choongang.erpproject.accounting.mapper;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccMapper {

    //전표 생성
    void insertAccInfo(String param);

    //전표 조회
    List<AccResponseDto> getAccList(AccRequestDto params);

    //전표 상세 조회(전표번호 id) / return 결의번호 리스트
    List<AccResponseDto> getAccDetail(Long statNum);

    //결의번호 조회
    String getExpNum(Long statNum);

    int listCount();

}
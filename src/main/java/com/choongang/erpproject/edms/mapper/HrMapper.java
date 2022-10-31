package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface HrMapper {

    //목록 조회
    List<HrResponseDto> getLevList();

    //상세 조회(결의번호 id)
    //HrResponseDto getLevDetail(Long levId);
    HrResponseDto selectDetail(Long levId);

    //담장자 리스트 조회
    List<HrResponseDto> selectHrList();

    HrResponseDto selectWriter(String id);

    void writeSave(HrRequestDto hrRequestDto);

    void stateSave(HrRequestDto hrRequestDto);

    int listCount();

}

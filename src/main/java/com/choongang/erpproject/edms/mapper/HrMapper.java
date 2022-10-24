package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface HrMapper {

    //목록 조회
    List<HrResponseDto> getLevList();

    // 상세 조회(결의번호 id)
    HrResponseDto getLevDetail(Long levId);

    void writesave(HrRequestDto hrRequestDto);

    void statesave(HrRequestDto hrRequestDto);

    int listCount();

}

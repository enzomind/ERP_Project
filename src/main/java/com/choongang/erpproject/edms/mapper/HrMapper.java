package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.HrResponseDto;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface HrMapper {

    //전표 조회
    List<HrResponseDto> getLevList();

    //전표 상세 조회(전표번호 id) / return 결의번호 리스트
    List<HrResponseDto> getLevDetail(Long lev_id);

    //결의번호 조회
    String getLevNum(Long lev_num);

    int listCount();

}

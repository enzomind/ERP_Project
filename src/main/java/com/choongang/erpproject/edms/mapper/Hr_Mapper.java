package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.Hr_ResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Hr_Mapper {

    //전표 조회
    List<Hr_ResponseDto> getLevList();

    //전표 상세 조회(전표번호 id) / return 결의번호 리스트
    List<Hr_ResponseDto> getLevDetail(Long lev_id);

    //결의번호 조회
    String getLevNum(Long lev_num);

    int listCount();

}

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

    //모달 회계담당자 조회
    List<AcResponseDto> selectAcList();

    //지결 입력(안쓸듯)
    void insert(AcRequestDto acRequestDto);

    //지결 여러개 입력
    void insertList(List<AcRequestDto> acRequestDtoList);

    //지결 수신함 업데이트(apprState,apprDate 변경)
    void update(AcRequestDto acRequestDto);
}

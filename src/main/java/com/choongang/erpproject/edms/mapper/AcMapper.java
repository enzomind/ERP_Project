package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcMapper {

    //지결 상신함 조회
    List<AcResponseDto> selectListOut(String id);

    //지결 수신함 조회
    List<AcResponseDto> selectListIn(String id);

    //상세페이지 조회
    List<AcResponseDto> selectDetail(String expNum);

    //모달 회계담당자 조회
    List<AcResponseDto> selectAcList();

    //상세페이지에서 로그인 정보 조회
    AcResponseDto selectWriter(String id);

    //지결 여러개 입력
    void insertList(List<AcRequestDto> acRequestDtoList);

    //입력된 지결의 결의번호를 마지막 +1로 변경
    void updateExpNum(List<AcRequestDto> acRequestDtoList);

    //지결 수신함 업데이트(버튼 눌러서 승인상태, 승인날짜 변경)
    void update(AcRequestDto acRequestDto);
}

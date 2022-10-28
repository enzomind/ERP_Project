package com.choongang.erpproject.employee.dao;

import com.choongang.erpproject.employee.dto.*;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    //직원조회 화면 정보
    List<HrTableDto> getHrTable();
    List<HrTableDto> getHrTable(HrTableDto hrTableDto);

    //직원열람 모달 정보
    List<EmpTableDto> getEmpTable(String empId);
    //서명 정보
    List<EmpSignDto> getEmpSign(String empId);
    //직원 등록
    void empInput(EmpInputDto empInputDto);
    //직원 수정
    void empUpdate(EmpUpdateDto empUpdateDto);



}

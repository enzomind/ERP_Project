package com.choongang.erpproject.employee.service;

import com.choongang.erpproject.employee.dto.*;

import java.util.List;
import java.util.Map;

public interface EmpService {

    //직원조회 화면 정보
    List<HrTableDto> getHrTable();
    //직원열람 모달 정보
    List<EmpTableDto> getEmpTable(String empId);
    //서명 정보
    List<EmpSignDto> getEmpSign(String empId);
    //직원 등록
    void empInput(EmpInputDto empInputDto);
    //직원 수정
    void empUpdate(EmpUpdateDto empUpdateDto);





}

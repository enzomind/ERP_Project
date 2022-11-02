package com.choongang.erpproject.mypage.mapper;

import com.choongang.erpproject.employee.dto.EmpUpdateDto;
import com.choongang.erpproject.employee.dto.HrTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MpMapper {
    String getUserPw(String empId);

    void updateUserPw(String empId, String empPw);

    List<HrTableDto> myEmpSel(String empId);

    void myPageUpdate(EmpUpdateDto empUpdateDto);
}

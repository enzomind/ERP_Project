package com.choongang.erpproject.mypage.mapper;

import com.choongang.erpproject.employee.dto.EmpTableDto;
import com.choongang.erpproject.employee.dto.EmpUpdateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MpMapper {
    String getUserPw(String empId);

    void updateUserPw(String empId, String empPw);

    List<EmpTableDto> myEmpSel(String empId);

    void myPageUpdate(EmpUpdateDto empUpdateDto);
}

package com.choongang.erpproject.mypage.service;

import com.choongang.erpproject.employee.dto.EmpTableDto;
import com.choongang.erpproject.employee.dto.EmpUpdateDto;
import com.choongang.erpproject.mypage.mapper.MpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MpService {
    @Autowired
    MpMapper mpMapper;

    PasswordEncoder passwordEncoder;
    @Autowired
    public MpService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    //비밀번호 변경 시 기존 패스워드 셀렉트
    public boolean getUserPw(String empId, String pw){
        String UserPw = mpMapper.getUserPw(empId);
        if (passwordEncoder.matches(pw, UserPw)){
            System.out.println("성공");
            return true;
        } else {
            return false;
        }
    }

    //비밀번호 변경 업데이트
    public void updateUserPw(String empId, String empPw){
        System.out.println(empPw);
        String encodePw = passwordEncoder.encode(empPw);
        mpMapper.updateUserPw(empId, encodePw);
    }

    //개인정보 변경창 셀렉트
    public List<EmpTableDto> myEmpSel(String empId){
        List<EmpTableDto> list = mpMapper.myEmpSel(empId);
        return list;
    }

    //개인정보 변경 업데이트
    public void myPageUpdate(EmpUpdateDto empUpdateDto) {
        mpMapper.myPageUpdate(empUpdateDto);
    };
}

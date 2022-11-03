package com.choongang.erpproject.mypage.controller;

import com.choongang.erpproject.employee.dto.EmpTableDto;
import com.choongang.erpproject.employee.dto.HrTableDto;
import com.choongang.erpproject.mypage.mapper.MpMapper;
import com.choongang.erpproject.mypage.service.MpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping("/mypage")
public class MpCont {

    @Autowired
    MpService mpService;

    // 마이페이지 패스워드조회
    @GetMapping("/getUserName")
    public String returnUser(Principal principal){
        String UserCode = principal.getName();
        String UserPw = mpService.getUserPw(UserCode);
        return UserPw;
    }

    // 마이페이지 정보조회
    @GetMapping("/myEmpUp")
    public List<EmpTableDto> myEmpUp (Principal principal, Model model){
        String empId = principal.getName();
        return mpService.myEmpSel(empId);
    }

}

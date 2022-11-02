package com.choongang.erpproject.mypage.controller;

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
    @GetMapping("/getUserName")
    public String returnUser(Principal principal){
        String UserCode = principal.getName();
        String UserPw = mpService.getUserPw(UserCode);
        return UserPw;
    }

    @GetMapping("/myEmpUp")
    public List<HrTableDto> myEmpUp (Principal principal, Model model){
        String empId = principal.getName();
        return mpService.myEmpSel(empId);
    }



}

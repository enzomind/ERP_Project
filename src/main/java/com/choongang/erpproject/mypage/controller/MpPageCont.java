package com.choongang.erpproject.mypage.controller;

import com.choongang.erpproject.employee.dto.EmpUpdateDto;
import com.choongang.erpproject.employee.dto.HrTableDto;
import com.choongang.erpproject.mypage.service.MpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Controller
@RequestMapping("/mypage")
public class MpPageCont {

    @Autowired
    MpService mpService;

    @GetMapping("/mp1")
    public String mp1Root(){

        return "/mypage/mp";
    }

    @GetMapping("/mp2")
    public String mp2Root(){
        return "/mypage/mp2";
    }

    @PostMapping("/UpdatePw")
    @ResponseBody
    public void UpdatePw (@RequestParam("UpdatePw") String pw, Principal principal) {
        String empId = principal.getName();
        System.out.println(pw);
        mpService.updateUserPw(empId, pw);
    }

    // 서명 파일 업로드
    @PostMapping("/myPageSignImgUp")
    @ResponseBody
    public List<Map<String, Object>> fileUpload(@RequestParam("myPageSign") List<MultipartFile> files) throws IllegalStateException, IOException {
        List<Map<String, Object>> dataList = new ArrayList<>();

        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getOriginalFilename().length() != 0) {

                String originName = files.get(i).getOriginalFilename();//파일이름
                String exten = originName.substring(originName.lastIndexOf("."), originName.length());//확장자
                String random = "";//랜덤값
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
                int rndNum = (int) (Math.random() * 100000);
                random = sdf.format(new Date(System.currentTimeMillis())) + "_" + rndNum + exten;
                path = "resources/upload/";
                File f = new File(path + random);//저장위치

                //사용자 컴퓨터에 해당하는 파일 경로 없을때 폴더 생성
                f.getParentFile().mkdirs();

                //파일 업로드
                files.get(i).transferTo(f.getAbsoluteFile());

                Map<String, Object> dataMap = new HashMap<String, Object>();
                dataMap.put("file_seq", 0);
                dataMap.put("file_name", originName);
                dataMap.put("save_file_name", random);
                dataMap.put("file_path", path);
                dataList.add(dataMap);
                System.out.println(dataList);
            }

        }
        return dataList;
    }


    @PostMapping("/myPageUpdate")
    @ResponseBody
    public void myPageUpdate(EmpUpdateDto empUpdateDto, Principal principal){
        String empId = principal.getName();
        empUpdateDto.setEmpId(empId);
        mpService.myPageUpdate(empUpdateDto);
    }
}

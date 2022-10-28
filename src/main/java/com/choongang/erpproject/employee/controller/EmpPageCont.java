package com.choongang.erpproject.employee.controller;

import com.choongang.erpproject.employee.dto.*;

import com.choongang.erpproject.employee.service.EmpService;
import com.choongang.erpproject.employee.service.EmpServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmpPageCont {
    @Autowired
    EmpService empService;

    //기본 루트
    @GetMapping("hr_emp")
    public String empPageRoot(Model model) {

        model.addAttribute("hrTable", empService.getHrTable());

        return "employee/employee_1";
    }

    //검색 루트
    @PostMapping("/filter")
    public String filter(HrTableDto hrTableDto, Model model) {

        List<HrTableDto> list = empService.getHrTable(hrTableDto);
        model.addAttribute("hrTable", list);

        return "employee/employee_1_FilterResult";
    }

    //버튼 반복 시 발생하는 url 중복 제거
    @GetMapping(value = {"employee/hr_emp", "employee/employee/hr_emp"})
    public String empPageRoot2(Model model) {
        model.addAttribute("hrTable", empService.getHrTable());
        return "redirect:/employee/hr_emp";
    }

    //직원 목록 모달
    @PostMapping("/empGetTable")
    @ResponseBody
    public List<EmpTableDto> getEmpPerson(@RequestParam("empId") String empId, Model model) {
        List<EmpTableDto> getPersonlist = empService.getEmpTable(empId);
        return getPersonlist;
    }

    //직원 등록
    @PostMapping("/empInput")
    @ResponseBody
    public String empInputRoot(@RequestParam Map<String, Object> map) {

        EmpInputDto empInputDto = new EmpInputDto();

        //주민번호 앞자리 -> 생년월일
        String transBirth = EmpServiceImpl.getBirthday(String.valueOf(map.get("idpNum1")));
        //부서,직급 -> 권한
        String transAuthCode = EmpServiceImpl.getAuthCode(String.valueOf(map.get("depNo")), String.valueOf(map.get("jobCode")));

        //pw, totLev, useLev, resYn, vctYn 디폴트 값
        empInputDto.setBirth(transBirth);
        empInputDto.setAuthCode(transAuthCode);
        empInputDto.setEmpName(String.valueOf(map.get("empName")));
        empInputDto.setIdpNum(String.valueOf(map.get("idpNum1")) + '-' + String.valueOf(map.get("idpNum2")));
        empInputDto.setEmail(String.valueOf(map.get("email1")) + String.valueOf(map.get("email2")));
        empInputDto.setTel(String.valueOf(map.get("tel")));
        empInputDto.setHireDate(String.valueOf(map.get("hireDate")));
        empInputDto.setHqCode(String.valueOf(map.get("hqCode")));
        empInputDto.setDepNo(String.valueOf(map.get("depNo")));
        empInputDto.setJobCode(String.valueOf(map.get("jobCode")));
        empInputDto.setBankName(String.valueOf(map.get("bankName")));
        empInputDto.setAccount(String.valueOf(map.get("account")));
        empInputDto.setNote(String.valueOf(map.get("note")));
        empInputDto.setFileName(String.valueOf(map.get("inputFileName")));
        empInputDto.setFilePath(String.valueOf(map.get("inputFilePath")));

        empService.empInput(empInputDto);
        return "/employee/employee_1_FilterResult.html";
    }

    //직원 수정
    @PostMapping("/empUpdate")
    @ResponseBody
    public String empUpdateRoot(@RequestParam Map<String, Object> map) {

        EmpUpdateDto empUpdateDto = new EmpUpdateDto();

        //주민번호 앞자리 -> 생년월일
        String transBirth = EmpServiceImpl.getBirthday(String.valueOf(map.get("idpNum1Up")));

        empUpdateDto.setBirth(transBirth);
        empUpdateDto.setEmpId(String.valueOf(map.get("empIdUp")));
        empUpdateDto.setEmpName(String.valueOf(map.get("empNameUp")));
        empUpdateDto.setIdpNum(String.valueOf(map.get("idpNum1Up")) + '-' + String.valueOf(map.get("idpNum2Up")));
        empUpdateDto.setEmail(String.valueOf(map.get("emailUp")));
        empUpdateDto.setTel(String.valueOf(map.get("telUp")));
        empUpdateDto.setHireDate(String.valueOf(map.get("hireDateUp")));
        empUpdateDto.setHqCode(String.valueOf(map.get("hqCodeUp")));
        empUpdateDto.setDepNo(String.valueOf(map.get("depNoUp")));
        empUpdateDto.setBankName(String.valueOf(map.get("bankNameUp")));
        empUpdateDto.setAccount(String.valueOf(map.get("accountUp")));
        empUpdateDto.setNote(String.valueOf(map.get("noteUp")));
        empUpdateDto.setResYn(String.valueOf(map.get("resYnUp")));
        empUpdateDto.setResDate(String.valueOf(map.get("resDateUp")));
        empUpdateDto.setFileName(String.valueOf(map.get("fileNameUp")));
        empUpdateDto.setFilePath(String.valueOf(map.get("filePathUp")));

        empService.empUpdate(empUpdateDto);
        return "redirect:/employee/hr_emp";
    }

    //서명파일 업로드
    @PostMapping("/empSignImgUp")
    @ResponseBody
    public List<Map<String, Object>> fileUpload(@RequestParam("empInputSign") List<MultipartFile> files) throws IllegalStateException, IOException {
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

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

    //서명정보 현재 미사용
    @PostMapping("/getEmpSign")
    @ResponseBody
    public List<EmpSignDto> getEmpSign(@RequestParam("empId") String empId) {
        List<EmpSignDto> empSign = empService.getEmpSign(empId);
        return empSign;
    }


}
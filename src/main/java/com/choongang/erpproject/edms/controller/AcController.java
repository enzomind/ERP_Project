package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.accounting.service.AccService;
import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.service.AcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AcController {
    @Autowired
    private AcService acService;
    @Autowired
    private AccService accService;

    //상신함 리스트
    @GetMapping("/edms/edms_1")
    public String goEc(Model model,Principal principal){
        String id = principal.getName();
        List<AcResponseDto> acResponseDtos = acService.findAllOut(id);
        model.addAttribute("acResponseDtos",acResponseDtos);
        return "/edms/ec_H/edms_1";
    }

    //지결 상신함 상세
    @GetMapping("/edms/edms_ac_detail_1/{expNum}")
    public String goDetail(@PathVariable("expNum") String expNum, Model model1){
        List<AcResponseDto> acResponseDto = acService.findByNum(expNum);
        model1.addAttribute("acResponseDto", acResponseDto);
//        model
        return "/edms/ec_H/edms_ac_detail_1";
    }

    //지결 입력폼 이동
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/edms/edms_acform")
    public String goAcform(Model model, Model model2, Model model3, Principal principal){
        List<AcResponseDto> acList = acService.findAc();
        model.addAttribute("acList", acList);
        String id = principal.getName();
        model2.addAttribute("empInfo",acService.findWriter(id));
        model3.addAttribute("expNum", acService.viewExpNum());
        return "/edms/ec_H/edms_acform";
    }

    //지결 입력
    @PostMapping("/edms/edms_1")
    public String submitForm(AcRequestDto acRequestDto) {
        List<AcRequestDto> list = acRequestDto.getAcRequestDtoList();
        List<AcRequestDto> listReal = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            if(list.get(i).getExpense() != 0){
                listReal.add(list.get(i));
            }
        }
        acService.saveList(listReal);
        acService.updateNum(listReal);
        return "redirect:/edms/edms_1";
    }


    //수신함 리스트
    @GetMapping("/edms/edms_2")
    public String goEc2(Model model,Principal principal){
        String id = principal.getName();
        List<AcResponseDto> acResponseDtos = acService.findAllIn(id);
        model.addAttribute("acResponseDtos",acResponseDtos);
        return "/edms/ec_H/edms_2";
    }

    //지결 수신함 상세
    @GetMapping("/edms/edms_ac_detail_2/{expNum}")
    public String goDetail2(@PathVariable("expNum") String expNum, Model model){
        List<AcResponseDto> acResponseDto = acService.findByNum(expNum);
        model.addAttribute("acResponseDto", acResponseDto);
        return "/edms/ec_H/edms_ac_detail_2";
    }

    //수신함 승인/반려 반영
    @PostMapping("/edms/edms_2")
    public String updateAc(AcRequestDto acRequestDto) {
        System.out.println(acRequestDto);
        acService.updateList(acRequestDto);


        accService.insertAccInfo(acRequestDto.getExpNum());

        return "redirect:/edms/edms_2";
    }
}

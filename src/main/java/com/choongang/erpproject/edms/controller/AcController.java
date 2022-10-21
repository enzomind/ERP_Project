package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.service.AcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AcController {
    @Autowired
    private AcService acService;

    //상신함 리스트
    @GetMapping("/edms/edms_1")
    public String goEc(Model model){
        List<AcResponseDto> acResponseDtos = acService.findAll();
        model.addAttribute("acResponseDtos",acResponseDtos);
        return "/edms/edms_1";
    }

    //지결 상신함 상세
    @GetMapping("/edms/edms_ac_detail_1/{expNum}")
    public String goDetail(@PathVariable("expNum") String expNum, Model model){
        List<AcResponseDto> acResponseDto = acService.findByNum(expNum);
        model.addAttribute("acResponseDto", acResponseDto);
        return "/edms/edms_ac_detail_1";
    }

    //지결 입력폼 이동
    @GetMapping("/edms/edms_acform")
    public String goAcform(){
        return "/edms/edms_acform";
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
        return "redirect:/edms/edms_1";
    }


    //수신함 리스트
    @GetMapping("/edms/edms_2")
    public String goEc2(Model model){
        List<AcResponseDto> acResponseDtos = acService.findAll();
        model.addAttribute("acResponseDtos",acResponseDtos);
        return "/edms/edms_2";
    }

    //지결 수신함 상세
    @GetMapping("/edms/edms_ac_detail_2/{expNum}")
    public String goDetail2(@PathVariable("expNum") String expNum, Model model){
        List<AcResponseDto> acResponseDto = acService.findByNum(expNum);
        model.addAttribute("acResponseDto", acResponseDto);
        return "/edms/edms_ac_detail_2";
    }

    //수신함 승인/반려 반영
    @PostMapping("/edms/edms_2")
    public String updateAc(AcRequestDto acRequestDto) {
        System.out.println(acRequestDto);
        acService.updateList(acRequestDto);
        return "redirect:/edms/edms_2";
    }


//    @PostMapping("/edms/edms_1")
//    public String submitForm(AcRequestDto acRequestDto){
//        acService.save(acRequestDto);
//        return "redirect:/edms/edms_1";
//    }

}

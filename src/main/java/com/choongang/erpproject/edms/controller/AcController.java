package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.service.AcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AcController {
    @Autowired
    private AcService acService;

    //리스트
    @GetMapping("/edms/edms_1")
    public String goEc(Model model){
        List<AcResponseDto> acResponseDtos = acService.findAll();
        model.addAttribute("acResponseDtos",acResponseDtos);
        return "/edms/edms_1";
    }

    //지결 상세
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
    public String submitForm(AcRequestDto acRequestDto){
        acService.save(acRequestDto);
        return "redirect:/edms/edms_1";
    }

//    @PostMapping("/edms/edms_1")
//    public String submitForm(List<AcRequestDto> acList){
//        System.out.println(acList);
//        acService.saveList(acList);
//        return "redirect:/edms/edms_1";
//    }



//    @GetMapping("/teest")
//    public List<AcResponseDto> test(){
//        return acService.findAll();
//    }


}

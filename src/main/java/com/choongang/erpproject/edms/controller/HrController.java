package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HrController {
    @Autowired
    HrService hrService;

    //결제상신함 : 리스트 확인
   @GetMapping("/levwriteview")
    public String writelist(Model model) {
       List<HrResponseDto> levlist = hrService.getLevList();
       model.addAttribute("levlist", levlist);
       return "/ec_1";
   }

    @GetMapping("/levapprview")
    public String apprlist(Model model) {
        List<HrResponseDto> levlist = hrService.getLevList();
        model.addAttribute("levlist", levlist);
        return "/ec_2";
    }

   //결제수신함 : 작성글
   @GetMapping("/levreportuser/{levId}")
    public String hrform1(@PathVariable("levId") Long levId, Model model) {
       HrResponseDto levdetail = hrService.getLevDetail(levId);
       model.addAttribute("levdetail", levdetail);
       System.out.println(levdetail.getLevNum());
       return "/ec_hrdetail_1";
   }

    @GetMapping("/levreportappr/{levId}")
    public String hrform2(@PathVariable("levId") Long levId, Model model) {
        HrResponseDto levdetail = hrService.getLevDetail(levId);
        model.addAttribute("levdetail", levdetail);
        System.out.println(levdetail.getLevNum());
        return "/ec_hrdetail_2";
    }

   @GetMapping("/levwrite")
    public String writeform() throws Exception {
       return "/ec_hrform";
   }

   @RequestMapping("/levwriteinsert")
    public String levwriteinsert(@ModelAttribute("hrRequestDto") HrRequestDto hrRequestDto, Model model) {
       hrService.writeinsert(hrRequestDto);
       return "/ec_1";
   }





//    @RequestMapping("/levlistview")
//    ModelAndView levlist() {
//        ModelAndView mav = new ModelAndView("/ec_1");
//        List<HrResponseDto> levlist = hrService.getLevList();
//        mav.addObject("levlist", levlist);
//        return mav;
//    }
}

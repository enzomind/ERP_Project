package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class HrController {
    @Autowired
    HrService hrService;

    //결재상신함 : 리스트 확인
   @GetMapping("/levwrite")
    public String writelist(Model model) {
       List<HrResponseDto> levlist = hrService.getLevList();
       model.addAttribute("levlist", levlist);
       return "/edms/ec_Y/edms_1";
   }

    //결재수신함 : 리스트 확인
    @GetMapping("/levappr")
    public String apprlist(Model model) {
        List<HrResponseDto> levlist = hrService.getLevList();
        model.addAttribute("levlist", levlist);
        return "/edms/ec_Y/edms_2";
    }


    //결재상신함 : 작성글 확인
   @GetMapping("/userdetail/{levId}")
    public String hrform1(@PathVariable("levId") Long levId, Model model) {
       HrResponseDto numDetail = hrService.findByNum(levId);
       model.addAttribute("numDetail", numDetail);
       return "/edms/ec_Y/edms_hr_detail_1";
   }


    //결재수신함 : 작성글 확인
    @GetMapping("/apprdetail/{levId}")
    public String hrform2(@PathVariable("levId") Long levId, Model model) {
        HrResponseDto numDetail = hrService.findByNum(levId);
        model.addAttribute("numDetail", numDetail);
        return "/edms/ec_Y/edms_hr_detail_2";
    }


    //결재상신함 : 글 작성페이지
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/levinsert")
    public String writeform(Model model, Model model2, Principal principal) {
       List<HrResponseDto> hrList = hrService.findHr();
       model.addAttribute("hrList", hrList);
       String id = principal.getName();
       model2.addAttribute("empInfo", hrService.findWriter(id));
       return "/edms/ec_Y/edms_hrform";
   }

   //작성글 insert
    @PostMapping("/levwriteinsert")
    public String levwriteinsert(HrRequestDto hrRequestDto) {
        System.out.println(hrRequestDto.getAppr());
       hrService.writeSave(hrRequestDto);
       return "redirect:/levwrite";
    }

    //결재수신함 상태 update
    @PostMapping("/levstate")
    public String levstate( HrRequestDto hrRequestDto) {
        System.out.println(hrRequestDto);
       hrService.stateSave(hrRequestDto);
       return "redirect:/levappr";
    }

//   @RequestMapping("/levwriteinsert")
//    public String levwriteinsert(@ModelAttribute("hrRequestDto") HrRequestDto hrRequestDto, Model model) {
//       System.out.println("--------------------------------"+hrRequestDto);
//       hrService.writeinsert(hrRequestDto);
//       return "/ec_1";
//   }

//    @RequestMapping("/levlistview")
//    ModelAndView levlist() {
//        ModelAndView mav = new ModelAndView("/ec_1");
//        List<HrResponseDto> levlist = hrService.getLevList();
//        mav.addObject("levlist", levlist);
//        return mav;
//    }
}

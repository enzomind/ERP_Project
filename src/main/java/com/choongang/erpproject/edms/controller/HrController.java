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

    //결재상신함 : 리스트 확인
   @GetMapping("/levwriteview")
    public String writelist(Model model) {
       List<HrResponseDto> levlist = hrService.getLevList();
       model.addAttribute("levlist", levlist);
       return "/edms/ec_yejin/edms_1";
   }

    //결재수신함 : 리스트 확인
    @GetMapping("/levapprview")
    public String apprlist(Model model) {
        List<HrResponseDto> levlist = hrService.getLevList();
        model.addAttribute("levlist", levlist);
        return "/edms/ec_yejin/edms_2";
    }

   //결재상신함 : 작성글 확인
   @GetMapping("/levreportuser/{levId}")
    public String hrform1(@PathVariable("levId") Long levId, Model model) {
       HrResponseDto levdetail1 = hrService.getLevDetail(levId);
       model.addAttribute("levdetail1", levdetail1);
       System.out.println(levdetail1.getLevNum());
       return "/edms/ec_yejin/edms_hr_detail_1";
   }

    //결재수신함 : 작성글 확인
    @GetMapping("/levreportappr/{levId}")
    public String hrform2(@PathVariable("levId") Long levId, Model model) {
        HrResponseDto levdetail2 = hrService.getLevDetail(levId);
        model.addAttribute("levdetail2", levdetail2);
        System.out.println(levdetail2.getLevNum());
        return "/edms/ec_yejin/edms_hr_detail_2";
    }


    //결재상신함 : 글 작성페이지
   @GetMapping("/levwrite")
    public String writeform() throws Exception {
       return "/edms/ec_yejin/edms_hrform";
   }

   //작성글 insert
    @PostMapping("/levwriteinsert")
    public String levwriteinsert(HrRequestDto hrRequestDto) {
       hrService.writeSave(hrRequestDto);
       return "redirect:/levwriteview";
    }

    //결재수신함 상태 insert
    @PostMapping("/levstateinsert")
    public String levstateinsert(HrRequestDto hrRequestDto) {
       hrService.stateSave(hrRequestDto);
       return "redirect:/levapprview";
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

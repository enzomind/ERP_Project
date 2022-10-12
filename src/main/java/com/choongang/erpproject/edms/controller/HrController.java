package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HrController {
    @Autowired
    HrService hrService;

   @GetMapping("/levlistview")
    public String list(Model model) {
       List<HrResponseDto> levlist = hrService.getLevList();
       model.addAttribute("levlist", levlist);
       return "/ec_1";
   }


   @GetMapping("/levreport/{levId}")
    public String hrform2(@PathVariable("levId") Long levId, Model model) {
       HrResponseDto levdetail = hrService.getLevDetail(levId);
       model.addAttribute("levdetail", levdetail);
       System.out.println(levdetail.getLevNum());
       return "/ec_hrform_2";
   }




//    @RequestMapping("/levlistview")
//    ModelAndView levlist() {
//        ModelAndView mav = new ModelAndView("/ec_1");
//        List<HrResponseDto> levlist = hrService.getLevList();
//        mav.addObject("levlist", levlist);
//        return mav;
//    }
}

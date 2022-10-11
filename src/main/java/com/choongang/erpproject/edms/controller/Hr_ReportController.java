package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.Hr_ReportDto;
import com.choongang.erpproject.edms.service.Hr_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/edms")
public class Hr_ReportController {

    private final Hr_Service hr_service;

    @GetMapping("/ec")
    public String ec_hr() {
        return "/templates/edms/ec_1";
    }

    @GetMapping("/ec/hrform")
    public String ec_hrform(Model model) {
        model.addAttribute("cnt", hr_service.levCount());
        model.addAttribute("hrform", hr_service.levList());

        return "/templates/edms/ec_1/ec_hrform";
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("ec", hr_service.levList());
        return "/templates/edms/ec_1";
    }

}

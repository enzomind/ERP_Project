package com.choongang.erpproject.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class accPageCont {

    @GetMapping("/acc/accounting")
    public String accountPageRoot(){

        return "/acc/accounting";
    }

    @GetMapping("/acc/acc/accounting")
    public String accountPageSub(){

        return "redirect:/acc/accounting";
    }

    @GetMapping("/employee/acc/accounting")
    public String prepixAccountRoot(){

        return "redirect:/acc/accounting";
    }

}

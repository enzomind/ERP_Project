package com.choongang.erpproject.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acc/*")
public class accPageCont {

    @GetMapping("/accounting")
    public String accountPageRoot(){

        return "acc/accounting";
    }

}

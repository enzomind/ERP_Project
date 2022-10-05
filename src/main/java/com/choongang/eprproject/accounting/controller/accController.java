package com.choongang.eprproject.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class accController {

    @GetMapping("/acc/accounting")
    public String accountRoot(){

        return "acc/accounting";
    }


}

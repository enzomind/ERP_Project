package com.choongang.erpproject.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MpPageCont {

    @GetMapping("/mypage")
    public String mpRoot(){

        return "/mypage/mp";

    }

}

package com.choongang.erpproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testcont {
    @GetMapping("/test")
    public String testgo() {
        return "/layoutex";
    }
}

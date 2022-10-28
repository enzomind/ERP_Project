package com.choongang.erpproject.edms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubMainController {

    @GetMapping("/edms")
    public String edmsRoot() {
        return "/edms/edmsSubMain";
    }

}

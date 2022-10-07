package com.choongang.erpproject.accounting.controller;

import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.service.AccService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accapi/*")
public class accApiCont {

    private final AccService accService;

    @GetMapping("/accounting")
    public List<AccResponseDto> accountApiRoot() {

        List<AccResponseDto> acclist = accService.getAccList();

        return acclist;

    }

}

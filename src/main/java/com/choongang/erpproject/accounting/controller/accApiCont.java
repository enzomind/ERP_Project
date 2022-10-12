package com.choongang.erpproject.accounting.controller;

import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.service.AccService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class accApiCont {

    private final AccService accService;

    @GetMapping("/accapi/accounting/")
    public List<AccResponseDto> accountApiRoot() {

        List<AccResponseDto> acclist = accService.getAccList();
        return acclist;
    }

    @GetMapping("/acc/accapi/accounting/{statNum}")
    public List<AccResponseDto> findDetail(@PathVariable final Long statNum) {

        List<AccResponseDto>accDetailList = accService.getAccDetail(statNum);

        return accDetailList;
    }


}

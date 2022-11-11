package com.choongang.erpproject.accounting.controller;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.service.AccService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class accApiCont {

    private final AccService accService;

    @GetMapping("/accapi/accounting/{startDate}/{endDate}")
    public List<AccResponseDto> accountApiRoot(@PathVariable final String startDate, @PathVariable final String endDate) {

        LocalDate sTime = LocalDate.parse(startDate);
        LocalDate eTime = LocalDate.parse(endDate);

        AccRequestDto params = new AccRequestDto();
        params.setStartDate(sTime);
        params.setEndDate(eTime);
        List<AccResponseDto> accList = accService.getAccList(params);
        return accList;
    }

    @GetMapping("/acc/accapi/accounting/{statNum}")
    public List<AccResponseDto> findDetail(@PathVariable final Long statNum) {

        List<AccResponseDto>accDetailList = accService.getAccDetail(statNum);
        return accDetailList;
    }

    @GetMapping("/accapi/accounting/getpaytotal/{startDate}/{endDate}")
    public List<AccResponseDto> getPayTotal (@PathVariable final String startDate, @PathVariable final String endDate) {

        LocalDate sTime = LocalDate.parse(startDate);
        LocalDate eTime = LocalDate.parse(endDate);

        AccRequestDto params = new AccRequestDto();
        params.setStartDate(sTime);
        params.setEndDate(eTime);

        List<AccResponseDto> payList = accService.getPayInfo(params);
        return payList;
    }

}

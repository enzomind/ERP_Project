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

    //회계전표 리스트 컨트롤러
    @GetMapping("/accapi/accounting/{startDate}/{endDate}")
    public List<AccResponseDto> accountApiRoot(@PathVariable final String startDate, @PathVariable final String endDate) {

        //AccRequestDto 객체 생성 후, 파라미터값 매핑
        AccRequestDto params = new AccRequestDto();
        params.setStartDate(LocalDate.parse(startDate));
        params.setEndDate(LocalDate.parse(endDate));

        return accService.getAccList(params);
    }

    //회계전표 상세 리스트 컨트롤러
    @GetMapping("/acc/accapi/accounting/{statNum}")
    public List<AccResponseDto> findDetail(@PathVariable final Long statNum) {
        return accService.getAccDetail(statNum);
    }

    //급여 이체내역 컨트롤러
    @GetMapping("/accapi/accounting/getpaytotal/{startDate}/{endDate}")
    public List<AccResponseDto> getPayTotal (@PathVariable final String startDate, @PathVariable final String endDate) {

        AccRequestDto params = new AccRequestDto();
        params.setStartDate(LocalDate.parse(startDate));
        params.setEndDate(LocalDate.parse(endDate));

        return accService.getPayInfo(params);

    }

}

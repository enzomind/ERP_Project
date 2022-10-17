package com.choongang.erpproject.account;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.service.AccService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AccServiceTest {

    @Autowired
    AccService accService;

    @Test
    public void getListTest(){
        AccRequestDto params = new AccRequestDto();

        params.setStartDate(LocalDate.of(2022,10,07));
        params.setEndDate(LocalDate.of(2022,10,10));

        System.out.println(params.getStartDate());
        System.out.println(params.getEndDate());

        List<AccResponseDto> list = accService.getAccList(params);
        if(CollectionUtils.isEmpty(list)==false) {
            for(AccResponseDto accResponseDto : list) {
                System.out.println("=====================");
                System.out.println(accResponseDto.getStatNum());
                System.out.println(accResponseDto.getComAcc());
                System.out.println(accResponseDto.getStatDate());
                System.out.println(accResponseDto.getExpense());
                System.out.println(accResponseDto.getIncome());
                System.out.println("=====================");
            }
        }
    }

    @Test
    public void getDetailListTest() {

        List<AccResponseDto> detailList = accService.getAccDetail(1L);
        if(CollectionUtils.isEmpty(detailList)==false) {
            for(AccResponseDto accResponseDto : detailList) {
                System.out.println("=====================");
                System.out.println(accResponseDto.getEmpName());
                System.out.println(accResponseDto.getAppr());
                System.out.println(accResponseDto.getApprDate());
                System.out.println(accResponseDto.getComAcc());
                System.out.println(accResponseDto.getExpense());
                System.out.println("=====================");
            }
        }
    }
}

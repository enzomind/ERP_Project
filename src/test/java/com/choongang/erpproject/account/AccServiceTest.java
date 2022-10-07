package com.choongang.erpproject.account;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.mapper.AccMapper;
import com.choongang.erpproject.accounting.service.AccService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class AccServiceTest {

    @Autowired
    AccService accService;

    @Test
    public void getListTest(){
        List<AccResponseDto> list = accService.getAccList();
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
}

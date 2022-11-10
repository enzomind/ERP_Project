package com.choongang.erpproject.account;

import com.choongang.erpproject.accounting.dto.AccRequestDto;
import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.accounting.mapper.AccMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import java.util.List;

@SpringBootTest
public class AccMapperTest {

    @Autowired
    AccMapper accMapper;

    @Test
    void InsertTest() {
        AccRequestDto accRequestDto = new AccRequestDto();

        accRequestDto.setStatNum(7L);
        accRequestDto.setStatDate(LocalDate.now());
        accRequestDto.setExpNum("SJCD-0006");
        accRequestDto.setEmpId("SJ-0014");
        accRequestDto.setStartDate(LocalDate.now());
        accRequestDto.setEndDate(LocalDate.now());

//        accMapper.insertAccInfo(accRequestDto);

        List<AccResponseDto> data = accMapper.getAccList(accRequestDto);
        System.out.println("전체 개시글 수 : " + data.size() + "건");
    }

    @Test
    void getDetailList() {
        Long statNum = 1L;
        List<AccResponseDto> data = accMapper.getAccDetail(statNum);
        System.out.println("상세 건 수 : " + data.size() + "건");

    }

}

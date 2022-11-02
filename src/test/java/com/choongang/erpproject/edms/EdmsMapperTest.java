package com.choongang.erpproject.edms;

import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.edms.dto.EdmsRequestDto;
import com.choongang.erpproject.edms.dto.EdmsResponseDto;
import com.choongang.erpproject.edms.mapper.EdmsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EdmsMapperTest {

    @Autowired
    EdmsMapper edmsMapper;

    @Test
    void getList() {

        EdmsRequestDto dto = new EdmsRequestDto();

        dto.setApprId("SJ-0181");

        List<EdmsResponseDto> list = edmsMapper.findAll(dto);
        System.out.println("건 수 : " + list.size() + "건");

    }
}


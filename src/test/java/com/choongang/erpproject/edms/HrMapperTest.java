package com.choongang.erpproject.edms;

import com.choongang.erpproject.edms.mapper.HrMapper;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HrMapperTest {

    @Autowired
    HrMapper hrmapper;

    @Test
    void getLevListTest() {
        List<HrResponseDto> levList = hrmapper.getLevList();
        System.out.println("총 몇건?" + levList.size());
    }
}

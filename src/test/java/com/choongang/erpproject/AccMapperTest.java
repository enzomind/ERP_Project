package com.choongang.erpproject;

import com.choongang.erpproject.accounting.dao.AccMapper;
import com.choongang.erpproject.accounting.dto.AccDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AccMapperTest {

    @Autowired
    private AccMapper accMapper;

    @Test
    public void accInsertTest() {
        AccDto accDto = new AccDto();

        accDto.setStat_num(3);
        accDto.setStat_date(LocalDateTime.now());
        accDto.setExp_num("SJCD-0187");
        accDto.setEmp_id("SJ-0074");

        int result = accMapper.insertAcc(accDto);
    }



}

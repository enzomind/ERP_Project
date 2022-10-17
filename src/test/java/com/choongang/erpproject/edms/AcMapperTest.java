package com.choongang.erpproject.edms;

import com.choongang.erpproject.edms.dto.AcRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.mapper.AcMapper;
import com.choongang.erpproject.edms.mapper.HrMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

@SpringBootTest
public class AcMapperTest {

    @Autowired
    AcMapper acMapper;
    @Test
    void listInsertTest(){



        List<AcRequestDto> list = new ArrayList<AcRequestDto>();




            AcRequestDto acRequestDto = new AcRequestDto();
            acRequestDto.setExpTitle("3번쨰");
            acRequestDto.setDetCode("복리후생비");
            acRequestDto.setRemk("처쨰 적요");
            acRequestDto.setComAcc("111111");
            acRequestDto.setExpense(10000);
            acRequestDto.setExpNum("SJCD-0055");
            acRequestDto.setAppr("홍길동");
            acRequestDto.setApplDate(now());
            acRequestDto.setMajCode("회계");
            list.add(acRequestDto);

            //exp_title,det_code, remk, com_acc,expense,exp_num,appr,appl_date,maj_code

        AcRequestDto acRequestDto1 = new AcRequestDto();
            acRequestDto1.setExpTitle("4번쨰");
            acRequestDto1.setDetCode("복리후생비");
            acRequestDto1.setRemk("두쨰 적요");
            acRequestDto1.setComAcc("111111");
            acRequestDto1.setExpense(10000);
            acRequestDto1.setExpNum("SJCD-0056");
            acRequestDto1.setAppr("홍길동");
            acRequestDto1.setApplDate(now());
            acRequestDto1.setMajCode("회계");
        list.add(acRequestDto1);


            acMapper.insertList(list);



    }
}

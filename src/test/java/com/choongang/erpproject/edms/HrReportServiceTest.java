package com.choongang.erpproject.edms;

import com.choongang.erpproject.edms.mapper.Hr_Mapper;
import com.choongang.erpproject.edms.dto.Hr_ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HrReportServiceTest {

    @Autowired
    Hr_Mapper hr_mapper;

//    @Test
//    void InsertTest() {
//        Hr_RequestDto hr_requestDto = new Hr_RequestDto();
//
//        hr_requestDto.setLevId(5L);
//        hr_requestDto.setLevNum("SJ-0074");
//        hr_requestDto.setLevTitle("오후반차 신청");
//        hr_requestDto.setApplDate(LocalDate.now());
//
//        hr_mapper.insertHrReport(hr_requestDto);
//
//        List<Hr_ResponseDto> data = hr_mapper.getLevList();
//        System.out.println("전체 게시글 수: " + data.size() + "건");
//    }
//
//    @Test
//    public void getListTest(){
//        List<Hr_ResponseDto> list = hr_service.getLevList();
//        if(CollectionUtils.isEmpty(list)==false) {
//            for(Hr_ResponseDto hr_responseDto : list) {
//                System.out.println("=====================");
//                System.out.println(hr_responseDto.getLevId());
//                System.out.println(hr_responseDto.getLevNum());
//                System.out.println(hr_responseDto.getLevTitle());
//                System.out.println(hr_responseDto.getApplDate());
//                System.out.println("=====================");
//            }
//        }
//    }

    @Test
    void selectLevTest() {
        List<Hr_ResponseDto> levList = hr_mapper.getLevList();
        System.out.println("총 몇건?" + levList.size());
    }
}

package com.choongang.erpproject.edms;

import com.choongang.erpproject.accounting.dto.AccResponseDto;
import com.choongang.erpproject.edms.mapper.HrMapper;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.service.HrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class HrMapperTest {
//
//    @Autowired
//    HrMapper hrmapper;
//
//    @Autowired
//    HrService hrService;
//
//    @Test
//    void getLevCountTest() {
//        List<HrResponseDto> levList = hrmapper.getLevList();
//        System.out.println("총 몇건?" + levList.size());
//    }
//
//    @Test
//    public void getLevListTest() {
//        List<HrResponseDto> list = hrmapper.getLevList();
//        if (CollectionUtils.isEmpty(list)==false) {
//            for(HrResponseDto hrResponseDto : list) {
//                System.out.println("=====================");
//                System.out.println(hrResponseDto.getLevId());
//                System.out.println(hrResponseDto.getLevNum());
//                System.out.println(hrResponseDto.getLevTitle());
//                System.out.println(hrResponseDto.getApplDate());
//                System.out.println(hrResponseDto.getApprState());
//                System.out.println("=====================");
//            }
//        }
//    }
//
//    @Test
//    void getDetailList() {
//        Long levId = 1L;
//        HrResponseDto data = hrmapper.selectDetail(levId);
//        System.out.println("상세 건 수 : " + data + "건");
//    }
//
//    @Test
//    public void getLevDetailTest() {
//        HrResponseDto detail = hrmapper.selectDetail(1L);
//                System.out.println("=====================");
//                System.out.println(detail.getLevNum());
//                System.out.println(detail.getEmpId());
//                System.out.println(detail.getAppr());
//                System.out.println(detail.getLevTitle());
//                System.out.println(detail.getApplDate());
//                System.out.println(detail.getLevType());
//                System.out.println(detail.getLevContent());
//                System.out.println(detail.getApprState());
//                System.out.println("=====================");
//
//        }
    }


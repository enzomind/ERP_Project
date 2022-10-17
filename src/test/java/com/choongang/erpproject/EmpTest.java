//package com.choongang.erpproject;
//
//
//import com.choongang.erpproject.employee.dao.PromotionMapper;
//import com.choongang.erpproject.employee.dto.PromotionDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class EmpTest {
//
//    @Autowired
//    PromotionMapper promotionMapper;
//
//    @Test
//    void SelectTest() {
//        PromotionDto promotionDto = PromotionDto.builder()
//                .start("2012-08-22")
//                .end("2022-08-22")
//                .hqName("HR본부")
//                .jobName("사원")
//
//                .build();
//
//        System.out.println("결과 : "+ promotionMapper.searchEmp(promotionDto));
//    }
//}

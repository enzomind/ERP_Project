package com.choongang.erpproject.employee.controller;


import com.choongang.erpproject.employee.dao.PromotionMapper;
import com.choongang.erpproject.employee.dto.PaymentDto;
import com.choongang.erpproject.employee.dto.PromotionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/emp/*")
public class PromoController {
    @Autowired
    PromotionMapper promotionMapper;
//
//    @RequestMapping("/promo")
//    private List<PromotionDto> promotionList() {
//        List<PromotionDto> promotionList = promotionMapper.selectProAll1();
//
//        return promotionList;
//
//    }

//    list로 리턴해서 받는 방법 dto 필요(유지보수 요함)

    @RequestMapping("/promo")
    public List<HashMap<String, Object>> promoList() {
        List<HashMap<String, Object>> list = promotionMapper.selectProAll();
        return list;
    }

    @RequestMapping("/searchemp")
    private List<PromotionDto> searchList(PromotionDto promotionDto) {
        List<PromotionDto> promotionList = promotionMapper.searchEmp(promotionDto);
        return promotionList;
    }

    @RequestMapping("/paydata")
    private List<PaymentDto> payData(@RequestParam String empId) {
        List<PaymentDto> paymentList = promotionMapper.serachPayDetail(empId);
        return paymentList;
    }

    @RequestMapping("/payhistroy")
    private List<PaymentDto> payHistory(@RequestParam String PayMonth,@RequestParam String PayYear, @RequestParam String emNum) {
        List<PaymentDto> paymentHistory = promotionMapper.serachPayHistory(PayMonth, PayYear, emNum);
        return paymentHistory;
    }


    @RequestMapping("/searchWhoPro")
    public List<HashMap<String, Object>> promoDetails(@RequestParam String empId) {
        List<HashMap<String, Object>> list = promotionMapper.searchPromotionDetail(empId);
        return list;
    }

    @RequestMapping("/confirmPromotion")
    List<HashMap<String, Object>> ConfirmPromo(@RequestParam String empId, @RequestParam String jobCode, @RequestParam int salary) {
        promotionMapper.ConfirmPromotion(empId, jobCode, salary);
        List<HashMap<String, Object>> ChangedList = promotionMapper.searchPromotionDetail(empId);
        return ChangedList;
    }

    @RequestMapping("/payAllAndSelectLatestPayday")
    List<PaymentDto> ConfirmPromo() {
        promotionMapper.payAll();
        List<PaymentDto> paydate = promotionMapper.findLatestPaymdate();
        return paydate;
    }

}

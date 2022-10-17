package com.choongang.erpproject.employee.controller;

import com.choongang.erpproject.employee.dao.PromotionMapper;
import com.choongang.erpproject.employee.dto.PaymentDto;
import com.choongang.erpproject.employee.dto.PromotionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee/*")
public class PageController {
    @Autowired
    PromotionMapper promotionMapper;

    @RequestMapping("/promo2")
    private String promotionList() {
//        model.addAttribute("promo", promotionMapper.selectProAll1());
        return "/employee/employee_1";
    }

    @GetMapping("/promo")
    private String promotionList2(Model model) {
        List<PromotionDto> list = promotionMapper.selectProAll1();
        List<PaymentDto> lastPayday = promotionMapper.findLatestPaymdate();
        model.addAttribute("promo", list);
        model.addAttribute("lastPayday", lastPayday);
        return "/employee/employee_2";
    }



//    @RequestMapping("/promo")
//    public @ResponseBody HashMap<String, Object> promoList() {
//        HashMap<String, Object> result = promotionMapper.selectProAll();
//        return result;
//    }
}

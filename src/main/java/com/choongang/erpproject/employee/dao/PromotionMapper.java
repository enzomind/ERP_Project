package com.choongang.erpproject.employee.dao;

import com.choongang.erpproject.employee.dto.PaymentDto;
import com.choongang.erpproject.employee.dto.PaymentDto;
import com.choongang.erpproject.employee.dto.PromotionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PromotionMapper {
    @Select("SELECT emp_id, emp_name, birth, hq_name, dep_name, job_name, auth_name FROM promotiondetail")
    List<PromotionDto> selectProAll1();
    //    list로 리턴해서 받는 방법 dto 필요(유지보수 요함)

    List<PromotionDto> searchEmp(PromotionDto promotionDto);

    List<PaymentDto> serachPayDetail(String empId);


    List<PaymentDto> serachPayHistory(String PayMonth, String PayYear, String emNum);

    void payAll();

    List<PaymentDto> findLatestPaymdate();

    @Select("SELECT count(*) FROM emp_table")
    int CountEmpNum();

    @Select("SELECT * FROM promotiondetail")
    List<HashMap<String, Object>> selectProAll();

    List<HashMap<String, Object>> searchPromotionDetail(String empId);

    void ConfirmPromotion(String empId, String jobCode, int salary);
}

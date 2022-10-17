package com.choongang.erpproject.employee.dao;

import com.choongang.erpproject.employee.dto.PromotionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface employeeDao {
    List<employeeDao> selectAll();


}

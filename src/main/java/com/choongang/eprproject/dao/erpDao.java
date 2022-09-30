package com.choongang.eprproject.dao;

import com.choongang.eprproject.test.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface erpDao {

    List<TestDto> selectAll();
}

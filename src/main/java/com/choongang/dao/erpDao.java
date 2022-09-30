package com.choongang.dao;

import com.choongang.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface erpDao {

    List<TestDto> selectAll();
}

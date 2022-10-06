package com.choongang.eprproject.accounting.dao;

import com.choongang.eprproject.accounting.dto.accDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface accMapper {

    public List<accDto> selectAccList();
    public List<accDto> selectAccDetail(Long stat_num);
    public int getExp_num(Long stat_num);

}

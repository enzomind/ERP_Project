package com.choongang.erpproject.accounting.dao;

import com.choongang.erpproject.accounting.dto.AccDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccMapper {

    public List<AccDto> selectAccList();
    public List<AccDto> selectAccDetail(Long stat_num);
    public int getExp_num(Long stat_num);

}

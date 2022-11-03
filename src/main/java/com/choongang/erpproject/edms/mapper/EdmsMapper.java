package com.choongang.erpproject.edms.mapper;

import com.choongang.erpproject.edms.dto.EdmsRequestDto;
import com.choongang.erpproject.edms.dto.EdmsResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EdmsMapper {

    List<EdmsResponseDto> findAll(EdmsRequestDto params);

}

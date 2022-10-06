package com.choongang.erpproject.login.repository;

import org.apache.ibatis.annotations.Mapper;
import com.choongang.erpproject.login.dto.UserDto;

import java.util.Optional;

@Mapper
public interface UserMapper{
//        Optional<UserDto> findUserByUsername(String username);
        Optional<UserDto> findById(String emp_id);
        void save(UserDto userDto);
}

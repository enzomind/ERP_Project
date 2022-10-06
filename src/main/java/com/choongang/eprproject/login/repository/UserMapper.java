package com.choongang.eprproject.login.repository;

import org.apache.ibatis.annotations.Mapper;
import com.choongang.eprproject.login.dto.UserDto;

import java.util.Optional;

@Mapper
public interface UserMapper{
//        Optional<UserDto> findUserByUsername(String username);
        Optional<UserDto> findById(String emp_id);
        void save(UserDto userDto);
}

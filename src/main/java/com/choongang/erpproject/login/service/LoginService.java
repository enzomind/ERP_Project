package com.choongang.erpproject.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.choongang.erpproject.login.exception.DuplicatedUsernameException;
import com.choongang.erpproject.login.configure.JwtTokenProvider;
import com.choongang.erpproject.login.exception.LoginFailedException;
import com.choongang.erpproject.login.exception.UserNotFoundException;
import com.choongang.erpproject.login.dto.LoginDto;
import com.choongang.erpproject.login.dto.UserDto;
import com.choongang.erpproject.login.repository.UserMapper;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class LoginService {

    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto join(UserDto userDto){
        if(userMapper.findById(userDto.getUsername()).isPresent()){
            throw new DuplicatedUsernameException("이미 가입된 유저입니다.");
        }

        userDto.setPw(passwordEncoder.encode(userDto.getPassword()));
        userMapper.save(userDto);

        return userMapper.findById(userDto.getUsername()).get();
    }

    public String login(LoginDto loginDto){
        UserDto userDto = userMapper.findById(loginDto.getEmpId())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디입니다."));

        if(!passwordEncoder.matches(loginDto.getPw(), userDto.getPassword())){
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        return jwtTokenProvider.createToken(userDto.getEmpId(), Collections.singletonList(userDto.getAuthCode()));

    }

    public UserDto findById(String empId){
        return userMapper.findById(empId)
                .orElseThrow(() -> new UserNotFoundException("없는 유저입니다."));
    }

    public UserDto findByEmpName(String empId){
        return userMapper.findByEmpName(empId);
    }
}

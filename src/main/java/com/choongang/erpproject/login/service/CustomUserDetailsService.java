package com.choongang.erpproject.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.choongang.erpproject.login.exception.UserNotFoundException;
import com.choongang.erpproject.login.dto.UserDto;
import com.choongang.erpproject.login.repository.UserMapper;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
        return userMapper.findById(empId)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(empId + ">찾을 수 없습니다."));
    }

    private UserDto addAuthorities(UserDto userDto){
        userDto.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDto.getAuthCode())));

        return userDto;
    }
}

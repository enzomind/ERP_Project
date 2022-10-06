package com.choongang.eprproject.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.choongang.eprproject.login.exception.UserNotFoundException;
import com.choongang.eprproject.login.dto.UserDto;
import com.choongang.eprproject.login.repository.UserMapper;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String emp_id) throws UsernameNotFoundException {
        return userMapper.findById(emp_id)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(emp_id + ">찾을 수 없습니다."));
    }

    private UserDto addAuthorities(UserDto userDto){
        userDto.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDto.getAuth_code())));

        return userDto;
    }
}

package com.choongang.erpproject.login.service;

import com.choongang.erpproject.login.dto.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.choongang.erpproject.login.dto.UserDto;
import com.choongang.erpproject.login.repository.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String emp_id) throws UsernameNotFoundException {
        Optional<UserDto> userInfoWrapper = userMapper.findById(emp_id);
        UserDto userInfo = userInfoWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();


        if (("SJAU_0001").equals(userInfo.getAuth_code())) {
            authorities.add(new SimpleGrantedAuthority(Role.EMP.getValue()));
        } else if (("SJAU_0002").equals(userInfo.getAuth_code())) {
            authorities.add(new SimpleGrantedAuthority(Role.REP.getValue()));
        } else if (("SJAU_0003").equals(userInfo.getAuth_code())) {
            authorities.add(new SimpleGrantedAuthority(Role.ACC.getValue()));
        } else if (("SJAU_0004").equals(userInfo.getAuth_code())) {
            authorities.add(new SimpleGrantedAuthority(Role.EM.getValue()));
        } else if (("SJAU_0005").equals(userInfo.getAuth_code())) {
            authorities.add(new SimpleGrantedAuthority(Role.ADM.getValue()));
        }

        return new User(userInfo.getUsername(), userInfo.getPassword(), authorities);
    }
}



//    @Override
//    public UserDetails loadUserByUsername(String emp_id) throws UsernameNotFoundException {
//
//        return userMapper.findById(emp_id)
//                .map(user -> addAuthorities(user))
//                .orElseThrow(() -> new UserNotFoundException(emp_id + ">찾을 수 없습니다."));
//    }
//
//    private UserDto addAuthorities(UserDto userDto){
//        userDto.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDto.getAuth_code())));
//
//        return userDto;
//    }
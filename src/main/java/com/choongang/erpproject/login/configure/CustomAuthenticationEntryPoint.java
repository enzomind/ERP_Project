package com.choongang.erpproject.login.configure;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//인증이 실패했을 때 처리하기 위한 클래스
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException, NoSuchElementException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
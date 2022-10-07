package com.choongang.erpproject.login.configure;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    private final JwtTokenProvider jwtTokenProvider;

    public static final String AUTHORIZATION_HEADER = "Authorization";

    //filter를 통해 JWT토큰이 유효한지 검증
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if(cookies==null){
            chain.doFilter(request, response);
            return;
        }

        String token =  null;
        if(Arrays.stream(cookies).filter(c -> c.getName().equals("token")).findAny().isPresent()){
            token =  Arrays.stream(cookies).filter(c -> c.getName().equals("token")).findAny().get().getValue();
        }

        token = jwtTokenProvider.resolveToken(token);

        String requestURI = ((HttpServletRequest) request).getRequestURI();

        if (token != null && jwtTokenProvider.validateToken(token,(HttpServletResponse) response)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Security context에 인증 정보를 저장했습니다. uri: {}", requestURI);
        } else {
            logger.debug("유효한 Jwt 토큰이 없습니다, uti: {}", requestURI);
        }

        chain.doFilter(request, response);
    }

    //Http Request 헤더에서 토큰만 추출
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}


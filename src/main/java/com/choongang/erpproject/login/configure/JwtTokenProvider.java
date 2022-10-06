package com.choongang.erpproject.login.configure;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private String secretKey = "test";
    private long tokenValidMillisecond = 1000l * 60 * 60;

    private final UserDetailsService userDetailsService;
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //jwt 토큰 생성
    public String createToken(String empId, List<String> roles){
        Claims claims = Jwts.claims().setSubject(empId);
        claims.put("roles", roles);
        Date now = new Date();
        
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    
    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(token));
    
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    public String getUserId(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String resolveToken(String token){

        if (StringUtils.hasText(token) && token.startsWith("Bearer+")) {
            return token.substring(7);
        }

        return null;
    }

    public boolean validateToken(String token, HttpServletResponse response){
        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch(SecurityException | MalformedJwtException | IllegalArgumentException exception){
            logger.info("잘못된 Jwt 토큰입니다.");
        } catch(ExpiredJwtException exception){

            Cookie myCookie = new Cookie("token", null);
            myCookie.setMaxAge(0); // 쿠키의 expiration 타임을 0으로 하여 없앤다.
            myCookie.setPath("/"); // 모든 경로에서 삭제 됬음을 알린다.
            response.addCookie(myCookie);

            logger.info("만료된 Jwt 토큰입니다.");

            return true;

        } catch(UnsupportedJwtException exception){
            logger.info("지원하지 않는 Jwt 토큰입니다.");
        }

        return false;
    }

}

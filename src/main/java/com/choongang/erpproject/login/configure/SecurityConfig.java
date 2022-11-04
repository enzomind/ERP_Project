package com.choongang.erpproject.login.configure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                //prefix = ROLE- *hasRole에서 Authority로 변경
                //0001 : 직원
                //0002 : 임원
                //0003 : 회계 담당자
                //0004 : 인사 담당자
                //0005 : MASTER

                //인사 관리 - 직원 조회 메뉴는 임원(2), 인사 담당자(4), Master(5)만 접근 허용
                .antMatchers("/employee/**").hasAnyAuthority("SJAU_0002", "SJAU_0004","SJAU_0005")
//                //인사 관리 - 급여(승진) 관리 메뉴는 인사 담당자(4), Master(5)만 접근 허용
//                .antMatchers("/employee/promo").hasAnyAuthority("SJAU_0002", "SJAU_0004","SJAU_0005")
                //회계 전표 메뉴는 회계 담당자(3), Master(5)만 접근 허용
                .antMatchers("/acc/**").hasAnyAuthority("SJAU_0003","SJAU_0005")
                //결재상신함, 수신함, 공지사항은 인증 정보가 있다면 모두 접근 허용
                .antMatchers("/edms/**", "/board/**", "/mypage").authenticated()

                .antMatchers("/join", "/api/login", "/api/join", "/error/*", "/css/**", "/**", "/js/**", "/etc/**", "/users", "lib").permitAll()

                .and()
                .logout()
                .logoutUrl("/dologout")
                .logoutSuccessUrl("/")
                .deleteCookies("token")

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .failureHandler(loginFailHandler())
                //추후에 핸들러 부분 수정

                .and()
                .exceptionHandling().accessDeniedHandler(new com.choongang.erpproject.login.configure.CustomAccessDeniedHandler())
                .and()
                .exceptionHandling().authenticationEntryPoint(new com.choongang.erpproject.login.configure.CustomAuthenticationEntryPoint())

                .and()
                .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web
                .ignoring()
                .antMatchers("/v2/api-docs","/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger/**");
    }

    @Bean
    public LoginFailHandler loginFailHandler() {
        return new LoginFailHandler();
    }


}

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
import com.choongang.erpproject.login.configure.JwtFilter;
import com.choongang.erpproject.login.configure.JwtTokenProvider;

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

                //인사 관리 메뉴는 인사 담당자만 접근 허용
                .antMatchers("/employee/**").hasAuthority("SJAU_0004")
                //회계 전표 메뉴는 회계 담당자만 접근 허용
                .antMatchers("/acc/**").hasAuthority("SJAU_0003")
                //결재상신함, 수신함, 공지사항은 인증 정보가 있다면 모두 접근 허용
                .antMatchers("/edms/**", "/board/**", "/mypage").authenticated()

                .antMatchers("/join", "/api/login", "/api/join", "/error/*", "/css/**", "/**", "/js/**", "/etc/**", "/users").permitAll()

                .and()
                .logout()
                .logoutUrl("/dologout")
                .logoutSuccessUrl("/")
                .deleteCookies("token")

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")

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
}

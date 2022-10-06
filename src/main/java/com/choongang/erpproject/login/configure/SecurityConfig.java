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
                .antMatchers("/join", "/api/login", "/api/join", "/", "/error/*", "/css/**", "/**", "/js/**", "/etc/**","/users").permitAll()
                .anyRequest().hasAnyRole("SJAU_0001","SJAU_0002","SJAU_0003","SJAU_0004", "SJAU_0005")

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

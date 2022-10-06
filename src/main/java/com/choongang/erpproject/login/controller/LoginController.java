package com.choongang.erpproject.login.controller;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.choongang.erpproject.login.exception.LoginFailedException;
import com.choongang.erpproject.login.dto.LoginDto;
import com.choongang.erpproject.login.dto.Response.BaseResponse;
import com.choongang.erpproject.login.dto.Response.SingleDataResponse;
import com.choongang.erpproject.login.dto.UserDto;
import com.choongang.erpproject.login.service.LoginService;
import com.choongang.erpproject.login.service.ResponseService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final ResponseService responseService;
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(HttpServletRequest request){
        Cookie[] cookie = request.getCookies();
        if(cookie == null){
            return "/login";
        }

        if(Arrays.stream(cookie).filter(c -> c.getName().equals("token")).findAny().isPresent()){
            return "redirect:/users";
        }
        return "/login";
    }

    @GetMapping("/api/join")
    public String join(){
        return "signUp";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDto userDto){

        UserDetails savedUser = loginService.join(userDto);

        return "redirect:/";
    }

  /*  @GetMapping("/api/join")
    @ResponseBody
    public ResponseEntity join(@ModelAttribute UserDto userDto){
        ResponseEntity responseEntity = null;
        try{
            UserDto savedUser = loginService.join(userDto);
            SingleDataResponse<UserDto> response = responseService.getSingleDataResponse(true, "회원가입 성공",savedUser);

            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (DuplicatedUsernameException exception){
            logger.debug(exception.getMessage());
            BaseResponse response = responseService.getBaseResponse(false, exception.getMessage());

            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return responseEntity;
    }*/

    @SneakyThrows
    @RequestMapping(value = "/api/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@ModelAttribute LoginDto loginDto, Model model, HttpServletResponse respon){
        ResponseEntity responseEntity = null;

        try{
            String token = loginService.login(loginDto);
            System.out.println(token);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authoriztion","Bearer "+token);

            SingleDataResponse<String> response = responseService.getSingleDataResponse(true,"로그인 성공", token);

            responseEntity = ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);

            Cookie cookie = new Cookie("token", URLEncoder.encode("Bearer "+token,"UTF-8"));
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60);
            respon.addCookie(cookie);

        }catch(LoginFailedException exception){
            logger.debug(exception.getMessage());
            BaseResponse response = responseService.getBaseResponse(false, exception.getMessage());

            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        return "redirect:/users";
    }

    //api 방식
/*    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity findUserByUsername(final Authentication authentication){
        ResponseEntity responseEntity = null;
        try{
            Long userId = ((UserDto)authentication.getPrincipal()).getUserId();
            UserDto findUser = loginService.findByUserId(userId);

            SingleDataResponse<UserDto> response = responseService.getSingleDataResponse(true, "조회 성공", findUser);

            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(LoginFailedException exception){
            logger.debug(exception.getMessage());
            BaseResponse response = responseService.getBaseResponse(false, exception.getMessage());

            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        System.out.println(responseEntity.toString());

        return responseEntity;
    }*/

    //thymeleaf
    @GetMapping("/users")
    public String findUserByUsername(Authentication authentication, Model model){

        String emp_id = ((UserDto)authentication.getPrincipal()).getEmp_id();
        UserDto findUser = loginService.findById(emp_id);


        model.addAttribute("user", findUser);

        return "/index";
    }
}

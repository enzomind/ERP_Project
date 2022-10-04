package com.choongang.eprproject.test;

import com.choongang.eprproject.dao.erpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TestCont {

    @Autowired
    erpDao erpDao;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "MyBatis 사용하기";
    }

    //@GetMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userlistPage(Model model) {
        model.addAttribute("users", erpDao.selectAll());
        return "test";
    }

    @RequestMapping(value="login")
    public String loginpage(){
        return "login";
    }
}

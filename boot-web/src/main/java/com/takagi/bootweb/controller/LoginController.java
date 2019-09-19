package com.takagi.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String Login(String username, String password, HttpSession session, Map<String,String> map) {

        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            //登陆成功
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}

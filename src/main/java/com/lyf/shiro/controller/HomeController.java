package com.lyf.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 主页
 * Created by Administrator on 2018/3/8.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        System.out.println("HomeController.login()");

        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(exception);

        // 登录成功由Shiro进行处理
        return "/login";
    }
}

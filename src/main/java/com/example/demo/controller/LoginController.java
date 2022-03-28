package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller

public class LoginController {

    @RequestMapping("/user/login")//获取前端参数，前提是需要有name属性
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,HttpSession session){
         //StringUtils.isEmpty 判断是否非空
        if (!StringUtils.isEmpty ( username )&&"123456".equals ( password ))
        {
            //将当前登录信息保存到session
            session.setAttribute ( "LoginName",username );
            return "redirect:/main.html";
        }
        else
        {
            model.addAttribute ( "msg","密码错误" );
            return "index";
        }

    }

}

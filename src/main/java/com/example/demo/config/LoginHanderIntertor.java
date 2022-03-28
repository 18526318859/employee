package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//拦截器部分
public class LoginHanderIntertor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {;
    //从Session中获取当前登录对象的信息
    Object loginName = request.getSession ( ).getAttribute ( "LoginName" );
        if (loginName==null)
        {
            request.setAttribute ( "msg","没有权限，请先登录" );
            //forword转发技术
            request.getRequestDispatcher ( "/index.html" ).forward ( request,response );
            return false;
        }
         return true;
    }
}

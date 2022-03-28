package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//应为类型要求为WebMvcConfigurer，所以我们实现其接口
//可以使用自定义类扩展MVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //增加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除需要放行的界面
        registry.addInterceptor ( new LoginHanderIntertor () ).addPathPatterns ( "/**" ).excludePathPatterns (
                "/","/index.html","/css/**","/img/**","/js/**","/user/login"
        );
    }

    @Override //定义自己的视图
    public void addViewControllers(ViewControllerRegistry registry) {
              registry.addViewController ( "/" ).setViewName ( "index" );
        registry.addViewController ( "/index.html" ).setViewName ( "index" );

        registry.addViewController ( "/404.html" ).setViewName ( "404" );
        registry.addViewController ( "/main.html" ).setViewName ( "dashboard" );
        registry.addViewController ( "/list.html" ).setViewName ( "list" );

    }
}


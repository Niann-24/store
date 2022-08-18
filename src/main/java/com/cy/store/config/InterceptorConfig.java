/*
package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

*/
/***
 * 拦截器的注册
 *//*

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置白名单
        List<String> patterns=new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("css/**");
        patterns.add("images/**");
        patterns.add("js/**");
        patterns.add("web/login.html");
        patterns.add("web/register.html");
        patterns.add("web/index.html");
        patterns.add("web/product.html");
        patterns.add("users/reg");
        patterns.add("users/login");

        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
*/

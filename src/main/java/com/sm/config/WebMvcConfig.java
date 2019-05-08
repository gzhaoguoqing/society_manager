package com.sm.config;

import com.sm.interceptor.CorsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 跨域拦截器需放在最上面
        //registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/login");
    }

}

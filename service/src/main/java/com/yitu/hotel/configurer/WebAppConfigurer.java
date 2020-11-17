package com.yitu.hotel.configurer;

import com.yitu.hotel.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 拦截器拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 用户登录，文件上传，文件导出放开
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/login","/order/export","/order/upload");
    }

}

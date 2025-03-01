package com.ej.rest.bestPractice.config;

import com.ej.rest.bestPractice.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @program: ssm-parent
 * @description: SpringMVC配置类
 * @author: EJ_Zheng
 * @create: 2025-03-01 14:44
 **/

@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    /**
     * @description: 添加拦截器
    * @Param: [registry]
    * @return: void
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**"); // 拦截所有请求
    }


}

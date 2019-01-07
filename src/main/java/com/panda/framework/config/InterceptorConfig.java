package com.panda.framework.config;

import com.panda.framework.handler.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author jamie
 * @ClassName: InterceptorConfig
 * @Description: 拦截器注册
 * @data 2019-01-07 11:18
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}

package com.ncbx.shopweb.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ncbx.shopweb.interceptor.SessionInterceptor;

/**
 * 配置拦截器
 * @author win7
 *
 */
@Configuration
public class WebMvcConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 对所有auth开头的请求做拦截处理
         */
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/auth/**");

        super.addInterceptors(registry);
    }

}
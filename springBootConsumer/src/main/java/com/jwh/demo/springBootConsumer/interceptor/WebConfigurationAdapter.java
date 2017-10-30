package com.jwh.demo.springBootConsumer.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/5/26 0026.
 * 定义一个配置类
 * 用@Configuration注解该类，等价 与XML中配置beans；用@Bean标注方法等价于XML中配置bean。
 */
@Configuration
@EnableWebMvc
public class WebConfigurationAdapter extends WebMvcConfigurerAdapter {

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor());
    }
}

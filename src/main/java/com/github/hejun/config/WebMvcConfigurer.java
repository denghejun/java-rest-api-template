package com.github.hejun.config;

import com.github.hejun.interceptor.OpenApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private OpenApiInterceptor openApiInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(this.openApiInterceptor).addPathPatterns("/**")
                .addPathPatterns("/open/**");

        super.addInterceptors(registry);
    }
}

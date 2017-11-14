package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ApiInterceptor apiInterceptor;
	
    /**{@inheritDoc}
     * </br>注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      //  registry.addInterceptor(apiInterceptor);
    }
    
    /**
     * {@inheritDoc}
     * </br>注册controller映射
     * 如果有相同注解controller 以注解优先
     */
    @Override  
    public void addViewControllers(ViewControllerRegistry registry) { 
        registry.setOrder(0);  
    }
    
    /**
     * {@inheritDoc}
     */
    @Override  
    public void configurePathMatch(PathMatchConfigurer configurer) {  
        super.configurePathMatch(configurer);  
        configurer.setUseSuffixPatternMatch(false);  
    }

}

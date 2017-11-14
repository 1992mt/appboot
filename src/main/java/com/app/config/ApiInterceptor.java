package com.app.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.model.User;

@Component
public class ApiInterceptor  implements HandlerInterceptor{  
    
	private final Logger log = LoggerFactory.getLogger(ApiInterceptor.class);
  
    /** 
     * 进入controller层之前拦截请求 
     * @param httpServletRequest 
     * @param httpServletResponse 
     * @param o 
     * @return 
     * @throws Exception 
     */  
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {  
    	return true;
    }  
  
    @Override  
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {  
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");  
    }  
  
    @Override  
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {  
        log.info("---------------视图渲染之后的操作-------------------------0");  
    }  
}  
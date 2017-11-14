package com.app.common.shiro.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
	private static SpringUtil SpringUtil = null;
	
	private ApplicationContext ctx = null;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringUtil.class);
	
	private SpringUtil(){
	}
	
	public static SpringUtil newInstance(){
		if(SpringUtil == null){
			synchronized (SpringUtil.class) {
				if(SpringUtil == null){
					SpringUtil = new SpringUtil();
				}
			}
		}
		return SpringUtil;
	}
	
	public ApplicationContext getApplicationContext()throws Exception{
		if(ctx == null){
			synchronized (SpringUtil.class) {
				if(ctx == null){
					try {
						ctx = new ClassPathXmlApplicationContext(new String[]{"classpath*:config/applicationContext*.xml", "classpath*:config/spring-servlet*.xml" });  
						String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
						for(int i=0;i<beanDefinitionNames.length;i++){  
							logger.debug(beanDefinitionNames[i]);  
						}
					} catch (Exception e) {
						logger.error("",e);
					}
				}
			}
		}
		return ctx;
	}
	
	public <T> T getAppBean(String beanId){
		if(beanId == null ||"".equals(beanId)){
			return null;
		}
		Object bean = new Object();
		try {
			bean = getApplicationContext().getBean(beanId);
		} catch (Exception e) {
			logger.error("",e);
		}
		return (T)bean;
	} 
	
	public void setApplicationContext(ApplicationContext applicationContext){
		ctx = applicationContext;
	}
	
}

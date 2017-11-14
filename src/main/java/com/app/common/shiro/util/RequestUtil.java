package com.app.common.shiro.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	
	private static RequestUtil requestUtil = null;
	
	private RequestUtil(){
	}
	
	public static RequestUtil newInstance(){
		if(requestUtil == null){
			synchronized (RequestUtil.class) {
				if(requestUtil == null){
					requestUtil = new RequestUtil();
				}
			}
		}
		return requestUtil;
	}
	
	public String getRequestHeader(HttpServletRequest request,String headName){
		return request.getHeader(headName);
	}
	
}

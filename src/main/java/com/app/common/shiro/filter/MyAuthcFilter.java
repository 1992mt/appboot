package com.app.common.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.common.model.User;

/**
 * 授权过滤器
 * 
 * @author mt
 *
 */
public class MyAuthcFilter extends AccessControlFilter {

	private final Logger logger = LoggerFactory.getLogger(MyAuthcFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		logger.info("---------------------开始进入请求地址拦截----------------------------");  
	        Subject currentUser = SecurityUtils.getSubject();  
			 User user = (User) currentUser.getSession().getAttribute("user");
			 if(null != user){
				 return true;
			 }else{
				 String url = httpRequest.getRequestURI().toString().replace(httpRequest.getContextPath(), "");
				 logger.info("请求url:{}",url);
				 if(url.equals("/")){
					 return true;
				 }
				 ((HttpServletResponse)response).sendRedirect(httpRequest.getContextPath());
				 return false;
			 }
		
		/*logger.info("拦截到的url:{}", httpRequest.getRequestURL().toString());
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		logger.info("登录用户名：{}", userName);
		logger.info("登录密码：{}", password);
		// 获取Token,根前台的用户名密码封装token
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {
			// 委托给Realm进行登录
			getSubject(request, response).login(token);
		} catch (Exception e) {
			logger.error("auth error:" + e.getMessage(), e);
			onLoginFail(response, "auth error:" + e.getMessage()); // 6、登录失败
			return false;
		}
		// 通过isPermitted 才能调用doGetAuthorizationInfo方法获取权限信息
		getSubject(request, response).isPermitted(httpRequest.getRequestURI());
		return true;*/
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return false;
	}

	// 登录失败时默认返回401状态码
	private void onLoginFail(ServletResponse response, String errorMsg) throws IOException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		httpResponse.setContentType("text/html");
		httpResponse.setCharacterEncoding("utf-8");
		httpResponse.getWriter().write(errorMsg);
		httpResponse.getWriter().close();
	}

}

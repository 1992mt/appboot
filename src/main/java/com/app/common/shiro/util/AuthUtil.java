package com.app.common.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

	public String getUserCode() {
		Subject subject = SecurityUtils.getSubject();
		return subject.getPrincipal().toString();
	}

}

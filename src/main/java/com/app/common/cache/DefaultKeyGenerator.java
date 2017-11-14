package com.app.common.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class DefaultKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		DefaultKey defaultKey = new DefaultKey(target, method, params);
		return defaultKey.toString();
	}

}

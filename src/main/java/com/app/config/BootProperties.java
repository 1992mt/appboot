package com.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "shiro.token") 
public class BootProperties {
	
	private String key;
	 
	private long expirateTime;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getExpirateTime() {
		return expirateTime;
	}

	public void setExpirateTime(long expirateTime) {
		this.expirateTime = expirateTime;
	}
	 
	 

}

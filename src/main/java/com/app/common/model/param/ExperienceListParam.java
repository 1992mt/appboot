package com.app.common.model.param;

public class ExperienceListParam extends RequestPageParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 区分是查看自己还是所有的
	 */
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}

package com.app.common.model.response;

import com.app.common.model.Comment;

public class CommentResponse extends Comment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 心得标题或者文件标题
	 */
	private String experienceTitle;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExperienceTitle() {
		return experienceTitle;
	}

	public void setExperienceTitle(String experienceTitle) {
		this.experienceTitle = experienceTitle;
	}
	
	
}

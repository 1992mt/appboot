package com.app.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.common.model.User;

/**
 * 
 * @author mt
 *静态页面获取
 */
@Controller
@RequestMapping("")
public class IndexController {
	
	/**
	 * 应用首页
	 */
	@RequestMapping(value = "")
	public String index(Model model){
		return "index";
	}
	
	/**
	 * 用户注册页面
	 */
	@RequestMapping(value = "toRegist")
	public String toRegist(){
		return "regist";
	}
	
	/**
	 * 用户注册页面
	 */
	@RequestMapping(value = "toFileUpLoad")
	public String toFileUpLoad(){
		return "fileUploadPage";
	}
	
	/**
	 * 滚动加载测试
	 */
	@RequestMapping(value = "content")
	public String content(){
		return "content";
	}
	
	/**
	 * 心得阅读页面
	 */
	@RequestMapping(value = "toExperienceRead")
	public String toExperienceRead(){
		return "experienceRead";
	}
	
	/**
	 * 心得列表页面(默认所有)
	 * @return
	 */
	@RequestMapping(value = "toAllExperience")
	public String toAllExperience(Model model){
		return "experienceList";
	}
	
	/**
	 * 获取当前用户的心得列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toMyExperience")
	public String toMyExperience(Model model){
		Subject currentUser = SecurityUtils.getSubject();  
		 User user = (User) currentUser.getSession().getAttribute("user");
		model.addAttribute("userId", user.getId());
		return "experienceList";
	}
	
	
	/**
	 * 评论页面
	 * @return
	 */
	@RequestMapping(value = "toComment")
	public String toComment(Model model,String id){
		model.addAttribute("expid",id);
		return "commentList";
	}
	
	/**
	 * request.getSession()和currentUser.getSession() 两种session页面都能获取到
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/header")
	public String header(Model model,HttpServletRequest request) {
		 Subject currentUser = SecurityUtils.getSubject();  
		 currentUser.getSession().setAttribute("sessionTitle", "心得传递");
//		 currentUser.getSession().setAttribute("user", new User());
		//request.getSession().setAttribute("sessionTitle", "session心得传递");
//		model.addAttribute("title", "心得传递");
		return "header";
	}

	@RequestMapping(value = "/footer")
	public String footer(Model model) {
		return "footer";
	}

}
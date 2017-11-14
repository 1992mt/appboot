package com.app.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.common.model.User;
import com.app.common.model.UserRole;
import com.app.common.model.param.RegistUserParam;
import com.app.service.RoleService;
import com.app.service.UserService;
import com.github.pagehelper.StringUtil;


@Controller
@RequestMapping("/")
public class LoginController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService; 
	
	/**
	 * 用户登录
	 * @param model
	 * @param user
	 * @return
	 */
	  @RequestMapping(value="login")
	    public String login(Model model,User user){
		  User findUserByUserName = userService.findUserByUserName(user.getUsername());
		  if(null == findUserByUserName || !findUserByUserName.getPassword().equals(user.getPassword())){
			  model.addAttribute("errorMsg", "用户名或密码错误");
			  model.addAttribute("userName", user.getUsername());
			  model.addAttribute("passWord", user.getPassword());
			  return "index";//返回登录页面
		  }else{
			  Subject currentUser = SecurityUtils.getSubject();  
			  currentUser.getSession().setAttribute("user", findUserByUserName);
			  List<String> listRoles = roleService.listRolesName(findUserByUserName.getUsername());
			  if(listRoles.contains("manage")){//管理员角色    TODO临时采用
//				  currentUser.getSession().setAttribute("manage", listRoles);
				  currentUser.getSession().setAttribute("manage", true);
			  }
			  return "experienceList";//心得列表页面
		  }
	    }
	  
	  /**
	   * 注册用户
	   * @param model
	   * @param registUserParam
	   * @return
	   */
	  @RequestMapping(value="regist",method=RequestMethod.POST)
	  public String regist(Model model,RegistUserParam registUserParam){
		  model.addAttribute("registUserName", registUserParam.getUsername());
		  model.addAttribute("registPassWord", registUserParam.getPassword());
		  if(StringUtil.isEmpty(registUserParam.getUsername())){
			  model.addAttribute("registErrorMsg", "用户名为空");
			  return "regist";
		  }
		  if(!registUserParam.getPassword().equals(registUserParam.getConFirmPassword())){//两次密码不一致
			  model.addAttribute("registErrorMsg", "两次密码不一致");
			  return "regist";
		  }
		  User findUserByUserName = userService.findUserByUserName(registUserParam.getUsername());
		  if(null != findUserByUserName){
			  model.addAttribute("registErrorMsg", "用户已经存在");
			  return "regist";
		  }
		  User user = new User();
		  user.setUsername(registUserParam.getUsername());
		  user.setPassword(registUserParam.getPassword());
		  userService.addUser(user);
		  User findUserByUserName2 = userService.findUserByUserName(registUserParam.getUsername());
		  UserRole userRole = new UserRole();
		  userRole.setRoleId(2);//普通用户
		  userRole.setUserId(findUserByUserName2.getId());//新增用户的id TODO临时采用
		  roleService.addUserRole(userRole);
		  Subject currentUser = SecurityUtils.getSubject();  
		  currentUser.getSession().setAttribute("user", user);//直接免再次登录
		  return "experienceList";
		  
	  }
	  
	  @RequestMapping(value="logout")
	  public String logout(){
		  Subject currentUser = SecurityUtils.getSubject();
		  currentUser.logout();
		  return "index";
	  }

	
	
}
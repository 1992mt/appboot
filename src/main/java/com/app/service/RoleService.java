package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.common.mapper.RoleCustomMapper;
import com.app.common.mapper.UserRoleMapper;
import com.app.common.model.Role;
import com.app.common.model.UserRole;

/**
 * 用户角色
 * @author mt
 *
 */
@Service
@CacheConfig(cacheNames = "role")
public class RoleService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleCustomMapper roleCustomMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;


	@Cacheable
	public List<Role> listRoles(String principal) {
		List<Role> roles = new ArrayList<Role>();
		// 从数据库获取权限并设置
		logger.info("add roles");
	/*	if ("admin".equals(principal)) {
			roles.add("admin");
			roles.add("vistor");
		}*/
		roles = roleCustomMapper.listRolesByUserName(principal);
		return roles;
	}
	
	@Cacheable
	public List<String> listRolesName(String principal) {
		List<String> roles = new ArrayList<String>();
		// 从数据库获取权限并设置
		logger.info("add roles");
	/*	if ("admin".equals(principal)) {
			roles.add("admin");
			roles.add("vistor");
		}*/
		List<Role> list = this.listRoles(principal);
		for (Role role : list) {
			roles.add(role.getRolename());
		}
		return roles;
	}
	
	/**
	 * 增加用户角色关系
	 * @param userRole
	 * @return
	 */
	@CacheEvict(allEntries=true)
	public int addUserRole(UserRole userRole){
		return userRoleMapper.insert(userRole);
	}

}

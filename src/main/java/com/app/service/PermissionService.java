package com.app.service;
/**
 * 权限
 * @author mt
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.common.mapper.PermissionCustomMapper;
import com.app.common.model.Permission;

@Service
@CacheConfig(cacheNames = "permission")
public class PermissionService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PermissionCustomMapper permissionCustomMapper;
	
	/**
	 * 根据角色id获取权限
	 * @param roleid
	 * @return
	 */
	@Cacheable
	public List<String> listPermissionByRole(int roleid){
		List<Permission> listPermissionByRole = permissionCustomMapper.listPermissionByRole(roleid);
		List<String> permissiobList = new ArrayList<String>();
		for (Permission permission : listPermissionByRole) {
			permissiobList.add(permission.getPermissionname());
		}
		return permissiobList;
	}
}

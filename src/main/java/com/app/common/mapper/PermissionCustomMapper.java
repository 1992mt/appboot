package com.app.common.mapper;

import java.util.List;

import com.app.common.model.Permission;

import tk.mybatis.mapper.common.Mapper;

public interface PermissionCustomMapper extends Mapper<Permission> {
	
	List<Permission> listPermissionByRole(int roleid);
}
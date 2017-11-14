package com.app.common.mapper;

import java.util.List;

import com.app.common.model.Role;

import tk.mybatis.mapper.common.Mapper;
/**
 * 自定义组合查询
 * @author mt
 *
 */
public interface RoleCustomMapper extends Mapper<Role> {
	List<Role> listRolesByUserName(String username);
}
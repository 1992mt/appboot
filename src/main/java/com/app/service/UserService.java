package com.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.app.common.mapper.UserMapper;
import com.app.common.model.User;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 用户
 * @author mt
 *
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	@Cacheable
	public User findUserByUserName(String username) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(username)) {
			criteria.andEqualTo(User.JavaFieldEnum.username.name(), username);
		}
		List<User> list = userMapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@CacheEvict(allEntries=true)
	public int addUser(User user){
		return userMapper.insert(user);
	}
	
}

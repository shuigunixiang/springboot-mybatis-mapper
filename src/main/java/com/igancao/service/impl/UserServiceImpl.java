package com.igancao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igancao.domain.User;
import com.igancao.framework.base.AbstractGenericService;
import com.igancao.mapper.UserMapper;
import com.igancao.service.IUserService;

@Service
public class UserServiceImpl extends AbstractGenericService<User> implements
		IUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getOneByPk2(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 数据修饰方法
	 */
	@Override
	protected void handlerData(Object obj) {
		// Todo
	}

}

package com.igancao.service;

import com.igancao.domain.User;
import com.igancao.framework.base.GenericService;

public interface IUserService extends GenericService<User> {

	public User getOneByPk2(int id);

}

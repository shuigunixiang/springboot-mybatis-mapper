package com.igancao.mapper;

import org.apache.ibatis.annotations.Select;

import com.igancao.domain.User;
import com.igancao.framework.mybatis.MyMapper;

public interface UserMapper extends MyMapper<User> {

	@Select("select * from boc_user where id = #{id}")
	public User test(int id);

}

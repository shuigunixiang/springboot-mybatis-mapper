package com.igancao.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igancao.domain.User;
import com.igancao.framework.base.BaseController;
import com.igancao.service.IUserService;

@RestController
@RequestMapping("api/user")
public class UserController extends BaseController {

	@Resource
	private IUserService userService;

	/**
	 * 获取用户列表
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping("list")
	public String getList(User user, BindingResult result) {
		if (result.hasErrors()) {
			return handleValidRule(result);
		}
		List<User> all = userService.getAll();
		return handleDataOutput(all);
	}

	/**
	 * 获取单个取用户信息
	 * 
	 * @param user
	 * @param result
	 * @return
	 */

	@RequestMapping("one")
	public String getOne(User user, BindingResult result) {
		if (result.hasErrors()) {
			return handleValidRule(result);
		}
		User oneByPk = userService.getOneByPk2(60);
		return handleDataOutput(oneByPk);

	}
}

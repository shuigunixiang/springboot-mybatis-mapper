package com.igancao.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igancao.domain.Doctor;
import com.igancao.domain.User;
import com.igancao.framework.base.BaseController;
import com.igancao.service.IDoctorService;

@RestController
@RequestMapping("api/doctor")
public class DoctorController extends BaseController {

	@Resource
	private IDoctorService doctorService;

	/**~
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
		List<Doctor> all = doctorService.getAll();
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
		Doctor oneByPk = doctorService.getOneByPk(129);
		return handleDataOutput(oneByPk);

	}
}

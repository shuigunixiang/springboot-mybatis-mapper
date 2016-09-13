package com.igancao.service.impl;

import org.springframework.stereotype.Service;

import com.igancao.domain.Doctor;
import com.igancao.framework.base.AbstractGenericService;
import com.igancao.service.IDoctorService;

@Service
public class DoctorServiceImpl extends AbstractGenericService<Doctor> implements
		IDoctorService {

	/**
	 * 数据修饰方法
	 */
	@Override
	protected void handlerData(Object obj) {
		// Todo
		System.out.println("handler data");
	}

}

package com.igancao.framework.base;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.igancao.framework.pojo.DataResult;
import com.igancao.util.AesUtils;

@Controller
public class BaseController {

	// 检验实体对象规则并输出
	public String handleValidRule(BindingResult result) {
		List<ObjectError> list = result.getAllErrors();
		StringBuffer sb = new StringBuffer();
		for (ObjectError error : list) {
			sb.append(error.getDefaultMessage()).append("\r\n");
		}
		return encrypt(new DataResult().setMsg(sb.toString()));
	}

	// 组装结果对象并输出
	public String handleDataOutput(Object obj) {
		return encrypt(new DataResult().setStatus("1").setMsg("success")
				.setData(obj != null ? obj : ""));
	}

	// 当前对象AES加密处理
	private String encrypt(DataResult result) {
		return AesUtils.AES_Encrypt(result);
	}
}

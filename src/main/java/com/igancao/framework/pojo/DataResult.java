package com.igancao.framework.pojo;

import java.util.Collections;

/**
 * 
 * @author 诃子
 * @param <T>
 */
public class DataResult {

	private String status = "-1";
	private String msg = "no data";
	private Object data = Collections.emptyList();

	public String getStatus() {
		return status;
	}

	public DataResult setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public DataResult setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public DataResult setData(Object data) {
		this.data = data;
		return this;
	}

}

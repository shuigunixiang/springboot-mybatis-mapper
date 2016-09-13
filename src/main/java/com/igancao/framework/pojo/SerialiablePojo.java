package com.igancao.framework.pojo;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import tk.mybatis.mapper.entity.IDynamicTableName;

public class SerialiablePojo implements IDynamicTableName, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1723454386503700396L;

	// 当前页数
	@Transient
	@NotNull(message = "当前页数必须填写")
	private Integer page;

	// 总页数
	@Transient
	private Integer totalPages;

	// 动态表名
	@Transient
	private String dynamicTableName;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String getDynamicTableName() {
		return dynamicTableName;
	}

	public void setDynamicTableName(String dynamicTableName) {
		this.dynamicTableName = dynamicTableName;
	}

}

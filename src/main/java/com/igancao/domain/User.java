package com.igancao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.igancao.framework.pojo.SerialiablePojo;

@Table(name = "boc_user")
@Entity
public class User extends SerialiablePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8651666861885784817L;
	@Id
	private Integer id;
	@Column(name = "nickname")
	private String nickName;
	@Column(name = "reg_time")
	private Long regTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getRegTime() {
		return regTime;
	}

	public void setRegTime(Long regTime) {
		this.regTime = regTime;
	}

}

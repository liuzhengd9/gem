package com.liuzheng.gem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends ParentEntity {

	private static final long serialVersionUID = -5672334309527348137L;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "regist_time")
	private Date registTime;

	@Column(name = "update_time")
	private Date updateTime;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private UserDetail userDetail;

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPhone() {

		return phone;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	}

	public Date getRegistTime() {

		return registTime;
	}

	public void setRegistTime(Date registTime) {

		this.registTime = registTime;
	}

	public Date getUpdateTime() {

		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {

		this.updateTime = updateTime;
	}

	public UserDetail getUserDetail() {

		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {

		this.userDetail = userDetail;
	}

}

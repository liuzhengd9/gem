package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province extends ParentEntity {

	private static final long serialVersionUID = -3827191826861191816L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "order_field")
	private Integer orderField;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	public Integer getOrderField() {

		return orderField;
	}

	public void setOrderField(Integer orderField) {

		this.orderField = orderField;
	}
}

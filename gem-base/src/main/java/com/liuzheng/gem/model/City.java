package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends ParentEntity {

	private static final long serialVersionUID = 2523203114403291443L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "order_field")
	private Integer orderField;

	@ManyToOne(optional = false)
	@JoinColumn(name = "province_id")
	private Province province;

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

	public Province getProvince() {

		return province;
	}

	public void setProvince(Province province) {

		this.province = province;
	}
}

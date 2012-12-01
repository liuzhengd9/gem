package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area extends ParentEntity {

	private static final long serialVersionUID = -4639978976530655235L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "order_field")
	private Integer orderField;

	@ManyToOne(optional = false)
	@JoinColumn(name = "city_id")
	private City city;

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

	public City getCity() {

		return city;
	}

	public void setCity(City city) {

		this.city = city;
	}
}

package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "navigation")
public class Navigation extends ParentEntity {

	private static final long serialVersionUID = -2716132334029415189L;

	@Column(name = "name")
	private String name;

	@Column(name = "href")
	private String href;

	@Column(name = "order_field")
	private Integer orderField;

	@Column(name = "cls")
	private String cls;

	@Column(name = "selected_cls")
	private String selectedCls;

	@Column(name = "description")
	private String description;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getHref() {

		return href;
	}

	public void setHref(String href) {

		this.href = href;
	}

	public Integer getOrderField() {

		return orderField;
	}

	public void setOrderField(Integer orderField) {

		this.orderField = orderField;
	}

	public String getCls() {

		return cls;
	}

	public void setCls(String cls) {

		this.cls = cls;
	}

	public String getSelectedCls() {

		return selectedCls;
	}

	public void setSelectedCls(String selectedCls) {

		this.selectedCls = selectedCls;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}

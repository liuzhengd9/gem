package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color extends ParentEntity {

	private static final long serialVersionUID = -4611745299129234195L;

	@Column(name = "name")
	private String name;

	@Column(name = "cls")
	private String cls;

	@Column(name = "style")
	private String style;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getCls() {

		return cls;
	}

	public void setCls(String cls) {

		this.cls = cls;
	}

	public String getStyle() {

		return style;
	}

	public void setStyle(String style) {

		this.style = style;
	}
}

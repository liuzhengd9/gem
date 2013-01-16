package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unit")
public class Unit extends ParentEntity {

	private static final long serialVersionUID = 1515907226287775879L;

	@Column(name = "name")
	private String name;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}
}

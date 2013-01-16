package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sizes")
public class Size extends ParentEntity {

	private static final long serialVersionUID = 1449936207552015469L;

	@Column(name = "size")
	private String size;

	public String getSize() {

		return size;
	}

	public void setSize(String size) {

		this.size = size;
	}
}

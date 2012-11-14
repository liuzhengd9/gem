package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image_type")
public class ImageType extends ParentEntity {

	private static final long serialVersionUID = -7549064444456344240L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}

package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image extends ParentEntity {

	private static final long serialVersionUID = -2284160484389519447L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "relative_path")
	private String relativePath;

	@ManyToOne(optional = false)
	@JoinColumn(name = "type_id")
	private ImageType imageType;

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

	public String getRelativePath() {

		return relativePath;
	}

	public void setRelativePath(String relativePath) {

		this.relativePath = relativePath;
	}

	public ImageType getImageType() {

		return imageType;
	}

	public void setImageType(ImageType imageType) {

		this.imageType = imageType;
	}

	public Integer getImageTypeId() {

		if (imageType != null) {
			return imageType.getId();
		} else {
			return null;
		}
	}

}

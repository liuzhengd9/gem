package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image_config")
public class ImageConfig extends ParentEntity {

	private static final long serialVersionUID = 7634535426862067871L;

	@Column(name = "config_code", nullable = false, unique = true)
	private String configCode;

	@Column(name = "config_value", nullable = false)
	private String configValue;

	@Column(name = "description")
	private String description;

	public String getConfigCode() {

		return configCode;
	}

	public void setConfigCode(String configCode) {

		this.configCode = configCode;
	}

	public String getConfigValue() {

		return configValue;
	}

	public void setConfigValue(String configValue) {

		this.configValue = configValue;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}

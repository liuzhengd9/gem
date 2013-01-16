package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_image")
public class ProductImage extends ParentEntity {

	private static final long serialVersionUID = -5218119371356882565L;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "url")
	private String url;

	@Column(name = "order_field")
	private Integer orderField;

	public Integer getProductId() {

		return productId;
	}

	public void setProductId(Integer productId) {

		this.productId = productId;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	public Integer getOrderField() {

		return orderField;
	}

	public void setOrderField(Integer orderField) {

		this.orderField = orderField;
	}
}

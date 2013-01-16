package com.liuzheng.gem.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends ParentEntity {

	private static final long serialVersionUID = -4235408604852901032L;

	@Column(name = "name")
	private String name;

	@Column(name = "brand")
	private String brand;

	@Column(name = "mark_price")
	private BigDecimal markPrice;

	@Column(name = "selling_price")
	private BigDecimal sellingPrice;

	@Column(name = "origin_place")
	private String originPlace;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "description")
	private String description;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getBrand() {

		return brand;
	}

	public void setBrand(String brand) {

		this.brand = brand;
	}

	public BigDecimal getMarkPrice() {

		return markPrice;
	}

	public void setMarkPrice(BigDecimal markPrice) {

		this.markPrice = markPrice;
	}

	public BigDecimal getSellingPrice() {

		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {

		this.sellingPrice = sellingPrice;
	}

	public String getOriginPlace() {

		return originPlace;
	}

	public void setOriginPlace(String originPlace) {

		this.originPlace = originPlace;
	}

	public String getManufacturer() {

		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {

		this.manufacturer = manufacturer;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}

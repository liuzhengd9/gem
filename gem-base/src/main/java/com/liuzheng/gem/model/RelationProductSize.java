package com.liuzheng.gem.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relation_product_size")
public class RelationProductSize extends ParentEntity {

	private static final long serialVersionUID = -7354777964045933638L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "size_id")
	private Size size;

	@ManyToOne(optional = false)
	@JoinColumn(name = "unit_id")
	private Unit unit;

	public Product getProduct() {

		return product;
	}

	public void setProduct(Product product) {

		this.product = product;
	}

	public Size getSize() {

		return size;
	}

	public void setSize(Size size) {

		this.size = size;
	}

	public Unit getUnit() {

		return unit;
	}

	public void setUnit(Unit unit) {

		this.unit = unit;
	}
}

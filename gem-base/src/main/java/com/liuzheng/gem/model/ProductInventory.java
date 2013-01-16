package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_inventory")
public class ProductInventory extends ParentEntity {

	private static final long serialVersionUID = 4204487294864621375L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne(optional = false)
	@JoinColumn(name = "size_id")
	private Size size;

	@Column(name = "quantity")
	private Integer quantity;

	public Product getProduct() {

		return product;
	}

	public void setProduct(Product product) {

		this.product = product;
	}

	public Color getColor() {

		return color;
	}

	public void setColor(Color color) {

		this.color = color;
	}

	public Size getSize() {

		return size;
	}

	public void setSize(Size size) {

		this.size = size;
	}

	public Integer getQuantity() {

		return quantity;
	}

	public void setQuantity(Integer quantity) {

		this.quantity = quantity;
	}
}

package com.liuzheng.gem.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail extends ParentEntity {

	private static final long serialVersionUID = 4667509704429178141L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne(optional = false)
	@JoinColumn(name = "size_id")
	private Size size;

	public Order getOrder() {

		return order;
	}

	public void setOrder(Order order) {

		this.order = order;
	}

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
}

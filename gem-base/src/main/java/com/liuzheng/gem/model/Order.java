package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends ParentEntity {

	private static final long serialVersionUID = 1673482505007054579L;

	@Column(name = "order_no")
	private String orderNo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "province_id")
	private Province province;

	@ManyToOne(optional = false)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(optional = false)
	@JoinColumn(name = "area_id")
	private Area area;

	public String getOrderNo() {

		return orderNo;
	}

	public void setOrderNo(String orderNo) {

		this.orderNo = orderNo;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public Province getProvince() {

		return province;
	}

	public void setProvince(Province province) {

		this.province = province;
	}

	public City getCity() {

		return city;
	}

	public void setCity(City city) {

		this.city = city;
	}

	public Area getArea() {

		return area;
	}

	public void setArea(Area area) {

		this.area = area;
	}
}

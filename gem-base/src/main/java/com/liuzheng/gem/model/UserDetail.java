package com.liuzheng.gem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class UserDetail extends ParentEntity {

	private static final long serialVersionUID = 2880674651479632944L;

	@Column(name = "sex")
	private Integer sex;

	@Column(name = "birthday")
	private Date birthday;

	@ManyToOne(optional = false)
	@JoinColumn(name = "province_id")
	private Province province;

	@ManyToOne(optional = false)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(optional = false)
	@JoinColumn(name = "area_id")
	private Area area;

	@Column(name = "address")
	private String address;

	@Column(name = "description")
	private String description;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", unique = true)
	private User user;

	public Integer getSex() {

		return sex;
	}

	public void setSex(Integer sex) {

		this.sex = sex;
	}

	public Date getBirthday() {

		return birthday;
	}

	public void setBirthday(Date birthday) {

		this.birthday = birthday;
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

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

}

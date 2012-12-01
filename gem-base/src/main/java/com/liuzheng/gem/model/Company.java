package com.liuzheng.gem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends ParentEntity {

	private static final long serialVersionUID = -6945825327621792127L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "address")
	private String address;

	@Column(name = "founded_date")
	private Date foundedDate;

	@Column(name = "type")
	private Integer type;

	@Column(name = "registered_captial")
	private Double registeredCaptial;

	@Column(name = "legal_person")
	private String legalPerson;

	@Column(name = "people_number")
	private Integer peopleNumber;

	@Column(name = "description")
	private String description;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public Date getFoundedDate() {

		return foundedDate;
	}

	public void setFoundedDate(Date foundedDate) {

		this.foundedDate = foundedDate;
	}

	public Integer getType() {

		return type;
	}

	public void setType(Integer type) {

		this.type = type;
	}

	public Double getRegisteredCaptial() {

		return registeredCaptial;
	}

	public void setRegisteredCaptial(Double registeredCaptial) {

		this.registeredCaptial = registeredCaptial;
	}

	public String getLegalPerson() {

		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {

		this.legalPerson = legalPerson;
	}

	public Integer getPeopleNumber() {

		return peopleNumber;
	}

	public void setPeopleNumber(Integer peopleNumber) {

		this.peopleNumber = peopleNumber;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}

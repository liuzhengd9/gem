package com.liuzheng.gem.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends ParentEntity {

	private static final long serialVersionUID = -2075377227001584913L;

	private String name;

	private Integer level;

	private String href;

	private Integer orderField;

	private String cls;

	private String selectedCls;

	private String description;

	@Column(name = "parent_id")
	private Integer parentId;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Set<Category> children;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getLevel() {

		return level;
	}

	public void setLevel(Integer level) {

		this.level = level;
	}

	public String getHref() {

		return href;
	}

	public void setHref(String href) {

		this.href = href;
	}

	public Integer getOrderField() {

		return orderField;
	}

	public void setOrderField(Integer orderField) {

		this.orderField = orderField;
	}

	public String getCls() {

		return cls;
	}

	public void setCls(String cls) {

		this.cls = cls;
	}

	public String getSelectedCls() {

		return selectedCls;
	}

	public void setSelectedCls(String selectedCls) {

		this.selectedCls = selectedCls;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public Integer getParentId() {

		return parentId;
	}

	public void setParentId(Integer parentId) {

		this.parentId = parentId;
	}

	public Set<Category> getChildren() {

		return children;
	}

	public void setChildren(Set<Category> children) {

		this.children = children;
	}
}

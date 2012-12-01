package com.liuzheng.gem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "relation_manager_menu")
public class RelationManagerMenu extends ParentEntity {

	private static final long serialVersionUID = 778989576645139885L;

	@Column(name = "manager_id")
	private Integer managerId;

	@Column(name = "menu_id")
	private Integer menuId;

	public Integer getManagerId() {

		return managerId;
	}

	public void setManagerId(Integer managerId) {

		this.managerId = managerId;
	}

	public Integer getMenuId() {

		return menuId;
	}

	public void setMenuId(Integer menuId) {

		this.menuId = menuId;
	}
}

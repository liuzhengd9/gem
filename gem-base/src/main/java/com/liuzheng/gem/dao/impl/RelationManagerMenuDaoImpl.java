package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.RelationManagerMenuDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.RelationManagerMenu;

@Repository(value = "relationManagerMenuDao")
public class RelationManagerMenuDaoImpl extends BaseDaoImpl<RelationManagerMenu, Integer> implements RelationManagerMenuDao {

	@Override
	public Class<RelationManagerMenu> getPersistenceClass() {

		return RelationManagerMenu.class;
	}

}

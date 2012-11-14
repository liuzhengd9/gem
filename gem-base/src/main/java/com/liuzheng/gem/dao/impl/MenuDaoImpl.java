package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.MenuDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Menu;

@Repository(value = "menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu, Integer> implements MenuDao {

	@Override
	public Class<Menu> getPersistenceClass() {

		return Menu.class;
	}

}

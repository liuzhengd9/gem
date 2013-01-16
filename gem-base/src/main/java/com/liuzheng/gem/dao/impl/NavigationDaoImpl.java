package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.NavigationDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Navigation;

@Repository(value = "navigationDao")
public class NavigationDaoImpl extends BaseDaoImpl<Navigation, Integer> implements NavigationDao {

	@Override
	public Class<Navigation> getPersistenceClass() {

		return Navigation.class;
	}

}

package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.AreaDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Area;

@Repository(value = "areaDao")
public class AreaDaoImpl extends BaseDaoImpl<Area, Integer> implements AreaDao {

	@Override
	public Class<Area> getPersistenceClass() {

		return Area.class;
	}

}

package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.CityDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.City;

@Repository(value = "cityDao")
public class CityDaoImpl extends BaseDaoImpl<City, Integer> implements CityDao {

	@Override
	public Class<City> getPersistenceClass() {

		return City.class;
	}

}

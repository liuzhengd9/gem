package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ProvinceDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Province;

@Repository(value = "provinceDao")
public class ProvinceDaoImpl extends BaseDaoImpl<Province, Integer> implements ProvinceDao {

	@Override
	public Class<Province> getPersistenceClass() {

		return Province.class;
	}

}

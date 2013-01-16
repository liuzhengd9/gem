package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.UnitDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Unit;

@Repository(value = "unitDao")
public class UnitDaoImpl extends BaseDaoImpl<Unit, Integer> implements UnitDao {

	@Override
	public Class<Unit> getPersistenceClass() {

		return Unit.class;
	}

}

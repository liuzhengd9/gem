package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ManagerDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Manager;

@Repository(value = "managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager, Integer> implements ManagerDao {

	@Override
	public Class<Manager> getPersistenceClass() {

		return Manager.class;
	}

}

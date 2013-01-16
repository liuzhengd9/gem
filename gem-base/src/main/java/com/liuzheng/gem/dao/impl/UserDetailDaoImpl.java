package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.UserDetailDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.UserDetail;

@Repository(value = "userDetailDao")
public class UserDetailDaoImpl extends BaseDaoImpl<UserDetail, Integer> implements UserDetailDao {

	@Override
	public Class<UserDetail> getPersistenceClass() {

		return UserDetail.class;
	}

}

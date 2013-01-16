package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.UserDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.User;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	@Override
	public Class<User> getPersistenceClass() {

		return User.class;
	}

}

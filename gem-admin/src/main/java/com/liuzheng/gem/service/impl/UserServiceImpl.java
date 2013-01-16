package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.UserDao;
import com.liuzheng.gem.model.User;
import com.liuzheng.gem.service.UserService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer, UserDao> implements UserService {

	@Resource(name = "userDao", type = UserDao.class)
	private UserDao userDao;

	@Override
	public UserDao getDao() {

		return userDao;
	}

}

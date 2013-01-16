package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.UserDetailDao;
import com.liuzheng.gem.model.UserDetail;
import com.liuzheng.gem.service.UserDetailService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "userDetailService")
@Transactional
public class UserDetailServiceIimpl extends BaseServiceImpl<UserDetail, Integer, UserDetailDao> implements UserDetailService {

	@Resource(name = "userDetailDao", type = UserDetailDao.class)
	private UserDetailDao userDetailDao;

	@Override
	public UserDetailDao getDao() {

		return userDetailDao;
	}

}

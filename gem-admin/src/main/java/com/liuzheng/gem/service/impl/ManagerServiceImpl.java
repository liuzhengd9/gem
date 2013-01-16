package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ManagerDao;
import com.liuzheng.gem.model.Manager;
import com.liuzheng.gem.service.ManagerService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "managerService")
@Transactional
public class ManagerServiceImpl extends BaseServiceImpl<Manager, Integer, ManagerDao> implements ManagerService {

	@Resource(name = "managerDao", type = ManagerDao.class)
	private ManagerDao managerDao;

	@Override
	public ManagerDao getDao() {

		return managerDao;
	}

}

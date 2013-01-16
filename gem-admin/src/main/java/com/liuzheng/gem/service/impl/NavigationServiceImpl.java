package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.NavigationDao;
import com.liuzheng.gem.model.Navigation;
import com.liuzheng.gem.service.NavigationService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "navigationService")
@Transactional
public class NavigationServiceImpl extends BaseServiceImpl<Navigation, Integer, NavigationDao> implements NavigationService {

	@Resource(name = "navigationDao", type = NavigationDao.class)
	private NavigationDao navigationDao;

	@Override
	public NavigationDao getDao() {

		return navigationDao;
	}

}

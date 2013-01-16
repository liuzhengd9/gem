package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.CityDao;
import com.liuzheng.gem.model.City;
import com.liuzheng.gem.service.CityService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "cityService")
@Transactional
public class CityServiceImpl extends BaseServiceImpl<City, Integer, CityDao> implements CityService {

	@Resource(name = "cityDao", type = CityDao.class)
	private CityDao cityDao;

	@Override
	public CityDao getDao() {

		return cityDao;
	}

}

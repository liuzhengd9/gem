package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.AreaDao;
import com.liuzheng.gem.model.Area;
import com.liuzheng.gem.service.AreaService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "areaService")
@Transactional
public class AreaServiceImpl extends BaseServiceImpl<Area, Integer, AreaDao> implements AreaService {

	@Resource(name = "areaDao", type = AreaDao.class)
	private AreaDao areaDao;

	@Override
	public AreaDao getDao() {

		return areaDao;
	}

}

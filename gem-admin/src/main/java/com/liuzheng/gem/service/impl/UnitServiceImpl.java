package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.UnitDao;
import com.liuzheng.gem.model.Unit;
import com.liuzheng.gem.service.UnitService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "unitService")
@Transactional
public class UnitServiceImpl extends BaseServiceImpl<Unit, Integer, UnitDao> implements UnitService {

	@Resource(name = "unitDao", type = UnitDao.class)
	private UnitDao unitDao;

	@Override
	public UnitDao getDao() {

		return unitDao;
	}

}

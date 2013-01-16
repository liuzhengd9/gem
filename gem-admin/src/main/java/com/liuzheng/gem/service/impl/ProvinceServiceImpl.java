package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ProvinceDao;
import com.liuzheng.gem.model.Province;
import com.liuzheng.gem.service.ProvinceService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "provinceService")
@Transactional
public class ProvinceServiceImpl extends BaseServiceImpl<Province, Integer, ProvinceDao> implements ProvinceService {

	@Resource(name = "provinceDao", type = ProvinceDao.class)
	private ProvinceDao provinceDao;

	@Override
	public ProvinceDao getDao() {

		return provinceDao;
	}

}

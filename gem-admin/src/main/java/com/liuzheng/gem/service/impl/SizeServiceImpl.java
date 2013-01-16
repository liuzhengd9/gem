package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.SizeDao;
import com.liuzheng.gem.model.Size;
import com.liuzheng.gem.service.SizeService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "sizeService")
@Transactional
public class SizeServiceImpl extends BaseServiceImpl<Size, Integer, SizeDao> implements SizeService {

	@Resource(name = "sizeDao", type = SizeDao.class)
	private SizeDao sizeDao;

	@Override
	public SizeDao getDao() {

		return sizeDao;
	}

}

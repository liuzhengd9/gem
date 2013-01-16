package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.RelationProductColorDao;
import com.liuzheng.gem.model.RelationProductColor;
import com.liuzheng.gem.service.RelationProductColorService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "relationProductColorService")
@Transactional
public class RelationProductColorServiceImpl extends BaseServiceImpl<RelationProductColor, Integer, RelationProductColorDao> implements RelationProductColorService {

	@Resource(name = "relationProductColorDao", type = RelationProductColorDao.class)
	private RelationProductColorDao relationProductColorDao;

	@Override
	public RelationProductColorDao getDao() {

		return relationProductColorDao;
	}

}

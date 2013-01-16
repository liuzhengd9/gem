package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.RelationProductSizeDao;
import com.liuzheng.gem.model.RelationProductSize;
import com.liuzheng.gem.service.RelationProductSizeService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "relationProductSizeService")
@Transactional
public class RelationProductSizeServiceImpl extends BaseServiceImpl<RelationProductSize, Integer, RelationProductSizeDao> implements RelationProductSizeService {

	@Resource(name = "relationProductSizeDao", type = RelationProductSizeDao.class)
	private RelationProductSizeDao relationProductSizeDao;

	@Override
	public RelationProductSizeDao getDao() {

		return relationProductSizeDao;
	}

}

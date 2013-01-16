package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.RelationProductCategoryDao;
import com.liuzheng.gem.model.RelationProductCategory;
import com.liuzheng.gem.service.RelationProductCategoryService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "relationProductCategoryService")
@Transactional
public class RelationProductCategoryServiceImpl extends BaseServiceImpl<RelationProductCategory, Integer, RelationProductCategoryDao> implements RelationProductCategoryService {

	@Resource(name = "relationProductCategoryDao", type = RelationProductCategoryDao.class)
	private RelationProductCategoryDao relationProductCategoryDao;

	@Override
	public RelationProductCategoryDao getDao() {

		return relationProductCategoryDao;
	}

}

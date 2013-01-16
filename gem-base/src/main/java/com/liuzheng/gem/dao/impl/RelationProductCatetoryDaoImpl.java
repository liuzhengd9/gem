package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.RelationProductCategoryDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.RelationProductCategory;

@Repository(value = "relationProductCategoryDao")
public class RelationProductCatetoryDaoImpl extends BaseDaoImpl<RelationProductCategory, Integer> implements RelationProductCategoryDao {

	@Override
	public Class<RelationProductCategory> getPersistenceClass() {

		return RelationProductCategory.class;
	}

}

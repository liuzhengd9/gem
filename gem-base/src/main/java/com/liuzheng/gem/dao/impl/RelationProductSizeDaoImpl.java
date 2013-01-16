package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.RelationProductSizeDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.RelationProductSize;

@Repository(value = "relationProductSizeDao")
public class RelationProductSizeDaoImpl extends BaseDaoImpl<RelationProductSize, Integer> implements RelationProductSizeDao {

	@Override
	public Class<RelationProductSize> getPersistenceClass() {

		return RelationProductSize.class;
	}

}

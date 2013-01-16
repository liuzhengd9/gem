package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.RelationProductColorDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.RelationProductColor;

@Repository(value = "relationProductColorDao")
public class RelationProductColorDaoImpl extends BaseDaoImpl<RelationProductColor, Integer> implements RelationProductColorDao {

	@Override
	public Class<RelationProductColor> getPersistenceClass() {

		return RelationProductColor.class;
	}

}

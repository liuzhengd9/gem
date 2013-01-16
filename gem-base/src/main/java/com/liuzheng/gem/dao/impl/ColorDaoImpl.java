package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ColorDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Color;

@Repository(value = "colorDao")
public class ColorDaoImpl extends BaseDaoImpl<Color, Integer> implements ColorDao {

	@Override
	public Class<Color> getPersistenceClass() {

		return Color.class;
	}

}

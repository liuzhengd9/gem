package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.SizeDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Size;

@Repository(value = "sizeDao")
public class SizeDaoImpl extends BaseDaoImpl<Size, Integer> implements SizeDao {

	@Override
	public Class<Size> getPersistenceClass() {

		return Size.class;
	}

}

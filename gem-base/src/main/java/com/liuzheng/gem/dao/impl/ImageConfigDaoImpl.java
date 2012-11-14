package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ImageConfigDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.ImageConfig;

@Repository(value = "imageConfigDao")
public class ImageConfigDaoImpl extends BaseDaoImpl<ImageConfig, Integer> implements ImageConfigDao {

	@Override
	public Class<ImageConfig> getPersistenceClass() {

		return ImageConfig.class;
	}

}

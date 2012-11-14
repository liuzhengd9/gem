package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ImageTypeDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.ImageType;

@Repository(value = "imageTypeDao")
public class ImageTypeDaoImpl extends BaseDaoImpl<ImageType, Integer> implements ImageTypeDao {

	@Override
	public Class<ImageType> getPersistenceClass() {

		return ImageType.class;
	}

}

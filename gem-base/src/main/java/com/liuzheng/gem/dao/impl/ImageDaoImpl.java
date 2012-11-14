package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ImageDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Image;

@Repository(value = "imageDao")
public class ImageDaoImpl extends BaseDaoImpl<Image, Integer> implements ImageDao {

	@Override
	public Class<Image> getPersistenceClass() {

		return Image.class;
	}

}

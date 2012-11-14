package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ImageDao;
import com.liuzheng.gem.model.Image;
import com.liuzheng.gem.service.ImageService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "imageService")
@Transactional
public class ImageServiceImpl extends BaseServiceImpl<Image, Integer, ImageDao> implements ImageService {

	@Resource(name = "imageDao", type = ImageDao.class)
	private ImageDao imageDao;

	@Override
	public ImageDao getDao() {

		return imageDao;
	}

}

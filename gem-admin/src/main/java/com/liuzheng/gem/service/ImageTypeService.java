package com.liuzheng.gem.service;

import com.liuzheng.gem.dao.ImageTypeDao;
import com.liuzheng.gem.model.ImageType;
import com.liuzheng.gem.service.base.BaseService;

public interface ImageTypeService extends BaseService<ImageType, Integer, ImageTypeDao> {

	public void delete(Integer[] ids);
}

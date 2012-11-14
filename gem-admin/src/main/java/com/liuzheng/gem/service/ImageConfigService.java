package com.liuzheng.gem.service;

import com.liuzheng.gem.dao.ImageConfigDao;
import com.liuzheng.gem.model.ImageConfig;
import com.liuzheng.gem.service.base.BaseService;

public interface ImageConfigService extends BaseService<ImageConfig, Integer, ImageConfigDao> {

	public ImageConfig findByCode(String code);
}

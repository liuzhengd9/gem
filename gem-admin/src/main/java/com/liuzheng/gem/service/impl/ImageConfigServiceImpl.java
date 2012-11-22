package com.liuzheng.gem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ImageConfigDao;
import com.liuzheng.gem.model.ImageConfig;
import com.liuzheng.gem.service.ImageConfigService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "imageConfigService")
@Transactional
public class ImageConfigServiceImpl extends BaseServiceImpl<ImageConfig, Integer, ImageConfigDao> implements ImageConfigService {

	@Resource(name = "imageConfigDao", type = ImageConfigDao.class)
	private ImageConfigDao imageConfigDao;

	@Override
	public ImageConfigDao getDao() {

		return imageConfigDao;
	}

	@Override
	public ImageConfig findByCode(String code) {

		List<ImageConfig> list = ((ImageConfigService) AopContext.currentProxy()).find("from ImageConfig c where c.configCode=?", code);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

}

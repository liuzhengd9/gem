package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ColorDao;
import com.liuzheng.gem.model.Color;
import com.liuzheng.gem.service.ColorService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "colorService")
@Transactional
public class ColorServiceImpl extends BaseServiceImpl<Color, Integer, ColorDao> implements ColorService {

	@Resource(name = "colorDao", type = ColorDao.class)
	private ColorDao colorDao;

	@Override
	public ColorDao getDao() {

		return colorDao;
	}

}

package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ImageTypeDao;
import com.liuzheng.gem.exception.ServiceException;
import com.liuzheng.gem.model.ImageType;
import com.liuzheng.gem.service.ImageTypeService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "imageTypeService")
@Transactional
public class ImageTypeServiceImpl extends BaseServiceImpl<ImageType, Integer, ImageTypeDao> implements ImageTypeService {

	@Resource(name = "imageTypeDao", type = ImageTypeDao.class)
	private ImageTypeDao imageTypeDao;

	@Override
	public ImageTypeDao getDao() {

		return imageTypeDao;
	}

	@Override
	public void delete(Integer[] ids) {

		if (ids.length > 0) {
			StringBuilder hql = new StringBuilder("select count(id) from Image where imageType.id in (0");
			for (int id : ids) {
				hql.append(",").append(id);
			}
			hql.append(")");
			int count = imageTypeDao.count(hql.toString(), null);
			if (count > 0) {
				throw new ServiceException("该图片类型正在使用，无法删除！");
			}
		}
		((ImageTypeService) AopContext.currentProxy()).delete(ids);
	}

}

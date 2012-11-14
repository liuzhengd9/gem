package com.liuzheng.gem.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.liuzheng.gem.dao.ImageTypeDao;
import com.liuzheng.gem.test.BaseTest;

public class ImageTypeDaoImplTest extends BaseTest {

	@Resource(name = "imageTypeDao", type = ImageTypeDao.class)
	private ImageTypeDao imageTypeDao;

	@Test
	public void count() {

		StringBuilder hql = new StringBuilder("select count(type.id) from ImageType type where type.id in (0)");
		int count = imageTypeDao.count(hql.toString(), null);
		System.out.println(count);
	}

}

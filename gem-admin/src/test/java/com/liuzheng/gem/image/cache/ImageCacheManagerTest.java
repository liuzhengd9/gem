package com.liuzheng.gem.image.cache;

import javax.annotation.Resource;

import org.junit.Test;

import com.liuzheng.gem.test.BaseTest;

public class ImageCacheManagerTest extends BaseTest {

	@Resource(name = "imageCacheManager", type = ImageCacheManager.class)
	private ImageCacheManager imageCacheManager;

	@Test
	public void get() {

		imageCacheManager.getImage("/2012/11/07/21230137890955069873.jpg");
		imageCacheManager.evictImage("/2012/11/07/21230137890955069873.jpg");
	}

}

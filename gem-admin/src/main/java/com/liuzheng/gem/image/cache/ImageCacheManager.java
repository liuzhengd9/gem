package com.liuzheng.gem.image.cache;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "imageCacheManager")
public class ImageCacheManager {

	private final Logger logger = Logger.getLogger(getClass());

	@Value(value = "${image.path}")
	private String imagePath;

	@Cacheable(value = "imageCache", key = "#root.caches[0].name+'-'+#p0")
	public byte[] getImage(String fileRelativePath) {

		logger.info("getImage method running...");
		byte[] file = null;
		try {
			file = FileUtils.readFileToByteArray(new File(imagePath + fileRelativePath));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return file;
	}

	@CacheEvict(value = "imageCache", key = "#root.caches[0].name+'-'+#p0")
	public void evictImage(String fileRelativePath) {

		logger.info("evictImage method running...");
	}

}

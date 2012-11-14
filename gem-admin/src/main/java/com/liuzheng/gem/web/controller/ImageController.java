package com.liuzheng.gem.web.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.liuzheng.gem.common.Common;
import com.liuzheng.gem.common.PageDataBean;
import com.liuzheng.gem.image.cache.ImageCacheManager;
import com.liuzheng.gem.model.Image;
import com.liuzheng.gem.service.ImageService;
import com.liuzheng.gem.service.ImageTypeService;
import com.liuzheng.gem.util.JsonUtils;

@Controller
public class ImageController {

	private final Logger logger = Logger.getLogger(getClass());

	@Value(value = "${image.path}")
	private String imagePath;

	@Value(value = "${image.server.url.prefix}")
	private String imageServerUrlPrefix;

	@Resource(name = "imageService", type = ImageService.class)
	private ImageService imageService;

	@Resource(name = "imageTypeService", type = ImageTypeService.class)
	private ImageTypeService imageTypeService;

	@Resource(name = "imageCacheManager", type = ImageCacheManager.class)
	private ImageCacheManager imageCacheManager;

	@RequestMapping(value = "/image/index.html")
	public String index() {

		logger.info("imagePath:" + imagePath);
		return "image/image";
	}

	@RequestMapping(value = "/image/list.html")
	@ResponseBody
	public PageDataBean<Image> list(HttpServletRequest request) {

		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		int limit = ServletRequestUtils.getIntParameter(request, "limit", 20);
		String name = ServletRequestUtils.getStringParameter(request, "name", "");
		String[] sort = JsonUtils.getSort(ServletRequestUtils.getStringParameter(request, "sort", ""), new String[] { "id", "asc" });
		logger.info("start:" + start);
		logger.info("limit:" + limit);
		logger.info("name:" + name);
		Map<String, Object[]> params = new HashMap<String, Object[]>();
		if (StringUtils.hasText(name)) {
			params.put("and name like ?", new String[] { "%" + name + "%" });
		}
		return imageService.findPageDataBean("Image", params, start, limit, sort[0], sort[1]);
	}

	@RequestMapping(value = "/image/delete.html")
	@ResponseBody
	public ModelMap delete(@RequestParam(value = "id") Integer[] ids) {

		ModelMap model = new ModelMap();
		logger.info("id:" + ids);
		imageService.delete(ids);
		model.addAttribute("success", true);
		model.addAttribute("msg", "删除成功");
		return model;
	}

	@RequestMapping(value = "/image/persist.html")
	@ResponseBody
	public ModelMap persist(HttpServletRequest request) throws ServletException {

		ModelMap model = new ModelMap();
		int id = ServletRequestUtils.getIntParameter(request, "id", 0);
		int imageTypeId = ServletRequestUtils.getRequiredIntParameter(request, "imageTypeId");
		String name = ServletRequestUtils.getRequiredStringParameter(request, "name");
		String description = ServletRequestUtils.getStringParameter(request, "description");

		logger.info("imageTypeId:" + imageTypeId);
		logger.info("name:" + name);
		logger.info("description:" + description);
		Image image = new Image();
		if (id > 0) {
			image = imageService.get(id);
		}
		image.setName(name);
		image.setDescription(description);
		image.setImageType(imageTypeService.get(imageTypeId));

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");
		File destFile = null;
		StringBuilder sb = new StringBuilder(imagePath).append(Common.DIR_FORMAT.format(new Date()));
		File dirFile = new File(sb.toString());
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		if (!multipartFile.isEmpty()) {
			String fileName = multipartFile.getOriginalFilename();
			String imageName = RandomStringUtils.randomNumeric(20) + fileName.substring(fileName.lastIndexOf("."));
			destFile = new File(sb.append(imageName).toString());
			try {
				if (id > 0 && StringUtils.hasText(image.getRelativePath())) {
					multipartFile.transferTo(new File(imagePath + image.getRelativePath()));
					imageCacheManager.evictImage(image.getRelativePath());
				} else {
					multipartFile.transferTo(destFile);
					image.setRelativePath(sb.substring(imagePath.length()));
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				model.addAttribute("success", false);
				model.addAttribute("msg", "文件上传失败，请重试！");
				return model;
			}
		}

		imageService.saveOrUpdate(image);
		model.addAttribute("success", true);
		model.addAttribute("msg", "添加成功");
		return model;
	}

	@RequestMapping(value = "/image/load.html")
	@ResponseBody
	public ModelMap load(HttpServletRequest request, @RequestParam(value = "id") Integer id) {

		ModelMap model = new ModelMap();
		Image image = imageService.get(id);
		StringBuilder sb = new StringBuilder(imageServerUrlPrefix).append(image.getRelativePath());
		image.setRelativePath(sb.toString());
		model.addAttribute("success", true);
		model.addAttribute("data", image);
		return model;
	}
}

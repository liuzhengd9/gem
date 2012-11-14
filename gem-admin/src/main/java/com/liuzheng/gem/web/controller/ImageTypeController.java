package com.liuzheng.gem.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuzheng.gem.common.PageDataBean;
import com.liuzheng.gem.model.ImageType;
import com.liuzheng.gem.service.ImageTypeService;
import com.liuzheng.gem.util.JsonUtils;

@Controller
public class ImageTypeController {

	private final Logger logger = Logger.getLogger(getClass());

	@Resource(name = "imageTypeService", type = ImageTypeService.class)
	private ImageTypeService imageTypeService;

	@RequestMapping(value = "/imageType/index.html")
	public String index() {

		return "image/imageType";
	}

	@RequestMapping(value = "/imageType/list.html")
	@ResponseBody
	public PageDataBean<ImageType> list(HttpServletRequest request) {

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
		return imageTypeService.findPageDataBean("ImageType", params, start, limit, sort[0], sort[1]);
	}

	@RequestMapping(value = "/imageType/delete.html")
	@ResponseBody
	public ModelMap delete(@RequestParam(value = "id") Integer[] ids) {

		ModelMap model = new ModelMap();
		logger.info("id:" + ids);
		try {
			imageTypeService.delete(ids);
			model.addAttribute("success", true);
			model.addAttribute("msg", "删除成功");
			return model;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			model.addAttribute("success", false);
			model.addAttribute("msg", e.getMessage());
			return model;
		}
	}

	@RequestMapping(value = "/imageType/persist.html")
	@ResponseBody
	public ModelMap persist(HttpServletRequest request) throws ServletException {

		ModelMap model = new ModelMap();
		int id = ServletRequestUtils.getIntParameter(request, "id", 0);
		String name = ServletRequestUtils.getRequiredStringParameter(request, "name");
		String description = ServletRequestUtils.getStringParameter(request, "description");
		logger.info("name:" + name);
		logger.info("description:" + description);
		ImageType imageType = new ImageType();
		if (id > 0) {
			imageType.setId(id);
		}
		imageType.setName(name);
		imageType.setDescription(description);
		imageTypeService.saveOrUpdate(imageType);
		model.addAttribute("success", true);
		model.addAttribute("msg", "添加成功");
		return model;
	}

	@RequestMapping(value = "/imageType/load.html")
	@ResponseBody
	public ModelMap load(@RequestParam(value = "id") Integer id) {

		ModelMap model = new ModelMap();
		model.addAttribute("success", true);
		model.addAttribute("data", imageTypeService.get(id));
		return model;
	}
}

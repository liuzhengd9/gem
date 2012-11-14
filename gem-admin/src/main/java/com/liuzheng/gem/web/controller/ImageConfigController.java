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
import com.liuzheng.gem.model.ImageConfig;
import com.liuzheng.gem.service.ImageConfigService;
import com.liuzheng.gem.util.JsonUtils;

@Controller
public class ImageConfigController {

	private final Logger logger = Logger.getLogger(getClass());

	@Resource(name = "imageConfigService", type = ImageConfigService.class)
	private ImageConfigService imageConfigService;

	@RequestMapping(value = "/imageConfig/index.html")
	public String index() {

		return "config/imageConfig";
	}

	@RequestMapping(value = "/imageConfig/list.html")
	@ResponseBody
	public PageDataBean<ImageConfig> list(HttpServletRequest request) {

		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		int limit = ServletRequestUtils.getIntParameter(request, "limit", 20);
		String configCode = ServletRequestUtils.getStringParameter(request, "configCode", "");
		String[] sort = JsonUtils.getSort(ServletRequestUtils.getStringParameter(request, "sort", ""), new String[] { "id", "asc" });
		logger.info("start:" + start);
		logger.info("limit:" + limit);
		logger.info("configCode" + configCode);
		Map<String, Object[]> params = new HashMap<String, Object[]>();
		if (StringUtils.hasText(configCode)) {
			params.put("and configCode like ?", new String[] { "%" + configCode + "%" });
		}
		return imageConfigService.findPageDataBean("ImageConfig", params, start, limit, sort[0], sort[1]);
	}

	@RequestMapping(value = "/imageConfig/delete.html")
	@ResponseBody
	public ModelMap delete(@RequestParam(value = "id") Integer[] ids) {

		ModelMap model = new ModelMap();
		logger.info("id:" + ids);
		try {
			imageConfigService.delete(ids);
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

	@RequestMapping(value = "/imageConfig/persist.html")
	@ResponseBody
	public ModelMap persist(HttpServletRequest request) throws ServletException {

		ModelMap model = new ModelMap();
		int id = ServletRequestUtils.getIntParameter(request, "id", 0);
		String configCode = ServletRequestUtils.getRequiredStringParameter(request, "configCode");
		String configValue = ServletRequestUtils.getRequiredStringParameter(request, "configValue");
		String description = ServletRequestUtils.getStringParameter(request, "description");
		logger.info("configCode:" + configCode);
		logger.info("configValue:" + configValue);
		logger.info("description:" + description);
		ImageConfig imageConfig = new ImageConfig();
		if (id > 0) {
			imageConfig.setId(id);
		}
		imageConfig.setConfigCode(configCode);
		imageConfig.setConfigValue(configValue);
		imageConfig.setDescription(description);
		imageConfigService.saveOrUpdate(imageConfig);
		model.addAttribute("success", true);
		model.addAttribute("msg", "添加成功");
		return model;
	}

	@RequestMapping(value = "/imageConfig/load.html")
	@ResponseBody
	public ModelMap load(@RequestParam(value = "id") Integer id) {

		ModelMap model = new ModelMap();
		model.addAttribute("success", true);
		model.addAttribute("data", imageConfigService.get(id));
		return model;
	}
}

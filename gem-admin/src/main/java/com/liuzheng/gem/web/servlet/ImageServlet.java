package com.liuzheng.gem.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.liuzheng.gem.image.cache.ImageCacheManager;

public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = -8363334168620706831L;

	private final Logger logger = Logger.getLogger(getClass());

	private WebApplicationContext context;

	private List<String> imgExtList = new ArrayList<String>();

	private ImageCacheManager imageCacheManager;

	public void init(ServletConfig config) {

		this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		this.imageCacheManager = this.context.getBean("imageCacheManager", ImageCacheManager.class);

		String imgExtStr = config.getInitParameter("imgExts");
		if (StringUtils.hasText(imgExtStr)) {
			String[] exts = imgExtStr.split(",");
			for (String ext : exts) {
				imgExtList.add(ext);
			}
		}
	}

	public void service(HttpServletRequest request, HttpServletResponse response) {

		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String requestUri = request.getRequestURI();
		logger.info("contextPath:" + contextPath);
		logger.info("servletPath:" + servletPath);
		logger.info("requestUri:" + requestUri);
		boolean flag = false;
		for (String imgExt : imgExtList) {
			if (requestUri.toLowerCase().endsWith(imgExt.trim())) {
				flag = true;
				break;
			}
		}
		if (flag) {
			ServletOutputStream out = null;
			byte[] file = imageCacheManager.getImage(requestUri.substring(contextPath.length() + servletPath.length()));
			if (ArrayUtils.isNotEmpty(file)) {
				try {
					out = response.getOutputStream();
					out.write(file);
					out.flush();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				} finally {
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							logger.error(e.getMessage(), e);
						}
					}
				}
			}
		}
	}
}

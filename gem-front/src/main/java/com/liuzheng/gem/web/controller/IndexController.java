package com.liuzheng.gem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/index.html")
	public String welcome() {

		return "welcome";
	}
}

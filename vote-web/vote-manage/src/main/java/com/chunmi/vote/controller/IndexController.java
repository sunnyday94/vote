package com.chunmi.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	/**
	 * 登录页
	 * @param model
	 * @return
	 */
	@GetMapping(value = {"/",""})
	public String index(Model model) {
		return "redirect:admin/login";
	}
	
}

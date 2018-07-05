package com.sound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/maintain")
public class UserMaintainController {

	@RequestMapping(path = "/main")
	public String userMain() {
		return "user/main";
	}
}

package com.jovemprogramador.eventosapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// @RequestMapping("/login")
	// public String login() {
	// return "login";
	// }

	// @RequestMapping("/logout")
	// public String logout() {
	// return "login";
	// }

}

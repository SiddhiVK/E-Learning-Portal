package com.amdocs.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/home")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/index")
	public String IndexPage() {
		return "index";
	}
	
	@GetMapping("/admin_home")
	public String AdminHomePage() {
		return "admin_home";
	}
}

package com.amdocs.training.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.model.Auth;

@Controller
@SessionAttributes("auth")
public class LogoutController {

	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		Auth auth = new Auth(null,null,null);
		mv.addObject("auth", auth);
		mv.setViewName("index");
		return mv;
	}
}

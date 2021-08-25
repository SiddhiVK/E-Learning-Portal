package com.amdocs.training.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.Auth;
import com.amdocs.training.model.User;

@Controller
@SessionAttributes("auth")
public class LoginController {

	@GetMapping("/user_login")
	public String user_login() {
		return "user_login";
	}
	
	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("**********************"+username+":"+password+"**********************");
		UserDAO dao = new UserDAOImpl();
		User user = dao.validateUser(username, password);
		 if (null != user) {
			Auth auth = new Auth(user.getName(), user, "USER");
			System.out.println("User "+user.getUser_id()+" is authenticated!");
			mv.addObject("user", user);
			mv.addObject("auth", auth);
			mv.setViewName("home");
		}
		else {
			System.out.println("Error while Validating User "+username+" !");
			mv.setViewName("error");
		}
		return mv;
	}
//Admin login controller

	@GetMapping("/admin_login")
	public String admin_login() {
		return "admin_login";
	}
	
	@PostMapping("/adminLoginProcess")
	public ModelAndView adminLoginProcess(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("**********************"+username+":"+password+"**********************");
		AdminDAO dao = new AdminDAOImpl();
		Admin admin = dao.validateAdmin(username, password);
		 if (null != admin) {
			Auth auth = new Auth(admin.getName(), admin, "ADMIN");
			System.out.println("Admin "+admin.getId()+" is authenticated!");
			mv.addObject("admin", admin);
			mv.addObject("auth", auth);
			mv.setViewName("admin_home");
		}
		else {
			System.out.println("Error while Validating Admin "+username+" !");
			mv.setViewName("error");
		}
		return mv;
	}
}
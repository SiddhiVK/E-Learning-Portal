package com.amdocs.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.model.Admin;

@Controller
public class AdminController {

//Admin Registration Controller

	@GetMapping("/admin_registration")
	public String adminsign_up() {
		return "admin_registration";
	}
	
	@PostMapping("/adminregistrationProcess")
	public ModelAndView adminsign_up(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin admin = new Admin(null, username, email, password);
		System.out.println("**********************"+admin+"**********************");
		AdminDAO dao = new AdminDAOImpl();
		if(dao.saveAdmin(admin)) {
			System.out.println("Admin "+admin.getName()+" added in database!");
			mv.setViewName("home");
		}
		else {
			System.out.println("Error while adding Admin "+admin.getName()+" in database!");
			mv.setViewName("error");
		}
		return mv;
	}

	@GetMapping("/admins")
	public ModelAndView admins() {
		AdminDAO dao = new AdminDAOImpl();
		List<Admin> admins = dao.findAll();
		for(Admin i: admins) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("admins", admins);
		mv.setViewName("all_admins");
		
		return mv;
	}
}

package com.amdocs.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

@Controller
public class UserController {

	@GetMapping("/user_registration")
	public String sign_up() {
		return "user_registration";
	}
	
	@PostMapping("/registrationProcess")
	public ModelAndView sign_up(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String reg_date = request.getParameter("reg_date");
		String password = request.getParameter("password");
		String upload_photo = request.getParameter("upload_photo");

		User user = new User(null, username,phone,email,address,reg_date, password,upload_photo);

		UserDAO dao = new UserDAOImpl();
		if(dao.saveUser(user)) {
			mv.addObject("username", user.getName());
			mv.setViewName("user_login");
		}
		else {
			mv.setViewName("error");
		}
		return mv;
	}

	@GetMapping("/users")
	public ModelAndView all_users() {
		UserDAO dao = new UserDAOImpl();
		List<User> users = dao.findAll();
		for(User i: users) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", users);
		mv.setViewName("all_users");
		
		return mv;
	}
	
	@PostMapping("/delete_user")
	public ModelAndView delete_user(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:/logout");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		System.out.println("ID : " +user_id);
		UserDAO dao = new UserDAOImpl();
		if(dao.deleteUser(user_id)) {
			System.out.println("User Deleted Successfully!!");
		}
		else {
			System.out.println("Error while deleting user");
			mv.setViewName("error");
		}
		return mv;
	}
	
	@PostMapping("/update_user")
	public String update_user() {
		return "update_user";
	}
	
	@PostMapping("/edit_user")
	public ModelAndView userUpdate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("name");
		long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String upload_photo = request.getParameter("upload_photo");

		User user = new User(user_id, username,phone,email,address,null, password,upload_photo);
		UserDAO dao = new UserDAOImpl();
		if(dao.updateUser(user)) {
			System.out.println("User Updated Successfully!!");
			mv.setViewName("home");
		}
		else {
			System.out.println("Error while updating User in database!");
			mv.setViewName("error");
		}
		return mv;
	}
}

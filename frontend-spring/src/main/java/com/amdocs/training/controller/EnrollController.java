package com.amdocs.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.EnrollDAO;
import com.amdocs.training.dao.impl.EnrollDAOImpl;
import com.amdocs.training.model.Enroll;

@Controller
public class EnrollController {

	
	@PostMapping("/enrollProcess")
	public ModelAndView sign_up(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:/courses");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		String name = request.getParameter("name");
		String course_name = request.getParameter("course_name");
		
		Enroll enroll = new Enroll(course_id,course_name,user_id,name);
		System.out.println("**********************"+enroll+"**********************");
		EnrollDAO dao = new EnrollDAOImpl();
		if(dao.saveEnroll(enroll)) {
			System.out.println("User "+enroll.getUser_id()+" added in database!");
//			mv.addObject("username", enroll.getUser_id());
//			mv.addObject("redirect", "courses");
//			mv.setViewName("all_courses");
		}
		else {
			System.out.println("Error while adding User "+enroll.getUser_id()+" in database!");
			mv.setViewName("error");
		}
		return mv;
	}

	@GetMapping("/enrolledcourses")
	public ModelAndView all_users() {
		EnrollDAO dao = new EnrollDAOImpl();
		List<Enroll> ec = dao.findAll();
		for(Enroll i: ec) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("ec", ec);
		mv.setViewName("enrolled_courses");
		
		return mv;
	}

	@GetMapping("/profile")
	public ModelAndView my_courses() {
		EnrollDAO dao = new EnrollDAOImpl();
		List<Enroll> ec = dao.findAll();
		for(Enroll i: ec) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("ec", ec);
		mv.setViewName("user_profile");
		
		return mv;
	}
	
//	@GetMapping("/user/{id}")
//	public User getUser(@PathVariable int id) {
//		User user = dao.getUserById(id);
//		return user;
//	}
//	@GetMapping("/users")
//	public List<User> getAllUser() {
//		List<User> list = dao.findAll();
//		return list;
//	
//	}
//	@GetMapping("/reg")
//	public List<User> setUser() {
//		return list;
//	
//	}
}
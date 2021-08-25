package com.amdocs.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.dao.impl.CourseDAOImpl;
import com.amdocs.training.model.Course;

@Controller
public class CourseController {

	@GetMapping("/add_course")
	public String add_course() {
		return "add_course";
	}
	
	@PostMapping("/submit_course")
	public ModelAndView submit_course(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String c_name = request.getParameter("c_name");
		int c_fees = Integer.parseInt(request.getParameter("c_fees"));
		String c_desp = request.getParameter("c_desp");
		String c_resource = request.getParameter("c_resource");

		Course course = new Course(null, c_name, c_fees, c_desp, c_resource);
		System.out.println("**********************"+course+"**********************");
		CourseDAO dao = new CourseDAOImpl();
		if(dao.saveCourse(course)) {
			System.out.println("Course "+course.getCourse_name()+" added in database!");
			mv.addObject("c_name", course.getCourse_name());
			mv.setViewName("home");
		}
		else {
			System.out.println("Error while adding Course from "+course.getCourse_name()+" in database!");
			mv.setViewName("error");
		}
		return mv;
	}

	@GetMapping("/courses")
	public ModelAndView all_courses() {
		CourseDAO cdao = new CourseDAOImpl();
		List<Course> courses = cdao.findAll();
		
		for(Course i: courses) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("courses", courses);
		mv.setViewName("all_courses");
		
		return mv;
	}
	
	@PostMapping("/update_course")
	public ModelAndView update_course(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		
		CourseDAO dao = new CourseDAOImpl();
		Course course = dao.getCourseById(course_id);
		
		System.out.println("Inside Update course [course id] : " + course_id);
		
		mv.addObject("course",course);
		mv.setViewName("update_course");
		
		return mv;
	}
	
	@PostMapping("/edit_course")
	public ModelAndView edit_course(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int c_id = Integer.parseInt(request.getParameter("course_id"));
		String c_name = request.getParameter("course_name");
		int c_fees = Integer.parseInt(request.getParameter("course_fees"));
		String c_desp = request.getParameter("course_desc");
		String c_resource = request.getParameter("course_resource");

		Course course = new Course(c_id, c_name, c_fees, c_desp, c_resource);
		System.out.println("**********************"+course+"**********************");
		CourseDAO dao = new CourseDAOImpl();
		if(dao.updateCourse(course)) {
			System.out.println("Course Updated Successfully!");
			mv.setViewName("home");
		}
		else {
			System.out.println("Error while updating Course!");
			mv.setViewName("error");
		}
		return mv;
		
	}
	
	@PostMapping("/delete_course")
	public ModelAndView delete_course(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:/courses");
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		
		System.out.println("ID : " +course_id);
		CourseDAO dao = new CourseDAOImpl();
		if(dao.deleteCourse(course_id)) {
			System.out.println("Course Deleted Successfully!!");
//			mv.addObject("username", enroll.getUser_id());
//			mv.addObject("redirect", "courses");
//			mv.setViewName("all_courses");
		}
		else {
			System.out.println("Error while deleting course");
			mv.setViewName("error");
		}
		return mv;
	}
}

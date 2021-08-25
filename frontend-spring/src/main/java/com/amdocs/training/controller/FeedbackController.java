package com.amdocs.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.impl.FeedbackDAOImpl;
import com.amdocs.training.model.Feedback;

@Controller
public class FeedbackController {

	@GetMapping("/add_feedback")
	public String add_feedback() {
		return "add_feedback";
	}
	
	@PostMapping("/submit_feedback")
	public ModelAndView submit_feeback(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Integer user_id = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String fb = request.getParameter("feedback");

		Feedback feedback = new Feedback(user_id, username, email, null, fb);
		System.out.println("**********************"+feedback+"**********************");
		FeedbackDAO dao = new FeedbackDAOImpl();
		if(dao.saveFeedback(feedback)) {
			System.out.println("Feedback From "+feedback.getUser_id()+" added in database!");
			mv.addObject("username", feedback.getName());
			mv.setViewName("home");
		}
		else {
			System.out.println("Error while adding Feedback from "+feedback.getUser_id()+" in database!");
			mv.setViewName("error");
		}
		return mv;
	}

	@GetMapping("/feedbacks")
	public ModelAndView all_feedback() {
		FeedbackDAO dao = new FeedbackDAOImpl();
		List<Feedback> feedbacks = dao.findAll();
		for(Feedback i: feedbacks) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("feedbacks", feedbacks);
		mv.setViewName("all_feedbacks");
		
		return mv;
	}
}

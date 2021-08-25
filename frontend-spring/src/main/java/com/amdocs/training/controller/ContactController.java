package com.amdocs.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.dao.impl.ContactDAOImpl;
import com.amdocs.training.model.Contact;

@Controller
public class ContactController {

	@GetMapping("/add_contact")
	public String add_contact() {
		return "add_contact";
	}
	
	@PostMapping("/submit_contact")
	public ModelAndView submit_feeback(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Integer user_id = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone")); 
		String message = request.getParameter("message");

		Contact contact = new Contact(user_id, username, email, phone,  message, null);
		ContactDAO dao = new ContactDAOImpl();
		if(dao.saveContact(contact)) {
			System.out.println("Contact From "+contact.getUser_id()+" added in database!");
			mv.addObject("username", contact.getName());
			mv.setViewName("home");
		}
		else {
			mv.setViewName("error");
		}
		return mv;
	}

	@GetMapping("/contacts")
	public ModelAndView all_contacts() {
		ContactDAO dao = new ContactDAOImpl();
		List<Contact> contacts = dao.findAll();
		for(Contact i: contacts) {
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("contacts", contacts);
		mv.setViewName("all_contacts");
		
		return mv;
	}
}
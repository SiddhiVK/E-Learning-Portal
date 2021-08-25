package com.amdocs.training.model;

public class Feedback {
	private Integer user_id;
	private String name;
	private String email;
	private Integer feedback_id;
	private String feedback;
	public Feedback(Integer user_id, String name, String email, Integer feedback_id, String feedback) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.feedback_id = feedback_id;
		this.feedback = feedback;
	}
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(Integer feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}

package com.amdocs.training.model;

public class Enroll {
	private Integer user_id;
	private Integer Course_id;
	private String user_name;
	private String course_name;
	
	public Enroll() {System.out.println("created");}

	public Enroll(Integer course_id, String course_name,Integer user_id, String user_name) {
		super();
		this.user_id = user_id;
		Course_id = course_id;
		this.user_name = user_name;
		this.course_name = course_name;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String name) {
		this.user_name = name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCourse_id() {
		return Course_id;
	}

	public void setCourse_id(Integer course_id) {
		Course_id = course_id;
	}

	@Override
	public String toString() {
		return "Enroll [user_id=" + user_id + ", Course_id=" + Course_id + "User_name "+ user_name + "]";
	}
	
}

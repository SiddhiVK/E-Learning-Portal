package com.amdocs.training.model;

public class Course {
	private Integer course_id;
	private String course_name;
	private int course_fees;
	private String course_desc;
	private String course_resource;
	public Course(Integer course_id, String course_name, int course_fees, String course_desc, String course_resource) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_fees = course_fees;
		this.course_desc = course_desc;
		this.course_resource = course_resource;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCourse_fees() {
		return course_fees;
	}
	public void setCourse_fees(int course_fees) {
		this.course_fees = course_fees;
	}
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	public String getCourse_resource() {
		return course_resource;
	}
	public void setCourse_resource(String course_resource) {
		this.course_resource = course_resource;
	}
	
	
}

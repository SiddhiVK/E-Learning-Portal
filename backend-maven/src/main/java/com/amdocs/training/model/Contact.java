package com.amdocs.training.model;

public class Contact {
	private Integer user_id;
	private String name;
	private String email;
	private long phone;
	private String message;
	private Integer contact_id;
	
	public Contact(Integer user_id, String name, String email, long phone, String message, Integer contact_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
		this.contact_id = contact_id;
	}

	public Contact() {
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getContact_id() {
		return contact_id;
	}

	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
	}
	
	
	
}

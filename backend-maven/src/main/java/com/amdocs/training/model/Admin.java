package com.amdocs.training.model;

public class Admin {
	private Integer admin_id;
	private String name;
	private String password;
	private String email;
	
	public Admin(Integer admin_id, String name, String password, String email) {
		super();
		this.admin_id = admin_id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return admin_id;
	}

	public void setId(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

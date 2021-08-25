package com.amdocs.training.model;

public class User {
	private Integer user_id;
	private String name;
	private long phone;
	private String email;
	private String address;
	private String reg_date;
	private String password;
	private String upload_photo;
	public User(Integer user_id, String name, long phone, String email, String address, String reg_date, String password,
			String upload_photo) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.reg_date = reg_date;
		this.password = password;
		this.upload_photo = upload_photo;
	}
	public User() {
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUpload_photo() {
		return upload_photo;
	}
	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}
	
	
}

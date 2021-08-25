package com.amdocs.training.model;

public class Auth {
	private String username;
	private Object obj;
	private String roll;
	
	public Auth() {System.out.println("created");}

	public Auth(String username, Object obj, String roll) {
		super();
		this.username = username;
		this.obj = obj;
		this.roll = roll;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Auth [username=" + username + ", obj=" + obj + ", roll=" + roll + "]";
	}

}